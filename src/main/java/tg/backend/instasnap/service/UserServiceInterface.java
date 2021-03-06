package tg.backend.instasnap.service;

import org.springframework.data.domain.Page;
import tg.backend.instasnap.dto.request.UserSaveDto;
import tg.backend.instasnap.models.Commentaire;
import tg.backend.instasnap.models.User;

import java.util.List;

public interface UserServiceInterface extends EntityServiceInterface<User, Long, UserSaveDto>{
    Page<User> getAllUsers(int page, int pageSize);
    List<Commentaire> getCommentairesByUser(Long id);
}
