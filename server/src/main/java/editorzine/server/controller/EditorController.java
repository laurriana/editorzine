package editorzine.server.controller;

import editorzine.server.dto.EditorDTO;
import editorzine.server.service.EditorService;
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
        return editorService.modifyEditor(id, editorDTO);
    }
}
