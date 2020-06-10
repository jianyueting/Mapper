package tk.mybatis.mapper.model;

import tk.mybatis.mapper.annotation.EntityColumn;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Set;

public class SysUser {
    @Id
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    //@EntityColumn(column = "id", property = "roles", selectId = "tk.mybatis.mapper.mapper.SysRoleMapper.selectByPrimaryKey")
    @EntityColumn(column = "id", property = "roles", selectId = "selectRoles")
    private Set<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
