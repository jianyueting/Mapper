package tk.mybatis.mapper.additional.dialect.oracle;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ProcedureParam;
import tk.mybatis.mapper.code.ProcedureParamMode;

/**
 * @author Jian Yueting
 */
public class TestProcParam {
    @ProcedureParam(jdbcType = JdbcType.INTEGER, mode = ProcedureParamMode.IN)
    private int param1;
    @ProcedureParam(jdbcType = JdbcType.INTEGER, mode = ProcedureParamMode.IN)
    private int param2;
    @ProcedureParam(jdbcType = JdbcType.INTEGER, mode = ProcedureParamMode.OUT)
    private int res;

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
