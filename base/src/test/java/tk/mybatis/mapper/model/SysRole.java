package tk.mybatis.mapper.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class SysRole {
    @Id
    private Integer id;
    @Column(name = "rolename")
    private String rolename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
