package tk.mybatis.mapper.additional.dialect.mysql;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import tk.mybatis.mapper.additional.procedure.ProcedureProvider;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface MysqlProcedureMapper {
    @SelectProvider(type = ProcedureProvider.class, method = "dynamicSQL")
    @Options(statementType = StatementType.CALLABLE)
    void callProcedure(TestProcParam param);
}
