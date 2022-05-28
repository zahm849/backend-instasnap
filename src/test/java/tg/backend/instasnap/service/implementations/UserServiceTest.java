package tg.backend.instasnap.service.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tg.backend.instasnap.dto.UserDto;
import tg.backend.instasnap.dto.request.UserSaveDto;
import tg.backend.instasnap.models.User;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        UserSaveDto userSaveDto = new UserSaveDto();
    }

    @Test
    void shouldCreateUser(UserSaveDto userSaveDto) {
        UserDto expectedUser = new UserDto();
            expectedUser.setId(1L);
            expectedUser.setNom("AMADOU");
            expectedUser.setPrenom("Zoukaleni");
            expectedUser.setUsername("zahmed");
            expectedUser.setEmail("zahmed3052@gmail.com");
            expectedUser.setProfil("qwertyuiop");
            expectedUser.setPassword("TogoDebout");

            userSaveDto.setUser(expectedUser);
            User user = userService.create(userSaveDto);

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(expectedUser.getNom(),user.getNom());
        assertEquals(expectedUser.getPrenom(),user.getPrenom());
        assertEquals(expectedUser.getUsername(),user.getUsername());
        assertEquals(expectedUser.getEmail(),user.getProfil());
        assertNotEquals(expectedUser.getPassword(),user.getPassword());

    }


}