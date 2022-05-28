package tg.backend.instasnap.controller.api.v1;


import com.google.common.reflect.TypeToken;
import tg.backend.instasnap.dto.LikerDto;
import tg.backend.instasnap.dto.PublicationDto;
import tg.backend.instasnap.dto.request.LikerSaveDto;
import tg.backend.instasnap.dto.request.PublicationSaveDto;
import tg.backend.instasnap.dto.response.PublicationGetAllResponseDto;
import tg.backend.instasnap.models.Liker;
import tg.backend.instasnap.models.Publication;
import tg.backend.instasnap.service.LikerServiceInterface;
import tg.backend.instasnap.service.PublicationServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping(path = "api/v1/publications")
public class PublicationController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PublicationServiceInterface publicationServiceInterface;

    @Autowired
    private LikerServiceInterface likerServiceInterface;

    @GetMapping(value = "/all")
    public ResponseEntity<PublicationGetAllResponseDto> listPublications() {
        TypeToken<PublicationDto> typeToken = new
                TypeToken<PublicationDto>(PublicationDto.class) {
                };
        List<Publication> data = publicationServiceInterface.getAll();


        List<PublicationDto> responseData = new ArrayList<>();
        data.forEach((c) -> {
            PublicationDto dto = modelMapper.map(c, typeToken.getType());
            responseData.add(dto);
        });
        PublicationGetAllResponseDto response = new PublicationGetAllResponseDto(responseData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getTopTen")
    public ResponseEntity<PublicationGetAllResponseDto> listTopTenPublications() {
        TypeToken<PublicationDto> typeToken = new
                TypeToken<PublicationDto>(PublicationDto.class) {
                };
        List<Publication> data = publicationServiceInterface.getAll();


        List<PublicationDto> responseData = new ArrayList<>();
        data.forEach((c) -> {
            PublicationDto dto = modelMapper.map(c, typeToken.getType());
            responseData.add(dto);
        });
        PublicationGetAllResponseDto response = new PublicationGetAllResponseDto(responseData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<PublicationSaveDto> CreatePublication(
            @RequestBody PublicationSaveDto publicationSaveDto) {

        Publication type = this.publicationServiceInterface.create(publicationSaveDto);

        TypeToken<PublicationDto> typeToken = new
                TypeToken<PublicationDto>(PublicationDto.class) {
                };

        PublicationDto response = modelMapper.map(type, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getPublicationById/{id}")
    @ResponseBody
    public ResponseEntity<PublicationDto> getPublicationById(@PathVariable("id") Long id) {
        TypeToken<PublicationDto> typeToken = new
                TypeToken<PublicationDto>(PublicationDto.class) {
                };
        Publication publication = publicationServiceInterface.getById(id);
        PublicationDto response = modelMapper.map(publication, typeToken.getType());
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PublicationSaveDto> updatePublication(
            @PathVariable(value = "id") Long id,
            @RequestBody PublicationSaveDto publicationSaveDto) {

        Publication publicationUpdated = publicationServiceInterface.update(publicationSaveDto, id);

        if (publicationUpdated == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        TypeToken<PublicationDto> typeToken = new
                TypeToken<PublicationDto>(PublicationDto.class) {
                };

        PublicationDto response = modelMapper.map(publicationUpdated, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePublication(@PathVariable Long id) {
        publicationServiceInterface.delete(id);
        System.out.println("Le publication " + id + " a été supprimé avec succès");
    }

    @PostMapping(value = "/liker/new")
    public ResponseEntity<LikerSaveDto> CreateLiker(
            @RequestBody LikerSaveDto likerSaveDto) {

        Liker type = this.likerServiceInterface.create(likerSaveDto);

        TypeToken<LikerDto> typeToken = new
                TypeToken<LikerDto>(LikerDto.class) {
                };

        LikerDto response = modelMapper.map(type, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
