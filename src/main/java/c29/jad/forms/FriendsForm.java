package c29.jad.forms;


public class FriendsForm {
    private int userId;
    private String username;

    @Override
    public String toString() {
        return "FriendsForm{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}