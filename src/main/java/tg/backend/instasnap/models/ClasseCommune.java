package tg.backend.instasnap.models;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class ClasseCommune {

    private Date created_at;

    public ClasseCommune(){
    }

    public ClasseCommune(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "classeCommune{" +
                "created_at=" + created_at +
                '}';
    }
}

