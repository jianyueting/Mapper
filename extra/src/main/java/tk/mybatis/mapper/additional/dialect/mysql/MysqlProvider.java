package tk.mybatis.mapper.additional.dialect.mysql;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

/**
 * @author Jian Yueting
 */
public class MysqlProvider extends MapperTemplate {
    public MysqlProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String currentTime(MappedStatement ms){
        return "SELECT now()";
    }
}
