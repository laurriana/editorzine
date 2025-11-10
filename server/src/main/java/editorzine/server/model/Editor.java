package editorzine.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Editor extends User {

    private String name;

    private int experience = 0;

    @ManyToMany
    private List<Fandom> fandomList = new ArrayList<>();

    @OneToMany
    private List<Edit> editList = new ArrayList<>();

    private URL img;

    private List<URL> socials = new ArrayList<>();

    // add feature of many apps if needed
    private String app;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Fandom> getFandomList() {
        return fandomList;
    }

    public void setFandomList(List<Fandom> fandomList) {
        this.fandomList = fandomList;
    }

    public List<Edit> getEditList() {
        return editList;
    }

    public void setEditList(List<Edit> editList) {
        this.editList = editList;
    }

    public URL getImg() {
        return img;
    }

    public void setImg(URL img) {
        this.img = img;
    }

    public List<URL> getSocials() {
        return socials;
    }

    public void setSocials(List<URL> socials) {
        this.socials = socials;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
