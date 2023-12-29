package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TodoModel;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public static TableView<TodoModel> tableTodoNew;
    public static TableView<TodoModel> tableTodoNewCompleted;
    public static TableColumn<TodoModel, String> columnTodoNew;

    @FXML
    private TextField inputTodo;

    @FXML
    private TableView<TodoModel> tableTodo;

    @FXML
    private TableColumn<TodoModel, String> columnTodo;

    @FXML
    private TableColumn<TodoModel, Button> columnCompleted;

    @FXML
    private TableColumn<TodoModel, Button> columnDelete;

    @FXML
    private TableView<TodoModel> tableTodoCompleted;

    @FXML
    private TableColumn<TodoModel, String> columnTodoCompletedTest;

    @FXML
    private TableColumn<TodoModel, Button> columnCompletedTest;

    public static ObservableList<TodoModel> todoItem = FXCollections.observableArrayList();
    public static ObservableList<TodoModel> todoItemCompleted = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableTodoNew = tableTodo;
        tableTodoNewCompleted = tableTodoCompleted;
        columnTodo.setCellValueFactory(new PropertyValueFactory<TodoModel, String>("todo"));
        columnDelete.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("deleteBtn"));
        columnCompleted.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("completedBtn"));

        columnTodoCompletedTest.setCellValueFactory(new PropertyValueFactory<TodoModel, String>("todo"));
        columnCompletedTest.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("completedBtn"));
        displayTable();
    }

    @FXML
    public void addTodo(ActionEvent event) {
        if (!inputTodo.getText().isEmpty()) {
            todoItem.add(new TodoModel(inputTodo.getText(),"today",false, new Button("Delete"), new Button("Selesai")));
            displayTable();
            inputTodo.setText("");
        }
    }

    public static void displayTable() {
        tableTodoNew.setItems(todoItem);
    }

    public static void displayTableCompleted() {
        tableTodoNewCompleted.setItems(todoItemCompleted);
    }
}
