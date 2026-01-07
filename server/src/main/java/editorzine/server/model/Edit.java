package editorzine.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edit {
    @Id
    private int id;

    @ManyToOne
    private Fandom fandom;

    // introduce many editors in future for collabs
    @ManyToOne
    private Editor editor;

    @ManyToOne
    private Style style;

    private List<URL> urls = new ArrayList<>();

    private int loops;

    @ManyToOne
    private Audio audio;

}
