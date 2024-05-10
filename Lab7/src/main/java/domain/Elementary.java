/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class Elementary {


    private String minString =" ";
    private String minIndexString= " ";
    private int it_total =0;


    /*
    public static void setIt_total(){

        it_total=0;

    }

     */
    public  int getItTotal(){

        return it_total;
    }
    public void bubbleSort(int a[]){

        it_total=0;

        for(int i=1;i<a.length;i++) {


            for (int j = 0; j < a.length - i; j++) {


                if (a[j] > a[j + 1]) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;


                }//if


            }//for j
            it_total++;

        }

    }
    
    public void improvedBubbleSort(int a[]){
        it_total=0;

	    boolean swapped = true; //intercambiado
	    for(int i=1;swapped;i++){
            swapped = false;
            for(int j=0;j<a.length-i;j++){

                if(a[j]>a[j+1]){
                    int aux=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux;
                    swapped = true;
                }//if
            }//for j

            it_total++;
	    }//for i
    }

    public void selectionSort(int a[]) {
        // Limpiar el valor anterior
        it_total = 0;
        minString = "";
        minIndexString = "";
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
            it_total++;
            minString += min + " ";
            minIndexString += minIndex + " ";
        }
    }


    public void countingSort(int a[]) {
        int max = util.Utility.maxArray(a); //va de 0 hasta el elemento maximo
        // create buckets
        int counter[] = new int[max + 1];
        // fill buckets
        for (int element : a) {
            counter[element]++; //incrementa el num de ocurrencias del elemento
        }
        // sort array
        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]>0) { //significa q al menos hay un elemento (q existe)
                a[index++] = i;
                counter[i]--;
            }
        }//for i
    }


    public String getMinIndex() {
        return minIndexString;
    }

    public String getMin() {
        return minString;
    }
}
