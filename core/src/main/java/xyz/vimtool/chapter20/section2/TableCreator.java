package xyz.vimtool.chapter20.section2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器，处理SQL注解
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-5
 */
public class TableCreator {

    public static String getConstraints(Constraints con) {
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

    public static void main(String[] args) throws Exception {
//        if (args.length < 1) {
//            System.out.println("arguments: annotated classes");
//            System.exit(0);
//        }

        String[] classes = {Member.class.getName()};
        for (String className : classes) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }

            String tableName = dbTable.name();

            //If the table name is empty, use the Class name:
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue; // not a db table column
                }

                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    //Use field name if name not specified
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }

                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    //Use field name if name not specified
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }


                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append("\n " + columnDef + ",");
                }
                //remove trailing comma
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";

                System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }
}
