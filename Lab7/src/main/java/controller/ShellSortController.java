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

public class ShellSortController
{
    @javafx.fxml.FXML
    private BorderPane borderPane;
    @javafx.fxml.FXML
    private TableView tableView_noSortedArray;
    @javafx.fxml.FXML
    private TextField txf_grapN2;
    @javafx.fxml.FXML
    private TableView tableView_SortedArray;
    @javafx.fxml.FXML
    private Button btn_Randomize;
    @javafx.fxml.FXML
    private Button btn_Start;
    @javafx.fxml.FXML
    private TextField txf_grapArray1;
    @javafx.fxml.FXML
    private TextField txf_grapArray3;
    @javafx.fxml.FXML
    private TextField txf_grapArray2;

    private int [] dataArray;

    @javafx.fxml.FXML
    public void initialize() {

        this.dataArray=new int[200];
        // Ajustar las columnas al tamaño de la tabla
//        tableView_NoSortedArray.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Crear una fila vacía y agregarla a la tabla
        ObservableList<String> rowData = FXCollections.observableArrayList();

        for (int i = 0; i < 200; i++) {
            rowData.add(""); // Se añaden 200 elementos vacíos
        }
        tableView_noSortedArray.getItems().add(rowData);
        tableView_SortedArray.getItems().add(rowData);

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
            tableView_SortedArray.getColumns().add(column);
        }

    }

    @javafx.fxml.FXML
    public void StartOnAction(ActionEvent actionEvent) {


        // Limpiar la tabla de datos ordenados antes de agregar nuevas filas
        tableView_SortedArray.getItems().clear();


        // Obtener los valores de las celdas de la tabla no ordenada y almacenarlos en un arreglo
        ObservableList<String> rowData = (ObservableList<String>) tableView_noSortedArray.getItems().get(0);
        int arraySize = rowData.size();


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

        Complex c = new Complex();
        c.shellSort(dataArray);


        // Crear una nueva lista para los datos ordenados
        ObservableList<String> sortedRowData = FXCollections.observableArrayList();

        // Convertir los valores ordenados a String y agregarlos a la lista
        for (int i = 0; i < dataArray.length; i++) {
            sortedRowData.add(String.valueOf(dataArray[i]));
        }


        // Agregar los datos ordenados a la tabla tableView_BubbleSortedResults
        tableView_SortedArray.getItems().add(sortedRowData);

        // Obtener los valores de gap de la instancia de Complex
        List<Integer> gapN2Values = c.getGapN2Values();
        List<Integer> gapArray1Values = c.getGapArray1Values();
        List<Integer> gapArray2Values = c.getGapArray2Values();
        List<Integer> gapArray3Values = c.getGapArray3Values();

        // Mostrar los valores de gap en los campos de texto correspondientes
        txf_grapN2.setText(gapN2Values.toString()); // Muestra todos los números que pasaron por gapN2
        txf_grapArray1.setText(gapArray1Values.toString()); // Muestra todos los números que pasaron por gapArray1
        txf_grapArray2.setText(gapArray2Values.toString()); // Muestra todos los números que pasaron por gapArray2
        txf_grapArray3.setText(gapArray3Values.toString()); // Muestra todos los números que pasaron por gapArray3


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
