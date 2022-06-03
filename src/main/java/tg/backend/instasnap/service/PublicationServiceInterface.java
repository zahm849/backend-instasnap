package tg.backend.instasnap.service;

import tg.backend.instasnap.dto.request.PublicationSaveDto;
import tg.backend.instasnap.models.Publication;

import java.util.List;

public interface PublicationServiceInterface extends EntityServiceInterface <Publication, Long, PublicationSaveDto>{
    public List<Publication> getAllByUser(Long id);

}
