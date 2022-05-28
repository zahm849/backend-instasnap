package tg.backend.instasnap.service.implementations;

import tg.backend.instasnap.dto.request.PublicationSaveDto;
import tg.backend.instasnap.models.Publication;
import tg.backend.instasnap.models.User;
import tg.backend.instasnap.repository.PublicationRepository;
import tg.backend.instasnap.repository.UserRepository;
import tg.backend.instasnap.service.PublicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationService implements PublicationServiceInterface {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getById(Long id) {
        return publicationRepository.getById(id);
    }

    @Override
    public Publication create(PublicationSaveDto publicationSaveDto) {
        Publication publication = new Publication();

        publication.setId(publicationSaveDto.getPublication().getId());
        publication.setLibelle(publicationSaveDto.getPublication().getLibelle());
        publication.setEtat(publicationSaveDto.getPublication().isEtat());
        publication.setLast_seen(publicationSaveDto.getPublication().getLast_seen());
        publication.setUrl(publicationSaveDto.getPublication().getUrl());
        publication.setNombre_vue(publicationSaveDto.getPublication().getNombre_vue());

        Optional<User> userContainer = userRepository.findById(publicationSaveDto.getUser());
        if (userContainer.isPresent() == false) {
            try {
                throw new Exception("L'utilisateur n'existe pas");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        publication.setUser(userContainer.get());

        return publicationRepository.save(publication);
    }

    @Override
    public void delete(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Publication update(PublicationSaveDto publicationSaveDto, Long id) {
        Optional<Publication> publicationContainer = publicationRepository.findById(id);
        if (publicationContainer.isPresent()){
            Publication existingPublication = publicationContainer.get();

            existingPublication.setId(publicationSaveDto.getPublication().getId());

            existingPublication.setId(publicationSaveDto.getPublication().getId());
            existingPublication.setLibelle(publicationSaveDto.getPublication().getLibelle());
            existingPublication.setEtat(publicationSaveDto.getPublication().isEtat());
            existingPublication.setLast_seen(publicationSaveDto.getPublication().getLast_seen());
            existingPublication.setUrl(publicationSaveDto.getPublication().getUrl());
            existingPublication.setNombre_vue(publicationSaveDto.getPublication().getNombre_vue());

            Optional<User> userContainer = userRepository.findById(publicationSaveDto.getUser());
            if (userContainer.isPresent() == false) {
                try {
                    throw new Exception("L'utilisateur n'existe pas");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            existingPublication.setUser(userContainer.get());



            return existingPublication;
        }else{
            return null;
        }
    }
}
