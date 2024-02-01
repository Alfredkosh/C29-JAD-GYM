package c29.jad.forms;

public class UserForm {
    private String username;
    private String password;
    private String qrcode;
    private Integer age;
    private String email;
    private Integer mobile_number;
    private String icon;
    private String expired_date;
    private Boolean active;

    @Override
    public String toString() {
        return "UserForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobile_number=" + mobile_number +
                ", icon='" + icon + '\'' +
                ", expired_date='" + expired_date + '\'' +
                ", active=" + active +
                '}';
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

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(Integer mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
