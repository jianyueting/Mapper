package tk.mybatis.mapper.additional.procedure;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.MapperException;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.util.MsUtil;
import tk.mybatis.mapper.util.StringUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author Jian Yueting
 */
public class ProcedureProvider extends MapperTemplate {
    public ProcedureProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String callProcedure(MappedStatement ms) throws Exception {
        Class<?> mapperClass = MsUtil.getMapperClass(ms);
        Method[] methods = mapperClass.getMethods();
        Method method = Stream.of(methods).filter(method1 -> "callProcedure".equals(method1.getName())).findFirst().get();
        Class[] parameterTypes = method.getParameterTypes();
        Class parameterType = parameterTypes[0];
        Annotation procedureName = parameterType.getAnnotation(ProcedureName.class);
        if (procedureName == null) {
            throw new MapperException("参数没有配置tk.mybatis.mapper.additional.procedure.ProcedureName注解");
        }
        Annotation annotation = parameterType.getAnnotation(ProcedureName.class);
        String name = (String) annotation.annotationType().getDeclaredMethod("value").invoke(annotation);

        StringBuilder stringBuilder = new StringBuilder("CALL ");
        stringBuilder.append(name).append(" (");
        Field[] fields = parameterType.getDeclaredFields();
        Stream.of(fields).forEach(field -> stringBuilder.append(param(field)));
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private String param(Field field) {
        ProcedureParam procedureParam = field.getAnnotation(ProcedureParam.class);
        if (procedureParam == null) {
            return "";
        }

        String value = procedureParam.value();
        StringBuilder stringBuilder = new StringBuilder("#{");
        if (StringUtil.isEmpty(value)) {
            stringBuilder.append(field.getName()).append(",");
        } else {
            stringBuilder.append(value).append(",");
        }
        stringBuilder.append("jdbcType=").append(procedureParam.jdbcType()).append(",");
        stringBuilder.append("mode=").append(procedureParam.mode());
        stringBuilder.append("},");
        return stringBuilder.toString();
    }
}
