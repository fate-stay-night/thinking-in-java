package xyz.vimtool.chapter20.section5;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import net.mindview.util.BinaryFile;
import net.mindview.util.ProcessFiles;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 移除测试代码
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-14
 */
public class AtUnitRemover implements ProcessFiles.Strategy {

    private static boolean remove = false;

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("-r")) {
            remove = true;
            String[] nargs = new String[args.length - 1];
            System.arraycopy(args, 1, nargs, 0, nargs.length);
            args = nargs;
        }

        new ProcessFiles(new AtUnitRemover(), "class").start(args);
    }

    @Override
    public void process(File file) {
        boolean modified = false;

        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.read(file));
            if (!cName.contains(".")) {
                return;// Ignore unpackaged classes
            }

            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.getCtClass(cName);

            for (CtMethod method : ctClass.getDeclaredMethods()) {
                MethodInfo mi = method.getMethodInfo();
                AnnotationsAttribute attribute = (AnnotationsAttribute) mi.getAttribute(AnnotationsAttribute.visibleTag);

                if (attribute == null) {
                    continue;
                }

                for (Annotation annotation : attribute.getAnnotations()) {
                    if (annotation.getTypeName().startsWith("xyz.vimtool.chapter20.section5")) {
                        System.out.println(ctClass.getName() + " Method: " + mi.getName() + " " + annotation);

                        if (remove) {
                            ctClass.removeMethod(method);
                            modified = true;
                        }
                    }
                }
            }

            //Fields are not removed in this version (see text).
            if (modified) {
                ctClass.toBytecode(new DataOutputStream(new FileOutputStream(file)));
            }
            ctClass.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
