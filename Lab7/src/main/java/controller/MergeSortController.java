package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MergeSortController
{
    @javafx.fxml.FXML
    private BorderPane borderPane;
    @javafx.fxml.FXML
    private TableView tableView_noSortedArray;
    @javafx.fxml.FXML
    private TextField txf_high;
    @javafx.fxml.FXML
    private Button btn_Randomize;
    @javafx.fxml.FXML
    private Button btn_Start;
    @javafx.fxml.FXML
    private TableView tableView_TempArray;
    @javafx.fxml.FXML
    private TextField txf_low;
    @javafx.fxml.FXML
    private TableView tableView_MergeSortedResults;
    @javafx.fxml.FXML
    private TextField txf_RecursiveCalls;

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