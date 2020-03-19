package tk.mybatis.mapper.additional.dialect.postgres;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author Jian Yueting
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface PostgresNextValMapper {
    @SelectProvider(type = PostgresProvider.class, method = "dynamicSQL")
    long nextVal(@Param("sequenceName") String sequenceName);
}
