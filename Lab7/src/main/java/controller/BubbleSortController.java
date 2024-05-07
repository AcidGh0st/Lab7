package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BubbleSortController
{
    @javafx.fxml.FXML
    private TableView tableView_NoSortedArray;
    @javafx.fxml.FXML
    private Button btn_Randomize;
    @javafx.fxml.FXML
    private Button btn_Start;
    @javafx.fxml.FXML
    private TableView tableView_BubbleSortedResults;
    @javafx.fxml.FXML
    private TextField txf_iterations;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void StartOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void RandomizeOnAction(ActionEvent actionEvent) {
    }
}