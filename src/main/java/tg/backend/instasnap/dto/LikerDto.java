package tg.backend.instasnap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tg.backend.instasnap.models.Publication;
import tg.backend.instasnap.models.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikerDto {
    protected Long id;
    protected Publication publication;
    protected User user;
}
