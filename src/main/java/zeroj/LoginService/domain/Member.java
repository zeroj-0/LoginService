package zeroj.LoginService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Member {

    @Column(name = "name")
    private String name;
    @Column(name = "id")
    private String Id;
    @Column(name = "password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
