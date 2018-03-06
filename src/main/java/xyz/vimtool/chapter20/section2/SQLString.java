package xyz.vimtool.chapter20.section2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * sql注解，字符类型属性，大小
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-5
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;
}
