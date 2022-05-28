package tg.backend.instasnap.controller.api.v1;


import com.google.common.reflect.TypeToken;

import tg.backend.instasnap.dto.LikerDto;
import tg.backend.instasnap.dto.request.LikerSaveDto;
import tg.backend.instasnap.dto.response.LikerGetAllResponseDto;
import tg.backend.instasnap.models.Liker;
import tg.backend.instasnap.repository.LikerRepository;
import tg.backend.instasnap.service.LikerServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping(path = "api/v1/likers")
public class LikerController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LikerServiceInterface likerServiceInterface;

    @Autowired
    private LikerRepository likerRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<LikerGetAllResponseDto> listLikers() {
        TypeToken<LikerDto> typeToken = new
                TypeToken<LikerDto>(LikerDto.class) {
                };
        List<Liker> data = likerServiceInterface.getAll();


        List<LikerDto> responseData = new ArrayList<>();
        data.forEach((c) -> {
            LikerDto dto = modelMapper.map(c, typeToken.getType());
            responseData.add(dto);
        });
        LikerGetAllResponseDto response = new LikerGetAllResponseDto(responseData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<LikerSaveDto> CreateLiker(
            @RequestBody LikerSaveDto likerSaveDto) {

        Liker type = this.likerServiceInterface.create(likerSaveDto);

        TypeToken<LikerDto> typeToken = new
                TypeToken<LikerDto>(LikerDto.class) {
                };

        LikerDto response = modelMapper.map(type, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<LikerDto> getLikerById(@PathVariable("id") Long id) {
        TypeToken<LikerDto> typeToken = new
                TypeToken<LikerDto>(LikerDto.class) {
                };
        Liker liker = likerServiceInterface.getById(id);
        LikerDto response = modelMapper.map(liker, typeToken.getType());
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<LikerSaveDto> updateLiker(
            @PathVariable(value = "id") Long id,
            @RequestBody LikerSaveDto likerSaveDto) {

        Liker likerUpdated = likerServiceInterface.update(likerSaveDto, id);

        if (likerUpdated == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        TypeToken<LikerDto> typeToken = new
                TypeToken<LikerDto>(LikerDto.class) {
                };

        LikerDto response = modelMapper.map(likerUpdated, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteLiker(@PathVariable Long id) {
        likerServiceInterface.delete(id);
        System.out.println("Le liker " + id + " a été supprimé avec succès");
    }

}
