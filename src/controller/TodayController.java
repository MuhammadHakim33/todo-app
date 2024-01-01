package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TodoModel;
import model.TodoModelTable;

import java.net.URL;
import java.util.ResourceBundle;

public class TodayController extends Controller implements Initializable {

    @FXML
    private TextField inputTodo;

    @FXML
    private MenuButton menuList;

    @FXML
    private MenuItem menuItem;

    @FXML
    private TableView<TodoModelTable> tableTodoPrivate;

    @FXML
    private TableColumn<TodoModelTable, String> columnTodo;

    @FXML
    private TableColumn<TodoModelTable, Button> columnCompleted;

    @FXML
    private TableColumn<TodoModelTable, Button> columnDelete;

    @FXML
    private TableView<TodoModel> tableTodoCompleted;

    @FXML
    private TableColumn<TodoModel, String> columnTodoCompletedTest;

    @FXML
    private TableColumn<TodoModel, Button> columnCompletedTest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableTodoPublic = tableTodoPrivate;
//        tableTodoNewCompleted = tableTodoCompleted;
//
//        menuList.setText("Today");
//
        columnTodo.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        columnCompleted.setCellValueFactory(new PropertyValueFactory<>("completedBtn"));
//
//        columnTodoCompletedTest.setCellValueFactory(new PropertyValueFactory<TodoModel, String>("todo"));
//        columnCompletedTest.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("completedBtn"));

        try {
            displayTable();
            tableTodoPrivate.setItems(listTodo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addTodo() {
//        if (!inputTodo.getText().isEmpty()) {
//            String input = inputTodo.getText();
//            CategoryModel category = new CategoryModel("today");
//            Button deleteBtn = new Button("Delete");
//            Button completedBtn = new Button("Selesai");
//
//            TodoModel todoItem = new TodoModel(input, category, false, deleteBtn, completedBtn);
//
//            deleteBtn.setOnAction(e -> deleteRow(todoItem));
//            completedBtn.setOnAction(e -> completedRow(todoItem));
//
//            listTodo.add(todoItem);
//            displayTable(listTodo, tableTodo);
//            inputTodo.setText("");
//        }
    }
}
