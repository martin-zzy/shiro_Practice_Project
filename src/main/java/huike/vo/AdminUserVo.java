package huike.vo;

import java.io.Serializable;

public class AdminUserVo implements Serializable {


    private String username;
    private String password;
    private boolean remember;

    @Override
    public String toString() {
        return "AdminUserVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remember=" + remember +
                '}';
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
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

}
