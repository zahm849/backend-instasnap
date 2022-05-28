package tg.backend.instasnap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PublicationDto {
    private Long id;
    private String url;
    private String libelle;
    private Integer nombre_vue;
    private Date last_seen;
    private boolean etat;

}
