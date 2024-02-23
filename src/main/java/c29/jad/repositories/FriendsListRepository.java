package c29.jad.repositories;

import c29.jad.models.FriendsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendsListRepository extends JpaRepository<FriendsModel, Integer> {

}
//    FriendsModel findUsernameById(Integer id);{
//    }
//}

//    @Query(value = """
//            Select * from friends_lists where (user_a_id = :ownerId and user_b_id = :userId) or (user_b_id = :ownerId and user_a_id = :userId)
//            """, nativeQuery = true
//    )
//    List<FriendsModel> findFriends(@Param("ownerId") Integer ownerId, @Param("userId") Integer userId );
//}

//    boolean existsByUsername(String username);

//public interface FriendsListRepository extends JpaRepository<FriendsModel, Integer> {
//    FriendsModel findUsernameById(Integer id);
//
////    boolean existsByUsername(String username);
////
////    List<FriendsModel> findByUsername(String username);
////
////    List<FriendsModel> findByUserId(Integer userId);
//
//    @Query(value = "SELECT user_id FROM friends_list WHERE userId = :user_id", nativeQuery = true)
//    List<FriendsModel> findUsernameById(@Param("username") String username);
//}