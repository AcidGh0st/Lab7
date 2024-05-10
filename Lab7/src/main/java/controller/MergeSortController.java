package controller;

import domain.Complex;
import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.util.List;
import java.util.Random;

public class MergeSortController {
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

    private int[] dataArray;

    @javafx.fxml.FXML
    public void initialize() {

        this.dataArray = new int[200];
        // Ajustar las columnas al tamaño de la tabla
//        tableView_NoSortedArray.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Crear una fila vacía y agregarla a la tabla
        ObservableList<String> rowData = FXCollections.observableArrayList();

        for (int i = 0; i < 200; i++) {
            rowData.add(""); // Se añaden 200 elementos vacíos
        }
        tableView_noSortedArray.getItems().add(rowData);
        tableView_MergeSortedResults.getItems().add(rowData);
        tableView_TempArray.getItems().add(rowData);

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
            tableView_MergeSortedResults.getColumns().add(column);
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
            tableView_TempArray.getColumns().add(column);
        }


    }

    @javafx.fxml.FXML
    public void StartOnAction(ActionEvent actionEvent) {
        // Limpiar la tabla de datos ordenados antes de agregar nuevas filas
        tableView_MergeSortedResults.getItems().clear();
        tableView_TempArray.getItems().clear(); // Limpiar tableView_TempArray

        // Obtener los valores de las celdas de la tabla no ordenada y almacenarlos en un arreglo
        ObservableList<String> rowData = (ObservableList<String>) tableView_noSortedArray.getItems().get(0);
        int arraySize = rowData.size();
        //int[] dataArray = new int[arraySize];

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

        // Ordenar el arreglo utilizando Merge Sort
        Complex c = new Complex();
        int[] tempArray = new int[dataArray.length]; // Crear un arreglo temporal para almacenar los valores durante el proceso de merge
        c.mergeSort(dataArray, tempArray, 0, dataArray.length - 1);

        // Crear una nueva lista para los datos ordenados
        ObservableList<String> sortedRowData = FXCollections.observableArrayList();

        // Obtener los valores de high y low
        List<Integer> highValues = c.getHighValues();
        List<Integer> lowValues = c.getLowValues();

        // Mostrar los valores en los campos de texto
        txf_high.setText(highValues.toString());
        txf_low.setText(lowValues.toString());
        // Convertir los valores ordenados a String y agregarlos a la lista
        for (int i = 0; i < dataArray.length; i++) {
            sortedRowData.add(String.valueOf(dataArray[i]));
        }

        // Agregar los datos ordenados a la tabla tableView_MergeSortedResults
        tableView_MergeSortedResults.getItems().add(sortedRowData);

        // Obtener el arreglo temporal de merge y mostrarlo en tableView_TempArray
        ObservableList<String> tempRowData = FXCollections.observableArrayList();
        for (int i = 0; i < tempArray.length; i++) {
            tempRowData.add(String.valueOf(tempArray[i]));
        }
        tableView_TempArray.getItems().add(tempRowData);

        txf_RecursiveCalls.setText(String.valueOf(c.getRecursiveCalls()));

    }


    @javafx.fxml.FXML
    public void RandomizeOnAction(ActionEvent actionEvent) {

        Random rand = new Random(); //Generar numeros aleatorios


        ObservableList<String> rowData = FXCollections.observableArrayList(); //Almacenar los numeros aleatorios

        //Generar 200 numeros aleatorios
        for (int i = 0; i < 200; i++) {
            rowData.add(String.valueOf(rand.nextInt(50))); //Almacenar los numros en el Table y mostrar cada uno en una columna diferente
        }
        tableView_noSortedArray.getItems().set(0, rowData); // Actualizar la fila con los nuevos números
    }
}