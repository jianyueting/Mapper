package tk.mybatis.mapper.additional.dialect.postgres;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

/**
 * @author Jian Yueting
 */
public class PostgresProvider extends MapperTemplate {
    public PostgresProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String currentTime(MappedStatement ms) {
        return "SELECT now()";
    }

    public String nextVal(MappedStatement ms){
        return "SELECT nextVal('${sequenceName}')";
    }
}
