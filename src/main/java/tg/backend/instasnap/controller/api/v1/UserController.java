package tg.backend.instasnap.controller.api.v1;


import com.google.common.reflect.TypeToken;

import org.springframework.data.domain.Page;
import tg.backend.instasnap.dto.UserDto;
import tg.backend.instasnap.dto.request.UserSaveDto;
import tg.backend.instasnap.dto.response.UserGetAllResponseDto;
import tg.backend.instasnap.models.User;
import tg.backend.instasnap.repository.UserRepository;
import tg.backend.instasnap.service.UserServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/utilisateurs")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<UserGetAllResponseDto> listUsers() {
        TypeToken<UserDto> typeToken = new
                TypeToken<UserDto>(UserDto.class) {
                };
        List<User> data = userServiceInterface.getAll();
        List<UserDto> responseData = new ArrayList<>();
        data.forEach((c) -> {
            UserDto dto = modelMapper.map(c, typeToken.getType());
            responseData.add(dto);
        });
        UserGetAllResponseDto response = new UserGetAllResponseDto(responseData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{page}/{pageSize}")
    public ResponseEntity<Page<User>> getAllContact(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return new ResponseEntity<>(userServiceInterface.getAllUsers(page,pageSize) , HttpStatus.OK);
    }

    /**
     * Cet api permet d'enregistrer un utilisateur
     * @param userSaveDto
     * @return
     */
    @PostMapping(value = "/new")
    public ResponseEntity<UserSaveDto> CreateUser(
            @RequestBody UserSaveDto userSaveDto) {
        User type = this.userServiceInterface.create(userSaveDto);

        TypeToken<UserDto> typeToken = new
                TypeToken<UserDto>(UserDto.class) {
                };

        UserDto response = modelMapper.map(type, typeToken.getType());


        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getUserById/{id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        TypeToken<UserDto> typeToken = new
                TypeToken<UserDto>(UserDto.class) {
                };
        User user = userServiceInterface.getById(id);
        UserDto response = modelMapper.map(user, typeToken.getType());
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserSaveDto> updateUser(
            @PathVariable(value = "id") Long id,
            @RequestBody UserSaveDto userSaveDto) {

        User userUpdated = userServiceInterface.update(userSaveDto, id);

        if (userUpdated == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        TypeToken<UserDto> typeToken = new
                TypeToken<UserDto>(UserDto.class) {
                };

        UserDto response = modelMapper.map(userUpdated, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceInterface.delete(id);
        System.out.println("Le user " + id + " a été supprimé avec succès");
    }

}
