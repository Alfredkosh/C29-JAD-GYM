package c29.jad.forms;

public class UserForm {
    private String fullname;
    private String username;
    private String password;
    private Integer age;
    private String gender;

    private String grading;
    private String email;
    private Integer mobile_number;
    private String expired_date;
    private Boolean active;

    @Override
    public String toString() {
        return "UserForm{" +
                "fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", grading='" + grading + '\'' +
                ", email='" + email + '\'' +
                ", mobile_number=" + mobile_number +
                ", expired_date='" + expired_date + '\'' +
                ", active=" + active +
                '}';
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
