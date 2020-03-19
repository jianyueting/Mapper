package tk.mybatis.mapper.additional.dialect.oracle;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface OracleSequenceNextValMapper {
    @SelectProvider(type = OracleProvider.class, method = "dynamicSQL")
    long nextVal(@Param("sequenceName") String sequenceName);
}
