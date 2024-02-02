package c29.jad.repositories;

import c29.jad.models.AdminModel;
import c29.jad.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<AdminModel, Integer> {

    List<AdminModel> findByUsername(String username);

}
