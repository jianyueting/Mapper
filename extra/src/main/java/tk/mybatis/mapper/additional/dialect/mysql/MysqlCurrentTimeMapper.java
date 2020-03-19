package tk.mybatis.mapper.additional.dialect.mysql;

import org.apache.ibatis.annotations.SelectProvider;

import java.sql.Timestamp;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface MysqlCurrentTimeMapper {
    @SelectProvider(type = MysqlProvider.class, method = "dynamicSQL")
    Timestamp currentTime();
}
