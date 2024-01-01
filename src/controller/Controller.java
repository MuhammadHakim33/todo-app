package controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.TodoModel;
import model.TodoModelApi;
import model.TodoModelTable;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller  {

    public TableView<TodoModelTable> tableTodoPublic;
    public TableView<TodoModel> tableTodoNewCompleted;

    public ObservableList<TodoModelTable> listTodo = FXCollections.observableArrayList();
    public ObservableList<TodoModel> listTodoCompleted = FXCollections.observableArrayList();

    public void deleteRow(TodoModelTable todoModel) throws Exception {
        TodoModelTable selectedTodo = tableTodoPublic.getSelectionModel().getSelectedItem();
        if(selectedTodo != null) {
            if(selectedTodo.getDeleteBtn() == todoModel.getDeleteBtn()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .DELETE()
                        .uri(new URI("https://todo-api-omega-one.vercel.app/api/v1/todos/" + selectedTodo.get_id()))
                        .build();

                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.statusCode());
                System.out.println(response.body());

                displayTable();
            }
        }
    }

    public void completedRow(TodoModelTable todoModel) throws Exception {
        TodoModelTable selectedTodo = tableTodoPublic.getSelectionModel().getSelectedItem();
        if(selectedTodo != null) {
            if(selectedTodo.getCompletedBtn() == todoModel.getCompletedBtn()) {

                Gson gson = new Gson();

                TodoModelApi todoModelApi = new TodoModelApi(
                        selectedTodo.getName(),
                        selectedTodo.getCategory().getCategory(),
                        true,
                        selectedTodo.get_id()
                );

                String requestBody = gson.toJson(todoModelApi);

                System.out.println(requestBody);

                HttpRequest request = HttpRequest.newBuilder()
                        .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                        .uri(new URI("https://todo-api-omega-one.vercel.app/api/v1/todos/" + selectedTodo.get_id()))
                        .build();

                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.statusCode());
                System.out.println(response.body());

                displayTable();

//                selectedTodo.setCompleted(true);
//                selectedTodo.getCompletedBtn().setText("Batal");
//
//                listTodoCompleted.add(selectedTodo);
//                tableTodoNew.getItems().remove(selectedTodo);
//
////                displayTable(listTodo);
//                displayTableCompleted();
            }
        }
    }

    public void displayTable() throws Exception {
        listTodo.clear();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://todo-api-omega-one.vercel.app/api/v1/todos?complete=false"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        int responelength = response.body().length();
        List<String> responseList = new ArrayList<String>(Arrays.asList(response.body().substring(1, responelength-2).split("},")));

        Gson gson = new Gson();

        for (String i: responseList) {
            TodoModelApi todoModelApi = gson.fromJson(i + "}", TodoModelApi.class);

            Button deleteBtn = new Button("Delete");
            Button completedBtn = new Button("Selesai");

            TodoModelTable todoItem= new TodoModelTable(
                    todoModelApi.get_id(),
                    todoModelApi.getName(),
                    todoModelApi.getCategory(),
                    todoModelApi.getComplete(),
                    deleteBtn,
                    completedBtn
            );

            deleteBtn.setOnAction(e -> {
                try {
                    deleteRow(todoItem);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            completedBtn.setOnAction(e -> {
                try {
                    completedRow(todoItem);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            });


            listTodo.add(todoItem);
        }
    }

    public void displayTableCompleted() {
        tableTodoNewCompleted.setItems(listTodoCompleted);
    }
}
