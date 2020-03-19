package tk.mybatis.mapper.additional.dialect.oracle;

import org.apache.ibatis.annotations.SelectProvider;

import java.sql.Timestamp;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface OracleCurrentTimeMapper {
    @SelectProvider(type = OracleProvider.class, method = "dynamicSQL")
    Timestamp currentTime();
}
