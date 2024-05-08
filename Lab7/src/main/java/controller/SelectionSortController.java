package controller;


import domain.Elementary;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.Random;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;


public class SelectionSortController {
    @FXML
    private TableView tableView_noSortedArray;
    @FXML
    private TableView<String> tableView_SortedArray;
    @FXML
    private Button btn_Randomize;
    @FXML
    private Button btn_Start;
    @FXML
    private TextField txf_interations;
    @FXML
    private TextField txf_Min;
    @FXML
    private TextField txf_minIndex;
    @FXML
    private Pane pane2_Sorted;
    Elementary elementary;


    @FXML
    public void initialize() {

        // Ajustar las columnas al tamaño de la tabla
//        tableView_noSortedArray.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Crear una fila vacía y agregarla a la tabla
        ObservableList<String> rowData = FXCollections.observableArrayList();

        for (int i = 0; i < 200; i++) {
            rowData.add(""); // Se añaden 200 elementos vacíos
        }
        tableView_noSortedArray.getItems().add(rowData);


        // Crear las columnas del TableView de forma dinámica
        for (int i = 0; i < 200; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(String.valueOf(i));

            int columnIndex = i;

            // Configurar la celda para obtener los valores de las celdas de la columna
            column.setCellValueFactory(cellData -> {
                ObservableList<String> row = cellData.getValue();
                return new SimpleStringProperty(row.get(columnIndex));
            });

            // Agregar cada TableColumn creado al conjunto de columnas
            tableView_noSortedArray.getColumns().add(column);
        }
    }


    @FXML
    public void RandomizeOnAction(ActionEvent actionEvent) {
        Random rand = new Random();
        pane2_Sorted.setVisible(false); // Ocultar el panel 2

            ObservableList<String> rowData = FXCollections.observableArrayList(); //Almacenar los numeros aleatorios

            //Generar 200 numeros aleatorios
            for (int i = 0; i < 200; i++) {
                rowData.add(String.valueOf(rand.nextInt(100))); //Almacenar los numros en el Table y mostrar cada uno en una columna diferente
            }
            tableView_noSortedArray.getItems().set(0, rowData); // Actualizar la fila con los nuevos números
    }




    @FXML
    public void StartOnAction(ActionEvent actionEvent) {
        // Limpiar la tabla de datos ordenados antes de agregar nuevas filas
        tableView_SortedArray.getItems().clear();

        pane2_Sorted.setVisible(true);

        // Obtener los valores de las celdas de la tabla y almacenarlos en un arreglo
        int arraySize = tableView_SortedArray.getItems().size();

        int[] dataArray = new int[tableView_noSortedArray.getItems().size()];
        for (int i = 0; i < tableView_noSortedArray.getItems().size(); i++) {
            dataArray[i] = (int) tableView_noSortedArray.getItems().get(i);
        }

        // Ordenar el arreglo utilizando Selection Sort
        elementary.selectionSort(dataArray);



        // Agregar los datos ordenados a la tabla tableView_SortedArray
        for (int i = 0; i < dataArray.length; i++) {
            tableView_SortedArray.getItems().add(String.valueOf(dataArray[i]));
        }
    }
}
