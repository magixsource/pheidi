package gl.linpeng.pheidi.herald.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Auth model
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Entity
@Table(name = "PHEIDI_AUTH")
public class AuthModel extends BaseModel{

    private Long userId;
    private String code;
    private String device;
    private Integer status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
