package tk.mybatis.mapper.test.example;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.mapper.mapper.MybatisHelper;
import tk.mybatis.mapper.mapper.SysUserMapper;
import tk.mybatis.mapper.model.SysUser;

public class UserRoleTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisHelper.getSqlSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = mapper.selectByPrimaryKey(0);
            Assert.assertEquals(2, user.getRoles().size());
        } finally {
            sqlSession.close();
        }
    }
}
