package tk.mybatis.mapper.additional.dialect.postgres;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import tk.mybatis.mapper.additional.procedure.PostgresProcedureProvider;
import tk.mybatis.mapper.additional.procedure.ProcedureName;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * @author Jian Yueting
 */
@RegisterMapper
public interface PostgresProcedureMapper {
    @SelectProvider(type = PostgresProcedureProvider.class, method = "dynamicSQL")
    @Options(statementType = StatementType.CALLABLE)
    @ProcedureName("plus")
    Object callProcedure(int a, int b);
}
