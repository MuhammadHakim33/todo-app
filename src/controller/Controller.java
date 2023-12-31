package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.TodoModel;

import java.io.IOException;

public class Controller  {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public TableView<TodoModel> tableTodoNew;
    public TableView<TodoModel> tableTodoNewCompleted;

    public ObservableList<TodoModel> listTodo = FXCollections.observableArrayList();
    public ObservableList<TodoModel> listTodoCompleted = FXCollections.observableArrayList();

    public void deleteRow(TodoModel todoModel) {
        TodoModel selectedTodo = tableTodoNew.getSelectionModel().getSelectedItem();
        if(selectedTodo != null) {
            if(selectedTodo.getDeleteBtn() == todoModel.getDeleteBtn()) {
                tableTodoNew.getItems().remove(selectedTodo);
            }
        }
    }

    public void completedRow(TodoModel todoModel) {
        TodoModel selectedTodo = tableTodoNew.getSelectionModel().getSelectedItem();

        if(selectedTodo != null) {
            if(selectedTodo.getCompletedBtn() == todoModel.getCompletedBtn()) {

                selectedTodo.setCompleted(true);
                selectedTodo.getCompletedBtn().setText("Batal");

                listTodoCompleted.add(selectedTodo);
                tableTodoNew.getItems().remove(selectedTodo);

//                displayTable(listTodo);
                displayTableCompleted();
            }
        }
    }

    public void changePage(MenuItem menuItem, String view) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource(view));
        stage = (Stage)menuItem.getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayTable(ObservableList<TodoModel> list, TableView<TodoModel> tableTodo) {
        System.out.println(list);
        tableTodo.setItems(list);
    }

    public void displayTableCompleted() {
        tableTodoNewCompleted.setItems(listTodoCompleted);
    }
}
