package tk.mybatis.mapper.annotation;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.code.ProcedureParamMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jian Yueting
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ProcedureParam {
    /**
     * 参数jdbc类型，默认为JdbcType.VARCHAR
     *
     * @return
     */
    JdbcType jdbcType() default JdbcType.VARCHAR;

    /**
     * 参数类型，IN，OUT，INOUT
     *
     * @return
     */
    ProcedureParamMode mode();

    /**
     * 参数名称，为空串使用字段名称
     *
     * @return
     */
    String value() default "";
}
