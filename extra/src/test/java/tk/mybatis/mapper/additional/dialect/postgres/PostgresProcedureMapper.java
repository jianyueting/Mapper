package tk.mybatis.mapper.additional.dialect.postgres;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.additional.procedure.FunctionProvider;
import tk.mybatis.mapper.annotation.FunctionName;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * @author Jian Yueting
 */
@RegisterMapper
public interface PostgresProcedureMapper {
    @SelectProvider(type = FunctionProvider.class, method = "dynamicSQL")
    @FunctionName("plus")
    Object plus(int a, int b);

    @SelectProvider(type = FunctionProvider.class, method = "dynamicSQL")
    @FunctionName("minus")
    Object minus(int a, int b);
}
