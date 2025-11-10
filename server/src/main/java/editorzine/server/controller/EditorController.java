package editorzine.server.controller;

import editorzine.server.dto.EditorDTO;
import editorzine.server.model.Editor;
import editorzine.server.service.EditorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editor")
public class EditorController {

    private final EditorService editorService;

    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EditorDTO>> getAll() {
        return ResponseEntity.ok().body(editorService.findAllEditors());
    }

    @PutMapping("/update/{id}")
    public EditorDTO updateEditor(@PathVariable int id, @RequestBody EditorDTO editorDTO) {
        EditorDTO e = editorService.modifyEditor(id, editorDTO);
        return e;
    }
}
