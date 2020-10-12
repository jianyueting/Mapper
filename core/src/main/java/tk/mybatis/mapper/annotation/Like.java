package tk.mybatis.mapper.annotation;

import tk.mybatis.mapper.code.LikeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created at 2020/10/10 09:22
 *
 * @author jeff
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Like {
    LikeType[] type() default {};
}
