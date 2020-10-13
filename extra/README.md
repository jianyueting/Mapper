# Mybatis 通用 Mapper 扩展方法

[![Maven central](https://maven-badges.herokuapp.com/maven-central/tk.mybatis/mapper-extra/badge.svg)](https://maven-badges.herokuapp.com/maven-central/tk.mybatis/mapper-extra)

## 扩展方法介绍

### InsertListMapper

批量插入

- 支持批量插入的数据库都可以使用，例如 mysql,h2 等

    `tk.mybatis.mapper.additional.insert.InsertListMapper`

    SQL 形如 `insert table(xxx) values (xxx), (xxx) ...`

- Oracle特殊批量插入
    `tk.mybatis.mapper.additional.dialect.oracle.InsertListMapper`

    SQL 形如 
    ```sql
     INSERT ALL
     INTO demo_country ( country_id,country_name,country_code ) VALUES ( ?,?,? )
     INTO demo_country ( country_id,country_name,country_code ) VALUES ( ?,?,? )
     INTO demo_country ( country_id,country_name,country_code ) VALUES ( ?,?,? )
     SELECT 1 FROM DUAL
    ```

    **由于语法限制，暂不支持序列.**

### UpdateByPrimaryKeySelectiveForceMapper

空字段强制更新

针对`UpdateByPrimaryKeySelectiveMapper`中， 空值也需要设置的场景提供的解决方案。

参见: [https://github.com/abel533/Mapper/issues/133](https://github.com/abel533/Mapper/issues/133)

### 获取数据库时间

从数据库获取时间，现在增加MySQL、Oracle、PostgreSQL的支持。返回值数据类型为`java.sql.Timestamp`。可以在项目中增加工具类将Timestamp数据转化为合适的数据类型。

### 获取序列

从数据库获取序列，增加Oracle、PostgreSQL的支持。入参为序列名，返回值类型为long。

### 调用存储过程

注意：多个存储的调用，要写多个Mapper接口。不能在一个接口里面写多个调用方法。

MySQL和Oracle调用存储过程，不能直接继承某个特定的Mapper，因为不过程的参数是不一样的。要自己编写参数类，和Mapper接口。调用方法名称固定为`callProcedure`。

调用过程的接口类示例如下，除了接口名和调用过程的参数类型不同外，其他是固定的。

```java
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import tk.mybatis.mapper.additional.procedure.ProcedureProvider;

@tk.mybatis.mapper.annotation.RegisterMapper
public interface Proc1Mapper {
    @SelectProvider(type = ProcedureProvider.class, method = "dynamicSQL")
    @Options(statementType = StatementType.CALLABLE)
    @ProcedureName("test_proc")
    void testProc(TestProcParam param); //TestProcParam为调用过程参数
}
```

参数类示例如下，在class上增加`@tk.mybatis.mapper.additional.procedure.ProcedureName()`注解，表示过程名。按过程参数名配置参数类的属性。属性上增加`tk.mybatis.mapper.additional.procedure.ProcedureParam`注解。主要配置参数jdbcType和mode。

```java
import tk.mybatis.mapper.annotation.ProcedureName;
import tk.mybatis.mapper.annotation.ProcedureParam;
import tk.mybatis.mapper.code.ProcedureParamMode;

public class TestProcParam {
    @ProcedureParam(jdbcType = JdbcType.VARCHAR, mode = ProcedureParamMode.IN)
    private String p1;
    @ProcedureParam(mode = ProcedureParamMode.OUT)
    private String p2;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
```

### PostgreSQL函数调用
PostgreSQL函数过程和MySQL、Oracle的有所不同，直接在接口方法名上配置`@tk.mybatis.mapper.annotation.FunctionName()`注解，表示函数名称。直接使用方法参数表示函数过程。

Mapper接口如下：
```java
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.additional.procedure.FunctionProvider;
import tk.mybatis.mapper.annotation.FunctionName;
import tk.mybatis.mapper.annotation.RegisterMapper;

@RegisterMapper
public interface PostgresProcedureMapper {
    @SelectProvider(type = FunctionProvider.class, method = "dynamicSQL")
    @FunctionName("plus")
    Object plus(int a, int b);

    @SelectProvider(type = FunctionProvider.class, method = "dynamicSQL")
    @FunctionName("minus")
    Object minus(int a, int b);
}
```
