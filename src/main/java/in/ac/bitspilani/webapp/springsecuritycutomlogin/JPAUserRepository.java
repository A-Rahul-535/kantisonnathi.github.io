
 package in.ac.bitspilani.webapp.springsecuritycutomlogin;


import in.ac.bitspilani.webapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.Optional;

public interface JPAUserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByEmail(String email);
    public Optional<UserEntity> findById(Integer id);
}

