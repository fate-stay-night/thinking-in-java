package xyz.vimtool.chapter20.section4;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.DeclarationVisitors;
import com.sun.mirror.util.SimpleDeclarationVisitor;
import xyz.vimtool.chapter20.section2.Constraints;
import xyz.vimtool.chapter20.section2.DBTable;
import xyz.vimtool.chapter20.section2.SQLInteger;
import xyz.vimtool.chapter20.section2.SQLString;

import java.util.*;

/**
 * 注解处理器
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-8
 */
public class TableCreationProcessorFactory implements AnnotationProcessorFactory {

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set,
                                               AnnotationProcessorEnvironment environment) {
        return new TableCreationProcessor(environment);
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList(
                "annotations.database.DBTable",
                "annotations.database.Constraints",
                "annotations.database.SQLString",
                "annotations.database.SQLInteger");
    }

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    private static class TableCreationProcessor implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment environment;

        private String sql = "";

        public TableCreationProcessor(AnnotationProcessorEnvironment environment) {
            this.environment = environment;
        }

        @Override
        public void process() {
            for (TypeDeclaration typeDeclaration : environment.getSpecifiedTypeDeclarations()) {
                typeDeclaration.accept(DeclarationVisitors.getDeclarationScanner(new TableCreationVisitor(), DeclarationVisitors.NO_OP));

                sql = sql.substring(0, sql.length() - 1) + ");";
                System.out.println("create SQL is :\n" + sql);
                sql = "";
            }
        }

        private class TableCreationVisitor extends SimpleDeclarationVisitor {
            @Override
            public void visitClassDeclaration(ClassDeclaration classDeclaration) {
                DBTable dbTable = classDeclaration.getAnnotation(DBTable.class);

                if (dbTable != null) {
                    sql += "CREATE TABLE ";
                    sql += (dbTable.name().length() < 1) ? classDeclaration.getSimpleName().toUpperCase() : dbTable.name();
                    sql += "(";
                }
            }

            public void visitFieldDeclaration(FieldDeclaration fieldDeclaration) {
                String columnName = "";

                if (fieldDeclaration.getAnnotation(SQLInteger.class) != null) {
                    SQLInteger sqlInteger = fieldDeclaration.getAnnotation(SQLInteger.class);

                    //Use field name if name not specified
                    if (sqlInteger.name().length() < 1) {
                        columnName = fieldDeclaration.getSimpleName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }

                    sql += "\n " + columnName + " INT" + getConstraints(sqlInteger.constraints()) + ",";
                }

                if (fieldDeclaration.getAnnotation(SQLString.class) != null) {
                    SQLString sqlString = fieldDeclaration.getAnnotation(SQLString.class);

                    //Use field name if name not specified
                    if (sqlString.name().length() < 1) {
                        columnName = fieldDeclaration.getSimpleName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }

                    sql += "\n " + columnName + " VARCHAR(" + sqlString.value() + ")"
                            + getConstraints(sqlString.constraints()) + ",";
                }
            }

            private String getConstraints(Constraints con) {
                String constraints = "";

                if (!con.allowNull()) {
                    constraints += " NOT NULL";
                }

                if (con.primaryKey()) {
                    constraints += " PRIMARY KEY";
                }

                if (con.unique()) {
                    constraints += " UNIQUE";
                }
                return constraints;
            }
        }

    }
}
