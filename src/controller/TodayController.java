package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TodoModelTable;

import java.net.URL;
import java.util.ResourceBundle;

public class TodayController extends Controller implements Initializable {

    @FXML
    private TextField inputTodo;

    @FXML
    private TableView<TodoModelTable> tableTodoPrivate;

    @FXML
    private TableColumn<TodoModelTable, String> columnTodo;

    @FXML
    private TableColumn<TodoModelTable, Button> columnCompleted;

    @FXML
    private TableColumn<TodoModelTable, Button> columnDelete;

    @FXML
    private TableView<TodoModelTable> tableTodoPrivateCompleted;

    @FXML
    private TableColumn<TodoModelTable, String> columnTodoCompleted;

    @FXML
    private TableColumn<TodoModelTable, Button> columnCompletedCompleted;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableTodoPublic = tableTodoPrivate;
        tableTodoPublicCompleted = tableTodoPrivateCompleted;

        columnTodo.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        columnCompleted.setCellValueFactory(new PropertyValueFactory<>("completedBtn"));

        columnTodoCompleted.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnCompletedCompleted.setCellValueFactory(new PropertyValueFactory<>("completedBtn"));

        try {
            displayTable();
            displayTableCompleted();
            tableTodoPrivate.setItems(listTodo);
            tableTodoPrivateCompleted.setItems(listTodoCompleted);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addTodo() {
        try {
            if (!inputTodo.getText().isEmpty()) {
                insert(inputTodo.getText());
                inputTodo.setText("");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
