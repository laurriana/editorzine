package editorzine.server.dto;

import lombok.Data;

import java.util.List;

@Data
public class EditDTO {
    private int editorId;
    private int fandomId;
    private int styleId;
    private int audioId;
    private List<String> urls;
    private int loops;
}
