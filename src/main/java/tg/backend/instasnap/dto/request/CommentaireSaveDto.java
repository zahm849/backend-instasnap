package tg.backend.instasnap.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tg.backend.instasnap.dto.CommentaireDto;
import tg.backend.instasnap.dto.LikerDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentaireSaveDto {
    private CommentaireDto commentaire;
    private Long publication;
    private Long user;

}
