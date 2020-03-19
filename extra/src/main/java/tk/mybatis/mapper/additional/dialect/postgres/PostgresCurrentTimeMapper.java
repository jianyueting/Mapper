package tk.mybatis.mapper.additional.dialect.postgres;

import org.apache.ibatis.annotations.SelectProvider;

import java.sql.Timestamp;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface PostgresCurrentTimeMapper {
    @SelectProvider(type = PostgresProvider.class, method = "dynamicSQL")
    Timestamp currentTime();
}
