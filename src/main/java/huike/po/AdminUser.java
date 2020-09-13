package huike.po;

import java.io.Serializable;

public class AdminUser implements Serializable {
    /**
     * 对应数据库表中的字段
     */
    private Long id;
    private String account;
    private String password;
    private String passwordSalt;
    private boolean isDeleted;
    private boolean isDisabled;

    public AdminUser() {
    }

    public AdminUser(String account, String password, String passwordSalt, boolean isDeleted, boolean isDisabled) {
        this.account = account;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.isDeleted = isDeleted;
        this.isDisabled = isDisabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwrod) {
        this.password = passwrod;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", isDeleted=" + isDeleted +
                ", isDisabled=" + isDisabled +
                '}';
    }
}
