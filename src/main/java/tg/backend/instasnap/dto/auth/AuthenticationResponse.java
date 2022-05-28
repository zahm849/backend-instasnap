package tg.backend.instasnap.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private  String accessToken;

    private  String nom;
    private  String prenom;

}
