package editorzine.server.repository;

import editorzine.server.model.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorRepository extends JpaRepository<Editor, Integer> {
    Editor findByEmail(String email);
    Editor findByUsername(String username);
}

