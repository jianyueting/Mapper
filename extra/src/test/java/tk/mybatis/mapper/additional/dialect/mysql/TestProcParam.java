package tk.mybatis.mapper.additional.dialect.mysql;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ProcedureName;
import tk.mybatis.mapper.annotation.ProcedureParam;
import tk.mybatis.mapper.code.ProcedureParamMode;

/**
 * @author Jian Yueting
 */
@ProcedureName("test_proc")
public class TestProcParam {
    @ProcedureParam(jdbcType = JdbcType.VARCHAR, mode = ProcedureParamMode.IN)
    private String p1;
    @ProcedureParam(mode = ProcedureParamMode.OUT)
    private String p2;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
