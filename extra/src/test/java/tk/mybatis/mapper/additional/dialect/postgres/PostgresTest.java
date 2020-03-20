package tk.mybatis.mapper.additional.dialect.postgres;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.mapper.additional.BaseTest;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.sql.Timestamp;

/**
 * @author Jian Yueting
 */
public class PostgresTest extends BaseTest {

    /**
     * 获取 mybatis 配置
     *
     * @return
     */
    protected Reader getConfigFileAsReader() throws IOException {
        URL url = getClass().getResource("mybatis-config.xml");
        return toReader(url);
    }

    @Override
    protected void runSql(Reader reader) {
    }

    @Test
    public void testNow() {
        SqlSession sqlSession = getSqlSession();
        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            Timestamp now = mapper.currentTime();
            System.out.println(now);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSequence() {
        SqlSession sqlSession = getSqlSession();
        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            long value = mapper.nextVal("seq_em");
            System.out.println(value);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testProcedure() {
        SqlSession sqlSession = getSqlSession();
        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            Object object = mapper.callProcedure(1, 2);
            System.out.println(object);
        } finally {
            sqlSession.close();
        }
    }
}
