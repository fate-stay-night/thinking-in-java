package xyz.vimtool.chapter20.section2;

/**
 * 数据库字段唯一注解
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-5
 */

public @interface Uniqueness {

    Constraints constraints() default @Constraints(unique = true);
}
