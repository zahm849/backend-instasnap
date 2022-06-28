package tg.backend.instasnap.controller.api.v1;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tg.backend.instasnap.dto.auth.AuthenticationResponse;
import tg.backend.instasnap.dto.auth.AuthenticatonRequest;
import tg.backend.instasnap.models.User;
import tg.backend.instasnap.service.UserServiceInterface;
import tg.backend.instasnap.service.auth.ApplicationUserDetailsService;
import tg.backend.instasnap.service.auth.JwtUtil;

@RestController
@RequestMapping(path = "api/v1/security")
public class SecurityControlller {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticatonRequest authenticatonRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticatonRequest.getUsername(),
                        authenticatonRequest.getPassword()
                )
        );

        final UserDetails userDetails = applicationUserDetailsService
                .loadUserByUsername(authenticatonRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        User connectedUser = applicationUserDetailsService.findByUsername(authenticatonRequest.getUsername());

        return ResponseEntity.ok(AuthenticationResponse.builder()
                .id(connectedUser.getId())
                .nom(connectedUser.getNom())
                .prenom(connectedUser.getPrenom())
                .accessToken(jwt).build());
    }

}
