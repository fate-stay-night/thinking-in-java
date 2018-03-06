package xyz.vimtool.chapter20.section2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表注解
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-5
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    public String name() default "";
}
