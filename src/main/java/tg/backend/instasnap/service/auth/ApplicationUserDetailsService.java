package tg.backend.instasnap.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tg.backend.instasnap.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        tg.backend.instasnap.models.User user = userRepository.findUserByUsername(username).
                orElseThrow(
                        () -> new EntityNotFoundException("Aucun utilisateur avec le username fourni ")
                );

        return new User(user.getUsername(),user.getPassword(), Collections.emptyList());
    }

    public tg.backend.instasnap.models.User findByUsername(String username) throws UsernameNotFoundException {
        tg.backend.instasnap.models.User user = userRepository.findUserByUsername(username).
                orElseThrow(
                        () -> new EntityNotFoundException("Aucun utilisateur avec le username fourni ")
                );

        return user;
    }

}
