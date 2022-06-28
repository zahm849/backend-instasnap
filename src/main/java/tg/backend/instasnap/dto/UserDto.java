package tg.backend.instasnap.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long id;
    private String nom;
    private String prenom;
    private String profil;
    private String email;
    private String username;
    private String password;
    private  String accessToken;


}
