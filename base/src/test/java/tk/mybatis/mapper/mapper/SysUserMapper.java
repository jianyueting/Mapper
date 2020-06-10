package tk.mybatis.mapper.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.model.SysRole;
import tk.mybatis.mapper.model.SysUser;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {
    List<SysRole> selectRoles(Integer id);
}
