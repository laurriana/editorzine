package editorzine.server.service;

import editorzine.server.model.Edit;
import editorzine.server.repository.EditRepository;
import org.springframework.stereotype.Service;

@Service
public class EditService {
    private final EditRepository editRepository;
    public EditService(EditRepository editRepository) {
        this.editRepository = editRepository;
    }

    public int saveEdit(Edit edit) {
        Edit savedEdit = editRepository.save(edit);
        return savedEdit.getId();
    }

}
