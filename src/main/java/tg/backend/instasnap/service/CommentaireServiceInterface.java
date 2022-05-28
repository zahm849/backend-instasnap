package tg.backend.instasnap.service;

import tg.backend.instasnap.dto.request.CommentaireSaveDto;
import tg.backend.instasnap.models.Commentaire;

public interface CommentaireServiceInterface extends EntityServiceInterface<Commentaire, Long, CommentaireSaveDto>{
}
