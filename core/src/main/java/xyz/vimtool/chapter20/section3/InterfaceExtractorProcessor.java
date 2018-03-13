package xyz.vimtool.chapter20.section3;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-8
 */
public class InterfaceExtractorProcessor implements AnnotationProcessor {

    private final AnnotationProcessorEnvironment environment;

    private List<MethodDeclaration> interfaceMethods = new ArrayList<>();

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void process() {
        for (TypeDeclaration typeDeclaration : environment.getSpecifiedTypeDeclarations()) {
            ExtractInterface annotation = typeDeclaration.getAnnotation(ExtractInterface.class);

            if (annotation == null) {
                break;
            }

            for (MethodDeclaration methodDeclaration : typeDeclaration.getMethods()) {
                if (methodDeclaration.getModifiers().contains(Modifier.PUBLIC)
                        && !(methodDeclaration.getModifiers().contains(Modifier.STATIC))) {
                    interfaceMethods.add(methodDeclaration);
                }
            }

            if (interfaceMethods.size() > 0) {
                try {
                    PrintWriter printWriter = environment.getFiler().createSourceFile(annotation.value());
                    printWriter.println("package " + typeDeclaration.getPackage().getQualifiedName() + ";");
                    printWriter.println("public interface " + annotation.value() + "{");

                    for (MethodDeclaration methodDeclaration : interfaceMethods) {
                        printWriter.print(" public ");
                        printWriter.print(methodDeclaration.getReturnType() + " ");
                        printWriter.print(methodDeclaration.getSimpleName() + "(");

                        int i = 0;
                        for (ParameterDeclaration parameterDeclaration : methodDeclaration.getParameters()) {
                            printWriter.print(parameterDeclaration.getType() + " " + parameterDeclaration.getSimpleName());
                            if (++i < methodDeclaration.getParameters().size()) {
                                printWriter.print(", ");
                            }
                        }
                        printWriter.print(");");
                    }

                    printWriter.println("}");
                    printWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
