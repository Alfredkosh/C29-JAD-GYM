package c29.jad.repositories;

import c29.jad.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query(value = """
            Select *from users where username = :username and password = :password
            """, nativeQuery = true)
    List<UserModel> login (@Param ("username") String username, @Param("password")String password);
}
