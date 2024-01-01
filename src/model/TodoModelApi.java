package model;

public class TodoModelApi implements TodoInterface {
    private String name;
    private String category;
    private Boolean complete;
    private String _id;

    public TodoModelApi(String name, String category, Boolean complete, String id) {
        this.name = name;
        this.category = category;
        this.complete =  complete;
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getComplete() {
        return complete;
    }

    public String get_id() {
        return _id;
    }
}
