package tg.backend.instasnap.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tg.backend.instasnap.dto.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSaveDto {
    private UserDto user;
}
