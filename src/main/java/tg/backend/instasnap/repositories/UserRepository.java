package tg.backend.instasnap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.backend.instasnap.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
