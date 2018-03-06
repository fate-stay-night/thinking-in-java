package xyz.vimtool.chapter20.section2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 默认值限制
 * 注解中，元素不能有不确定的值，既元素必须要么有默认值，要么在实用注解时提供元素的值
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-5
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    
    public int id() default -1;
    
    public String description() default "";
}
