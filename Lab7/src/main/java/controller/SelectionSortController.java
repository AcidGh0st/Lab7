package controller;


import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.Random;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;


public class SelectionSortController {
    @FXML
    private TableView  tableView_noSortedArray;
    @FXML
    private TableView tableView_SortedArray;
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
        tableView_SortedArray.getItems().add(rowData);

        // Inicializar elementary
        elementary = new Elementary();

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
            tableView_SortedArray.getColumns().add(column);
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
        elementary.selectionSort(dataArray);

        // Crear una nueva lista para los datos ordenados
        ObservableList<String> sortedRowData = FXCollections.observableArrayList();

        // Convertir los valores ordenados a String y agregarlos a la lista
        for (int i = 0; i < dataArray.length; i++) {
            sortedRowData.add(String.valueOf(dataArray[i]));
        }

        txf_Min.setText(elementary.getMin());
        txf_minIndex.setText(elementary.getMinIndex());
        txf_interations.setText(String.valueOf(elementary.getItTotal()));

        // Agregar los datos ordenados a la tabla tableView_SortedArray
        tableView_SortedArray.getItems().add(sortedRowData);
    }
}