package editorzine.server.repository;

import editorzine.server.model.*;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EditRepository extends Repository<Edit, Integer> {
    Edit findById(int id);
    Edit save(Edit edit);

    List<Edit> findAllByEditor_Username(String username);
    List<Edit> findAllByEditor(Editor editor); // i think this is gonna be obsolete

    List<Edit> findAllByAudio(Audio audio);
    List<Edit> findAllByFandom(Fandom fandom);
    List<Edit> findAllByStyle(Style style);

    List<Edit> findAll();

}
