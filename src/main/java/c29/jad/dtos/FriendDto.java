package c29.jad.dtos;

import c29.jad.models.UserModel;

public class FriendDto {
    private Integer id;

    private Integer userAId;
    private Integer userBId;
    private String userAName;
    private String userBName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserAId() {
        return userAId;
    }

    public void setUserAId(Integer userAId) {
        this.userAId = userAId;
    }

    public Integer getUserBId() {
        return userBId;
    }

    public void setUserBId(Integer userBId) {
        this.userBId = userBId;
    }

    public String getUserAName() {
        return userAName;
    }

    public void setUserAName(String userAName) {
        this.userAName = userAName;
    }

    public String getUserBName() {
        return userBName;
    }

    public void setUserBName(String userBName) {
        this.userBName = userBName;
    }
}
