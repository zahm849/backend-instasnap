package tg.backend.instasnap.service;

import org.springframework.data.domain.Page;
import tg.backend.instasnap.models.User;

import java.util.List;

/**
 * @param <E>   Le type de l'entité
 * @param <Pk>  La clé primaire de l'entité
 * @param <DTO> La Data Transfert Object de l'entité
 */


public interface EntityServiceInterface<E, Pk, DTO> {

    public List<E> getAll();

    public E getById(Pk id);

    public E create(DTO dto);

    public void delete(Pk id);

    public E update(DTO dto, Pk id);

//    Page<E> getAllUsers(int page, int pageSize);

}
