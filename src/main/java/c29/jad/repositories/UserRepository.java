package c29.jad.repositories;

import c29.jad.models.AdminModel;
import c29.jad.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findUsernameById(Integer id);
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    List<UserModel> findByUsername(String username);

    @Query(value = """
            Select *from users where username = :username and password = :password
            """, nativeQuery = true)
    List<UserModel> login (@Param ("username") String username, @Param("password")String password);
}
