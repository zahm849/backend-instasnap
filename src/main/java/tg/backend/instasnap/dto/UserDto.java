package tg.backend.instasnap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String nom;
    private String prenom;
    private String profil;
    private String email;
    private String username;
    private String password;

}
