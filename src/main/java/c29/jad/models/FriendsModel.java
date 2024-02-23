package c29.jad.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friends_lists")
public class FriendsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_a_id")
    private int userAId;

    @Column(name = "user_b_id")
    private int userBId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_a_id", updatable = false, insertable = false)
    private UserModel userA;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_b_id", updatable = false, insertable = false)
    private UserModel userB;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserAId() {
        return userAId;
    }

    public void setUserAId(int userAId) {
        this.userAId = userAId;
    }

    public int getUserBId() {
        return userBId;
    }

    public void setUserBId(int userBId) {
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