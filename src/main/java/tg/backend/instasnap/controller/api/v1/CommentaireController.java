package tg.backend.instasnap.controller.api.v1;


import com.google.common.reflect.TypeToken;

import tg.backend.instasnap.dto.CommentaireDto;
import tg.backend.instasnap.dto.request.CommentaireSaveDto;
import tg.backend.instasnap.dto.response.CommentaireGetAllResponseDto;
import tg.backend.instasnap.models.Commentaire;
import tg.backend.instasnap.repository.CommentaireRepository;
import tg.backend.instasnap.service.CommentaireServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping(path = "api/v1/commentaires")
public class CommentaireController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentaireServiceInterface commentaireServiceInterface;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<CommentaireGetAllResponseDto> listCommentaires() {
        TypeToken<CommentaireDto> typeToken = new
                TypeToken<CommentaireDto>(CommentaireDto.class) {
                };
        List<Commentaire> data = commentaireServiceInterface.getAll();


        List<CommentaireDto> responseData = new ArrayList<>();
        data.forEach((c) -> {
            CommentaireDto dto = modelMapper.map(c, typeToken.getType());
            responseData.add(dto);
        });
        CommentaireGetAllResponseDto response = new CommentaireGetAllResponseDto(responseData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CommentaireSaveDto> CreateCommentaire(
            @RequestBody CommentaireSaveDto commentaireSaveDto) {

        Commentaire type = this.commentaireServiceInterface.create(commentaireSaveDto);

        TypeToken<CommentaireDto> typeToken = new
                TypeToken<CommentaireDto>(CommentaireDto.class) {
                };

        CommentaireDto response = modelMapper.map(type, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<CommentaireDto> getCommentaireById(@PathVariable("id") Long id) {
        TypeToken<CommentaireDto> typeToken = new
                TypeToken<CommentaireDto>(CommentaireDto.class) {
                };
        Commentaire commentaire = commentaireServiceInterface.getById(id);
        CommentaireDto response = modelMapper.map(commentaire, typeToken.getType());
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentaireSaveDto> updateCommentaire(
            @PathVariable(value = "id") Long id,
            @RequestBody CommentaireSaveDto commentaireSaveDto) {

        Commentaire commentaireUpdated = commentaireServiceInterface.update(commentaireSaveDto, id);

        if (commentaireUpdated == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        TypeToken<CommentaireDto> typeToken = new
                TypeToken<CommentaireDto>(CommentaireDto.class) {
                };

        CommentaireDto response = modelMapper.map(commentaireUpdated, typeToken.getType());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        commentaireServiceInterface.delete(id);
        System.out.println("Le commentaire " + id + " a été supprimé avec succès");
    }

}

