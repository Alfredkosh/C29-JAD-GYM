package c29.jad.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friends_lists")
public class FriendsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_a_id")
    private Integer userAId;

    @Column(name = "user_b_id")
    private Integer userBId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_a_id", updatable = false, insertable = false)
    private UserModel userA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_b_id", updatable = false, insertable = false)
    private UserModel userB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public UserModel getUserA() {
        return userA;
    }

    public void setUserA(UserModel userA) {
        this.userA = userA;
    }

    public UserModel getUserB() {
        return userB;
    }

    public void setUserB(UserModel userB) {
        this.userB = userB;
    }
}