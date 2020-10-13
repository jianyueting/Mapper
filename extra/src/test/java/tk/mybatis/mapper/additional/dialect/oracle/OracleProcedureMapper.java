package tk.mybatis.mapper.additional.dialect.oracle;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import tk.mybatis.mapper.additional.procedure.ProcedureProvider;
import tk.mybatis.mapper.annotation.ProcedureName;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface OracleProcedureMapper {
    @SelectProvider(type = ProcedureProvider.class, method = "dynamicSQL")
    @Options(statementType = StatementType.CALLABLE)
    @ProcedureName("cube_sum")
    void sum(TestProcParam param);
}
