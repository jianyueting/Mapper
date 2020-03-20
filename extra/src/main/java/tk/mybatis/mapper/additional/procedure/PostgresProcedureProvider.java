package tk.mybatis.mapper.additional.procedure;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.MapperException;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.util.MsUtil;

import java.lang.annotation.Annotation;
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
        Method[] methods = mapperClass.getMethods();
        Method method = Stream.of(methods).filter(method1 -> "callProcedure".equals(method1.getName())).findFirst().get();
        Class[] parameterTypes = method.getParameterTypes();
        int leng = parameterTypes.length;
        Annotation annotation = method.getAnnotation(ProcedureName.class);
        if (annotation == null) {
            throw new MapperException("方法没有配置tk.mybatis.mapper.additional.procedure.ProcedureName注解");
        }
        String name = (String) annotation.annotationType().getDeclaredMethod("value").invoke(annotation);

        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(name).append(" (");
        for (int i = 0; i < leng; i++) {
            stringBuilder.append("#{arg").append(i).append("},");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
