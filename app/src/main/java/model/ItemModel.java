package model;

/**
 * Created by BG204119 on 2015/12/30.
 */
public class ItemModel {
    private String name;
    private String url;
    private boolean check;
    int resourceId;

    public ItemModel() {

    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public ItemModel(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
