package tg.backend.instasnap.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CommunClass {
    @CreationTimestamp
    protected LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp
    protected LocalDateTime updatedAt;

}
