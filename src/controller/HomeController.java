package controller;

import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TodoModel;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public static TableView<TodoModel> tableTodoNew;
    public static TableColumn<TodoModel, String> columnTodoNew;

    @FXML
    private TextField inputTodo;

    @FXML
    private Button buttonTodo;

    @FXML
    private TableView<TodoModel> tableTodo;

    @FXML
    private TableColumn<TodoModel, String> columnTodo;

    @FXML
    private TableColumn<TodoModel, Button> columnCompleted;

    @FXML
    private TableColumn<TodoModel, Button> columnDelete;

    public static ObservableList<TodoModel> todoItem = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableTodoNew = tableTodo;
        columnTodo.setCellValueFactory(new PropertyValueFactory<TodoModel, String>("todo"));
        columnDelete.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("deleteBtn"));
        columnCompleted.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("completedBtn"));
        displayTable();
    }

    @FXML
    public void addTodo(ActionEvent event) {
        if (!inputTodo.getText().isEmpty()) {
            todoItem.add(new TodoModel(inputTodo.getText(),"today",false, new Button("Delete"), new Button("Selesai")));
            System.out.println(todoItem);
            displayTable();
//            tableTodo.setItems(todoItem);
//            tableTodo.getItems().add(
//                    new TodoModel(inputTodo.getText(),"today",false, new Button("Delete"), new Button("Selesai"))
//            );
            inputTodo.setText("");

        }
    }

    public static void displayTable() {
        tableTodoNew.setItems(todoItem);
    }
}
