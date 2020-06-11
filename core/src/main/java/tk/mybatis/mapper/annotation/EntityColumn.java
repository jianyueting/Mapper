package tk.mybatis.mapper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityColumn {
    /**
     * 数据库字段
     *
     * @return
     */
    String column();

    /**
     * 选择id，调用其他类，要写全路径
     *
     * @return
     */
    String selectId();
}
