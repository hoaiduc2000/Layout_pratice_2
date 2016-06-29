package model;

/**
 * Created by nguyen.hoai.duc on 6/29/2016.
 */
public class NavDrawerItem {
    private int id;
    private String title;

    public NavDrawerItem(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NavDrawerItem(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
