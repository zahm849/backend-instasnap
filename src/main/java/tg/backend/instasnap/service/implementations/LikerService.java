package tg.backend.instasnap.service.implementations;

import tg.backend.instasnap.dto.request.LikerSaveDto;
import tg.backend.instasnap.models.Liker;
import tg.backend.instasnap.models.Publication;
import tg.backend.instasnap.models.User;
import tg.backend.instasnap.repository.LikerRepository;
import tg.backend.instasnap.repository.PublicationRepository;
import tg.backend.instasnap.repository.UserRepository;
import tg.backend.instasnap.service.LikerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LikerService implements LikerServiceInterface {

    @Autowired
    private LikerRepository likerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Liker> getAll() {
        return likerRepository.findAll();
    }

    @Override
    public Liker getById(Long id) {
        return likerRepository.getById(id);
    }

    @Override
    public Liker create(LikerSaveDto likerSaveDto) {
        Liker liker = new Liker();

        liker.setId(likerSaveDto.getLiker().getId());

        Optional<User> userContainer = userRepository.findById(likerSaveDto.getUser());
        if (userContainer.isPresent() == false) {
            try {
                throw new Exception("L'utilisateur n'existe pas");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        liker.setUser(userContainer.get());

        Optional<Publication> publicationContainer = publicationRepository.findById(likerSaveDto.getUser());
        if (publicationContainer.isPresent() == false) {
            try {
                throw new Exception("L'utilisateur n'existe pas");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int nbreLikeUpdate = publicationContainer.get().getNombreVue() +1;
        publicationContainer.get().setNombreVue(nbreLikeUpdate);
        liker.setPublication(publicationContainer.get());

        return likerRepository.save(liker);
    }

    @Override
    public void delete(Long id) {
        likerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Liker update(LikerSaveDto likerSaveDto, Long id) {
        Optional<Liker> likerContainer = likerRepository.findById(id);
        if (likerContainer.isPresent()){
            Liker existingLiker = likerContainer.get();

            existingLiker.setId(likerSaveDto.getLiker().getId());

            existingLiker.setId(likerSaveDto.getLiker().getId());

            Optional<User> userContainer = userRepository.findById(likerSaveDto.getUser());
            if (userContainer.isPresent() == false) {
                try {
                    throw new Exception("L'utilisateur n'existe pas");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            existingLiker.setUser(userContainer.get());

            Optional<Publication> publicationContainer = publicationRepository.findById(likerSaveDto.getUser());
            if (publicationContainer.isPresent() == false) {
                try {
                    throw new Exception("L'utilisateur n'existe pas");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            existingLiker.setPublication(publicationContainer.get());

            return existingLiker;
        }else{
            return null;
        }
    }
}
