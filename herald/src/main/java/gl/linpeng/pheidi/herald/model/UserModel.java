package gl.linpeng.pheidi.herald.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User model
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Entity
@Table(name = "PHEIDI_USER")
public class UserModel extends BaseModel {

    private String name;
    private String secret;
    private String email;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
