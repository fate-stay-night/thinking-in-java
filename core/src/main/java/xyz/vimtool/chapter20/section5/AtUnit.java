package xyz.vimtool.chapter20.section5;

import net.mindview.util.BinaryFile;
import net.mindview.util.ProcessFiles;
import xyz.vimtool.chapter20.section1.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解解释器
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-14
 */
public class AtUnit implements ProcessFiles.Strategy {
    public static Class<?> testClass;

    public static List<String> failedTests = new ArrayList<>();

    public static long testsRun = 0;

    public static long failures = 0;

    public static void mainProcess(String[] nameArray) {
        //Enable asserts
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        new ProcessFiles(new AtUnit(), "class").start(nameArray);

        if (failures == 0) {
            System.out.println("OK (" + testsRun + " tests");
        } else {
            System.out.println("(" + testsRun + "tests)");
            System.out.println("\n>>> " + failures + " FAILURE" + (failures > 1 ? "S" : "") + "<<<");

            for (String failed : failedTests) {
                System.out.println(" " + failed);
            }
        }
    }

    @Override
    public void process(File cFile) {
        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.read(cFile));
            if (!cName.contains(".")) {
                return; //Ignore unpacked classes
            }

            testClass = Class.forName(cName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        TestMethods testMethods = new TestMethods();
        Method creator = null;

        Method cleanup = null;

        for (Method m : testClass.getDeclaredMethods()) {
            testMethods.addIfTestMethod(m);

            if (creator == null) {
                creator = checkForCreatorMethod(m);
            }

            if (cleanup == null) {
                cleanup = checkForCleanupMethod(m);
            }
        }

        if (testMethods.size() > 0) {
            if (creator == null) {
                try {
                    if (!Modifier.isPublic(testClass.getDeclaredConstructor().getModifiers())) {
                        System.out.println("Error: " + testClass + " default constructor must be public");
                        System.exit(1);
                    }
                } catch (NoSuchMethodException e) {
                    //Synthesized default constructor; OK
                }
            }
            System.out.println(testClass.getName());
        }

        for (Method m : testMethods) {
            System.out.print(" . " + m.getName() + " ");
            try {
                Object testObject = createTestObject(creator);
                boolean success = false;

                try {
                    if (m.getReturnType().equals(boolean.class)) {
                        success = (Boolean) m.invoke(testObject);
                    } else {
                        m.invoke(testObject);
                        //If no assert fails
                        success = true;
                    }
                } catch (InvocationTargetException e) {
                    //Actual exception is inside e:
                    System.out.println(e.getCause());
                }

                System.out.println(success ? "" : "(failed)");

                testsRun++;
                if (!success) {
                    failures++;
                    failedTests.add(testClass.getName() + ": " + m.getName());
                }

                if (cleanup != null) {
                    cleanup.invoke(testObject, testObject);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class TestMethods extends ArrayList<Method> {
        void addIfTestMethod(Method m) {
            if (m.getAnnotation(Test.class) == null) {
                return;
            }

            if (!(m.getReturnType().equals(boolean.class) || m.getReturnType().equals(void.class))) {
                throw new RuntimeException("@Test method must return boolean or void");
            }

            // In case it's private. etc.
            m.setAccessible(true);
            add(m);
        }
    }

    static Method checkForCreatorMethod(Method m) {
        if (m.getAnnotation(TestObjectCreate.class) == null) {
            return null;
        }

        if (!m.getReturnType().equals(testClass)) {
            throw new RuntimeException("@TestObjectCreate must return instance of Class to be tested");
        }

        if ((m.getModifiers() & Modifier.STATIC) < 1) {
            throw new RuntimeException("@TestObjectCreate must be static.");
        }

        m.setAccessible(true);
        return m;
    }

    static Method checkForCleanupMethod(Method m) {
        if (m.getAnnotation(TestObjectCleanup.class) == null) {
            return null;
        }

        if (!m.getReturnType().equals(void.class)) {
            throw new RuntimeException("@TestObjectCleanup must return void");
        }

        if ((m.getModifiers() & Modifier.STATIC) < 1) {
            throw new RuntimeException("@TestObjectCleanup must be static.");
        }

        if (m.getParameterTypes().length == 0 || m.getParameterTypes()[0] != testClass) {
            throw new RuntimeException("@TestObjectCleanup must take an argument of the tested type.");
        }

        m.setAccessible(true);
        return m;
    }

    static Object createTestObject(Method creator) {
        if (creator != null) {
            try {
                return creator.invoke(testClass);
            } catch (Exception e) {
                throw new RuntimeException("Couldn't run @TestObject (creator) method.");
            }
        } else { //Use the default constructor
            try {
                return testClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Couldn't create a test object. Try using a @TestObject method.");
            }
        }
    }
}
