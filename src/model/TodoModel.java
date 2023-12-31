package model;

import javafx.scene.control.Button;

public class TodoModel {
    private String todo;
    private CategoryModel category;
    private Boolean completed;
    private Button deleteBtn;
    private Button completedBtn;

    public TodoModel(String todo, CategoryModel category, Boolean completed, Button deleteBtn, Button completedBtn) {
        this.todo = todo;
        this.category = category;
        this.completed = completed;
        this.deleteBtn = deleteBtn;
        this.completedBtn = completedBtn;

//        deleteBtn.setOnAction(e -> {
//            TodoModel selectedTodo = today.tableTodoNew.getSelectionModel().getSelectedItem();
//            if(selectedTodo != null) {
//                if(selectedTodo.getDeleteBtn() == deleteBtn) {
//                    today.tableTodoNew.getItems().remove(selectedTodo);
//                }
//            }
//        });

//        completedBtn.setOnAction(e -> {
//            TodoModel selectedTodo = today.tableTodoNew.getSelectionModel().getSelectedItem();
//            int selectedIndex = today.tableTodoNew.getSelectionModel().getSelectedIndex();
//
//            if(selectedTodo != null) {
//                if(selectedTodo.getCompletedBtn() == completedBtn) {
//
//                    selectedTodo.setCompleted(true);
//                    selectedTodo.getCompletedBtn().setText("Batal");
//
//                    today.listTodoCompleted.add(selectedTodo);
//                    today.tableTodoNew.getItems().remove(selectedTodo);
//
//                    today.displayTable();
//                    today.displayTableCompleted();
//                }
//            }
//        });
    }

    public String getTodo() {
        return todo;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Button getCompletedBtn() {
        return completedBtn;
    }

    public void setTodo(String todoNew) {
        this.todo = todoNew;
    }

    public void setCompleted(Boolean completedNew) {
        this.completed = completedNew;
    }
}
