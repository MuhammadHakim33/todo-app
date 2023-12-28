package model;

import controller.HomeController;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class TodoModel {
    private String todo;
    private String category;
    private Boolean completed;
    private Button deleteBtn;
    private Button completedBtn;

    public TodoModel(String todo, String category, Boolean completed, Button deleteBtn, Button completedBtn) {
        this.todo = todo;
        this.category = category;
        this.completed = completed;
        this.deleteBtn = deleteBtn;
        this.completedBtn = completedBtn;


        deleteBtn.setOnAction(e -> {
            TodoModel selectedTodo = HomeController.tableTodoNew.getSelectionModel().getSelectedItem();
            if(selectedTodo != null) {
                if(selectedTodo.getDeleteBtn() == deleteBtn) {
                    HomeController.tableTodoNew.getItems().remove(selectedTodo);
                }
            }
        });

        completedBtn.setOnAction(e -> {
            TodoModel selectedTodo = HomeController.tableTodoNew.getSelectionModel().getSelectedItem();
            int selectedIndex = HomeController.tableTodoNew.getSelectionModel().getSelectedIndex();
            System.out.println(selectedTodo);
            System.out.println(selectedIndex);
            if(selectedTodo != null) {
                if(selectedTodo.getDeleteBtn() == deleteBtn) {
                    selectedTodo.setCompleted(true);
                    HomeController.todoItem.set(selectedIndex ,selectedTodo);
                    HomeController.displayTable();
                }
            }
        });
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todoNew) {
        this.todo = todoNew;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completedNew) {
        this.completed = completedNew;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Button getCompletedBtn() {
        return completedBtn;
    }
}
