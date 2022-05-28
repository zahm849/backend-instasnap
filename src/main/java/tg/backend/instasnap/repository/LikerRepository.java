package tg.backend.instasnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.backend.instasnap.models.Liker;

@Repository
public interface LikerRepository extends JpaRepository<Liker, Long> {
}
