package tg.backend.instasnap.service;

import tg.backend.instasnap.dto.request.PublicationSaveDto;
import tg.backend.instasnap.models.Publication;

public interface PublicationServiceInterface extends EntityServiceInterface <Publication, Long, PublicationSaveDto>{
}
