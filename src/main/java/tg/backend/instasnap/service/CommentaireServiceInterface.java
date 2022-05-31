package tg.backend.instasnap.service;

import tg.backend.instasnap.dto.request.CommentaireSaveDto;
import tg.backend.instasnap.models.Commentaire;

import java.util.List;

public interface CommentaireServiceInterface extends EntityServiceInterface<Commentaire, Long, CommentaireSaveDto>{
    List<Commentaire> getCommentairesByUser();
}
