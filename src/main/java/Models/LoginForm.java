package Models;

public class LoginForm {
    private String email;
    private String password;

    public LoginForm() {
    }

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Tạo đối tượng LoginForm với thông tin đăng nhập hợp lệ
    public static LoginForm getLoginAdmin() {
        return new LoginForm("admin", "123456");
    }

}
