package tg.backend.instasnap.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticatonRequest {
    private String username;
    private String password;
}
