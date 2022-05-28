package tg.backend.instasnap.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tg.backend.instasnap.dto.PublicationDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PublicationSaveDto {
    private PublicationDto publication;
    private Long user;
}
