package tg.backend.instasnap.service.implementations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import tg.backend.instasnap.dto.request.UserSaveDto;
import tg.backend.instasnap.models.Commentaire;
import tg.backend.instasnap.models.User;
import tg.backend.instasnap.repository.UserRepository;
import tg.backend.instasnap.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAllUsers(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize, Sort.by(Sort.Direction.ASC,"nom"));
        return userRepository.findAll(pageable);
    }

    @Override
    public List<Commentaire> getCommentairesByUser(Long id) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User create(UserSaveDto userSaveDto) {
        User user = new User();
        user.setId(userSaveDto.getUser().getId());
        user.setNom(userSaveDto.getUser().getNom());
        user.setPrenom(userSaveDto.getUser().getPrenom());
        user.setEmail(userSaveDto.getUser().getEmail());
        user.setProfil(userSaveDto.getUser().getProfil());
        user.setUsername(userSaveDto.getUser().getUsername());
        user.setPassword(this.passwordEncoder.encode(userSaveDto.getUser().getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User update(UserSaveDto userSaveDto, Long id) {
        Optional<User> userContainer = userRepository.findById(id);

        if (userContainer.isPresent()){
            User existingUser = userContainer.get();
            existingUser.setNom(userSaveDto.getUser().getNom());
            existingUser.setPrenom(userSaveDto.getUser().getPrenom());
            existingUser.setEmail(userSaveDto.getUser().getEmail());
            existingUser.setProfil(userSaveDto.getUser().getProfil());
            existingUser.setUsername(userSaveDto.getUser().getUsername());
            existingUser.setPassword(userSaveDto.getUser().getPassword());

            return existingUser;
        }else{
            return null;
        }
    }
}
