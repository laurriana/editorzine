package editorzine.server.service;

import editorzine.server.dto.EditorDTO;
import editorzine.server.model.Editor;
import editorzine.server.model.User;
import editorzine.server.repository.EditorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorService {
    private final EditorRepository editorRepository;
    private final PasswordEncoder passwordEncoder;


    public EditorService(EditorRepository editorRepository, PasswordEncoder passwordEncoder) {
        this.editorRepository = editorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public int saveEditor(EditorDTO editorDTO) {
        Editor editor = new Editor();
        editor.setUsername(editorDTO.getUsername());
        editor.setName(editorDTO.getName());
        editor.setEmail(editorDTO.getEmail());
        editor.setPassword(passwordEncoder.encode(editorDTO.getPassword()));

        Editor savedEditor = editorRepository.save(editor);
        return savedEditor.getId();
    }


    public Editor findEditorByEmail(String email) {
        return editorRepository.findByEmail(email);
    }


    private EditorDTO mapToEditorDTO(Editor editor) {
        EditorDTO editorDTO = new EditorDTO();
        editorDTO.setEmail(editor.getEmail());
        editorDTO.setUsername(editor.getUsername());
        editorDTO.setName(editor.getName());
        editorDTO.setPassword(editor.getPassword());
        editorDTO.setExperience(editor.getExperience());
        editorDTO.setApp(editor.getApp());
        editorDTO.setSocials(editor.getSocials());
        return editorDTO;
    }

    public List<EditorDTO> findAllEditors() {
        List<Editor> editors = editorRepository.findAll();
        return editors.stream()
                .map((user) -> mapToEditorDTO(user))
                .collect(Collectors.toList());
    }

    public EditorDTO modifyEditor(int id, EditorDTO editorDTO) {
        Editor editor = editorRepository.findById(id).orElseThrow(() -> new RuntimeException("Editor not found"));

        if (editorDTO.getName() != null) {
            editor.setName(editorDTO.getName());
        }
        if (editorDTO.getUsername() != null) {
            editor.setUsername(editorDTO.getUsername());
        }
        if (editorDTO.getEmail() != null) {
            editor.setEmail(editorDTO.getEmail());
        }
        if (editorDTO.getPassword() != null) {
            editor.setPassword(passwordEncoder.encode(editorDTO.getPassword()));
        }
        if (editorDTO.getExperience() != 0) {
            editor.setExperience(editorDTO.getExperience());
        }
        if (editorDTO.getApp() != null) {
            editor.setApp(editorDTO.getApp());
        }
        if (editorDTO.getSocials() != null) {
            editor.setSocials(editorDTO.getSocials());
        }

        Editor updatedEditor = editorRepository.save(editor);
        return mapToEditorDTO(updatedEditor);
    }
}
