package tg.backend.instasnap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.backend.instasnap.models.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Integer> {
}
