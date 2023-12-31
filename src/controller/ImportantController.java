package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CategoryModel;
import model.TodoModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ImportantController extends Controller implements Initializable {

    @FXML
    private TextField inputTodo;

    @FXML
    private MenuButton menuList;

    @FXML
    private MenuItem menuItem;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        tableTodoNew = tableTodo;
        menuList.setText("Important");

        columnTodo.setCellValueFactory(new PropertyValueFactory<TodoModel, String>("todo"));
        columnDelete.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("deleteBtn"));
        columnCompleted.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("completedBtn"));

        columnTodoCompletedTest.setCellValueFactory(new PropertyValueFactory<TodoModel, String>("todo"));
        columnCompletedTest.setCellValueFactory(new PropertyValueFactory<TodoModel, Button>("completedBtn"));

//        displayTable(listTodo);
    }

    @FXML
    public void addTodo() {
        if (!inputTodo.getText().isEmpty()) {
            String input = inputTodo.getText();

            CategoryModel category = new CategoryModel("important");
            Button deleteBtn = new Button("Delete");
            Button completedBtn = new Button("Selesai");

            TodoModel todoItem = new TodoModel(input, category, false, deleteBtn, completedBtn);

            deleteBtn.setOnAction(e -> deleteRow(todoItem));
            completedBtn.setOnAction(e -> completedRow(todoItem));

            listTodo.add(todoItem);
            displayTable(listTodo, tableTodo);
            inputTodo.setText("");
        }
    }

    public void goTodayPage() throws IOException {
        changePage(menuItem, "view/today.fxml");
    }
}
