package editorzine.server.controller;

import editorzine.server.model.Edit;
import editorzine.server.service.EditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/edit")
public class EditController {
    private final EditService editService;

    public EditController(EditService editService) {
        this.editService = editService;
    }

    @PostMapping("/create")
    public ResponseEntity createEdit(@RequestBody Edit edit) {
        editService.saveEdit(edit);
        return ResponseEntity.ok().build();
    }
}
