package tg.backend.instasnap.service.implementations;

import tg.backend.instasnap.dto.request.CommentaireSaveDto;
import tg.backend.instasnap.models.Commentaire;
import tg.backend.instasnap.models.Publication;
import tg.backend.instasnap.models.User;
import tg.backend.instasnap.repository.CommentaireRepository;
import tg.backend.instasnap.repository.PublicationRepository;
import tg.backend.instasnap.repository.UserRepository;
import tg.backend.instasnap.service.CommentaireServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService implements CommentaireServiceInterface {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Commentaire> getAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> getCommentairesByUser() {
        return commentaireRepository.getCommentairesByUser();
    }

    @Override
    public Commentaire getById(Long id) {
        return commentaireRepository.getById(id);
    }

    @Override
    public Commentaire create(CommentaireSaveDto commentaireSaveDto) {
        Commentaire commentaire = new Commentaire();

        commentaire.setId(commentaireSaveDto.getCommentaire().getId());
        commentaire.setContenu(commentaireSaveDto.getCommentaire().getContenu());

        Optional<User> userContainer = userRepository.findById(commentaireSaveDto.getUser());
        if (userContainer.isPresent() == false) {
            try {
                throw new Exception("L'utilisateur n'existe pas");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        commentaire.setUser(userContainer.get());

        Optional<Publication> publicationContainer = publicationRepository.findById(commentaireSaveDto.getUser());
        if (publicationContainer.isPresent() == false) {
            try {
                throw new Exception("L'utilisateur n'existe pas");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        commentaire.setPublication(publicationContainer.get());

        return commentaireRepository.save(commentaire);
    }

    @Override
    public void delete(Long id) {
        commentaireRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Commentaire update(CommentaireSaveDto commentaireSaveDto, Long id) {
        Optional<Commentaire> commentaireContainer = commentaireRepository.findById(id);
        if (commentaireContainer.isPresent()){
            Commentaire existingCommentaire = commentaireContainer.get();

            existingCommentaire.setId(commentaireSaveDto.getCommentaire().getId());
            existingCommentaire.setContenu(commentaireSaveDto.getCommentaire().getContenu());

            Optional<User> userContainer = userRepository.findById(commentaireSaveDto.getUser());
            if (userContainer.isPresent() == false) {
                try {
                    throw new Exception("L'utilisateur n'existe pas");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            existingCommentaire.setUser(userContainer.get());

            Optional<Publication> publicationContainer = publicationRepository.findById(commentaireSaveDto.getUser());
            if (publicationContainer.isPresent() == false) {
                try {
                    throw new Exception("L'utilisateur n'existe pas");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            existingCommentaire.setPublication(publicationContainer.get());

            return existingCommentaire;
        }else{
            return null;
        }
    }
}
