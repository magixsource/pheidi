package gl.linpeng.pheidi.herald.utils;

/**
 * Pheidi auth status
 *
 * @author lin.peng
 * @since 0.0.1
 */
public enum AuthStatus {
    DISABLED(0, "停用"), ENABLED(1, "启用"), EXPIRED(2, "过期");

    private int status;
    private String title;

    AuthStatus(int status, String title) {
        this.status = status;
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
