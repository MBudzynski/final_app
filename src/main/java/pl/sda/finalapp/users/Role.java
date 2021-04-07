package pl.sda.finalapp.users;

import pl.sda.finalapp.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role extends BaseEntity {

    public static final String USER = "ROLE_USER";
    public static final String ADMIN = "ROLE_ADMIN";


    private String roleName;

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
