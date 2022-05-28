package tg.backend.instasnap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tg.backend.instasnap.dto.CommentaireDto;
import tg.backend.instasnap.dto.UserDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentaireGetAllResponseDto {
    protected List<CommentaireDto> data;
}
