package tk.mybatis.mapper.additional.procedure;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.annotation.FunctionName;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.util.MsUtil;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author Jian Yueting
 */
public class PostgresProcedureProvider extends MapperTemplate {
    public PostgresProcedureProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String callProcedure(MappedStatement ms) throws Exception {
        Class<?> mapperClass = MsUtil.getMapperClass(ms);
        String id = ms.getId();
        String[] array = id.split("\\.");
        String methodName = array[array.length - 1];
        Method[] methods = mapperClass.getMethods();
        Method method = Stream.of(methods).filter(method1 -> methodName.equals(method1.getName())).findFirst().get();
        Class[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        FunctionName functionName = method.getAnnotation(FunctionName.class);
        String name = functionName.value();

        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(name).append(" (");
        for (int i = 0; i < length; i++) {
            stringBuilder.append("#{arg").append(i).append("},");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
