package editorzine.server.dto;

import editorzine.server.model.Edit;
import editorzine.server.model.Fandom;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditorDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    @NotEmpty(message = "email cannot be empty!")
    @Email
    private String email;

    @NotEmpty(message = "password cannot be empty!")
    private String password;

    // additional info that's not needed at auth

    private int experience;
    private String app;
    private List<URL> socials;
    private List<Fandom> fandoms;
    private List<Edit> edits;


}
