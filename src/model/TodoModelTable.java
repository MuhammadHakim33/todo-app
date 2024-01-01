package model;

import javafx.scene.control.Button;

public class TodoModelTable implements TodoInterface{
    private String _id;
    private String name;
    private CategoryModel category;
    private Boolean complete;
    private Button deleteBtn;
    private Button completedBtn;

    public TodoModelTable(String id, String name, String category, Boolean complete, Button deleteBtn, Button completedBtn) {
        this._id = id;
        this.name = name;
        this.category = new CategoryModel(category);
        this.complete =  complete;
        this.deleteBtn = deleteBtn;
        this.completedBtn = completedBtn;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public Boolean getComplete() {
        return complete;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Button getCompletedBtn() {
        return completedBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public void setCompletedBtn(Button completedBtn) {
        this.completedBtn = completedBtn;
    }
}
