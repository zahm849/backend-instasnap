package tg.backend.instasnap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tg.backend.instasnap.dto.LikerDto;
import tg.backend.instasnap.dto.UserDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikerGetAllResponseDto {
    protected List<LikerDto> data;
}
