package controller;

import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Random;

public class CountingSortController
{
    @FXML
    private TableView tableView_noSortedArray;
    @FXML
    private TableView tableView_counterArray;
    @FXML
    private TableView tableView_countingSortedArray;
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

    Elementary elementary;

    @FXML
    public void initialize() {
        // Crear una fila vacía y agregarla a la tabla
        ObservableList<String> rowData = FXCollections.observableArrayList();
        elementary = new Elementary();

        for (int i = 0; i < 200; i++) {
            rowData.add(""); // Se añaden 200 elementos vacíos
        }
        tableView_noSortedArray.getItems().add(rowData);
        tableView_counterArray.getItems().add(rowData);
        tableView_countingSortedArray.getItems().add(rowData);

        // Inicializar elementary

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
            tableView_counterArray.getColumns().add(column);
        }

        for (int i = 0; i < 200; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(String.valueOf(i));

            int columnIndex = i;

            // Configurar la celda para obtener los valores de las celdas de la columna
            column.setCellValueFactory(cellData -> {
                ObservableList<String> row = cellData.getValue();
                return new SimpleStringProperty(row.get(columnIndex));
            });

            // Agregar cada TableColumn creado al conjunto de columnas
            tableView_countingSortedArray.getColumns().add(column);
        }

    }

    @FXML
    public void StartOnAction(ActionEvent actionEvent) {

        tableView_counterArray.getItems().clear();

//        pane2_Sorted.setVisible(true);

        // Obtener los valores de las celdas de la tabla no ordenada y almacenarlos en un arreglo
        ObservableList<String> rowData = (ObservableList<String>) tableView_noSortedArray.getItems().get(0);
        int arraySize = rowData.size();
        int[] dataArray = new int[arraySize];

        // Convertir los valores de String a enteros y almacenarlos en el arreglo
        for (int i = 0; i < arraySize; i++) {
            try {
                dataArray[i] = Integer.parseInt(rowData.get(i));
            } catch (NumberFormatException e) {
                // Manejar la excepción si los valores no son números enteros
                // Aquí puedes agregar una lógica para tratar con este caso, por ejemplo, asignar un valor predeterminado o mostrar un mensaje de error
                e.printStackTrace();
                return; // Terminar el método si no se pueden convertir los valores
            }
        }


        // Ordenar el arreglo utilizando Selection Sort
        elementary.countingSort(dataArray);

        // Crear una nueva lista para los datos ordenados
        ObservableList<String> CountingSortController = FXCollections.observableArrayList();

        // Convertir los valores ordenados a String y agregarlos a la lista
        for (int i = 0; i < dataArray.length; i++) {
            CountingSortController.add(String.valueOf(dataArray[i]));
        }


        // Agregar los datos ordenados a la tabla tableView_counterArray
        tableView_counterArray.getItems().add(CountingSortController);

    }

    @FXML
    public void RandomizeOnAction(ActionEvent actionEvent) {
        Random rand = new Random();

        ObservableList<String> rowData = FXCollections.observableArrayList(); //Almacenar los numeros aleatorios

        //Generar 200 numeros aleatorios
        for (int i = 0; i < 200; i++) {
            rowData.add(String.valueOf(rand.nextInt(100))); //Almacenar los numros en el Table y mostrar cada uno en una columna diferente
        }
        tableView_noSortedArray.getItems().set(0, rowData); // Actualizar la fila con los nuevos números
    }
}