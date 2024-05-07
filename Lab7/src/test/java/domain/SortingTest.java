package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortingTest {

    @Test
    void elementaryTest() {
        // 6 arreglos con 20,000 valores enteros positivos
        int[] a = new int[20000];
        int[] b = new int[20000];
        int[] c = new int[20000];
        int[] d = new int[20000];
        int[] e = new int[20000];
        int[] f = new int[20000];

        for (int i = 0; i < 20000; i++) {
            a[i] = (int) (Math.random() * 999) + 1; // Rango entre 1 y 999
            b[i] = (int) (Math.random() * 999) + 1;
            c[i] = (int) (Math.random() * 999) + 1;
            d[i] = (int) (Math.random() * 999) + 1;
            e[i] = (int) (Math.random() * 999) + 1;
            f[i] = (int) (Math.random() * 999) + 1;
        }

        // Muestra el contenido de los primeros 500 elementos de cada arreglo por consola
        System.out.println("\nElementaryTest\nPrimeros 500 elementos de a: " + Arrays.toString(Arrays.copyOfRange(a, 0, 500)));
        System.out.println("Primeros 500 elementos de b: " + Arrays.toString(Arrays.copyOfRange(b, 0, 500)));
        System.out.println("Primeros 500 elementos de c: " + Arrays.toString(Arrays.copyOfRange(c, 0, 500)));
        System.out.println("Primeros 500 elementos de d: " + Arrays.toString(Arrays.copyOfRange(d, 0, 500)));
        System.out.println("Primeros 500 elementos de e: " + Arrays.toString(Arrays.copyOfRange(e, 0, 500)));
        System.out.println("Primeros 500 elementos de f: " + Arrays.toString(Arrays.copyOfRange(f, 0, 500)));

        Elementary elementary = new Elementary();

        // Copia de los primeros 500 elementos de los arreglos originales
        int[] aCopy = Arrays.copyOfRange(a, 0, 500);
        int[] bCopy = Arrays.copyOfRange(b, 0, 500);
        int[] cCopy = Arrays.copyOfRange(c, 0, 500);
        int[] dCopy = Arrays.copyOfRange(d, 0, 500);
        int[] eCopy = Arrays.copyOfRange(e, 0, 500);
        int[] fCopy = Arrays.copyOfRange(f, 0, 500);

        // Ordena los arreglos utilizando diferentes algoritmos de ordenamiento
        if (!isSorted(aCopy)) {
            elementary.improvedBubbleSort(aCopy);
        }
        if (!isSorted(bCopy)) {
            elementary.bubbleSort(bCopy);
        }
        if (!isSorted(cCopy)) {
            elementary.selectionSort(cCopy);
        }
        if (!isSorted(dCopy)) {
            elementary.improvedBubbleSort(dCopy);
        }
        if (!isSorted(eCopy) || !isSorted(fCopy)) {
            elementary.selectionSort(eCopy);
            elementary.selectionSort(fCopy);
        }

        // Muestra el contenido de los primeros 500 elementos de cada arreglo ya ordenado
        System.out.println("\nPrimeros 500 elementos de a ordenados: " + Arrays.toString(aCopy));
        System.out.println("Primeros 500 elementos de b ordenados: " + Arrays.toString(bCopy));
        System.out.println("Primeros 500 elementos de c ordenados: " + Arrays.toString(cCopy));
        System.out.println("Primeros 500 elementos de d ordenados: " + Arrays.toString(dCopy));
        System.out.println("Primeros 500 elementos de e ordenados: " + Arrays.toString(eCopy));
        System.out.println("Primeros 500 elementos de f ordenados: " + Arrays.toString(fCopy));
    }

    //Método para verificar si un arreglo está ordenado
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void complexTest(){

        //arreglos con 50,000 valores enteros positivos
        int[] a = new int[50000];
        int[] b = new int[50000];
        int[] c = new int[50000];
        int[] d = new int[50000];
        int[] e = new int[50000];
        int[] f = new int[50000];

        for (int i = 0; i < 50000; i++) {
            a[i] = (int) (Math.random() * 999) + 1; //Rango entre 1 y 999
            b[i] = (int) (Math.random() * 999) + 1;
            c[i] = (int) (Math.random() * 999) + 1;
            d[i] = (int) (Math.random() * 999) + 1;
            e[i] = (int) (Math.random() * 999) + 1;
            f[i] = (int) (Math.random() * 999) + 1;
        }


        //Muestra el contenido de los primeros 200 elementos de cada arreglo por consola
        System.out.println("ComplexTest\nPrimeros 200 elementos de a: " + Arrays.toString(Arrays.copyOfRange(a, 0, 200)));
        System.out.println("Primeros 200 elementos de b: " + Arrays.toString(Arrays.copyOfRange(b, 0, 200)));
        System.out.println("Primeros 200 elementos de c: " + Arrays.toString(Arrays.copyOfRange(c, 0, 200)));
        System.out.println("Primeros 200 elementos de d: " + Arrays.toString(Arrays.copyOfRange(d, 0, 200)));
        System.out.println("Primeros 200 elementos de e: " + Arrays.toString(Arrays.copyOfRange(e, 0, 200)));
        System.out.println("Primeros 200 elementos de f: " + Arrays.toString(Arrays.copyOfRange(f, 0, 200)));



        Complex complex = new Complex();

        // Copia de los primeros 500 elementos de los arreglos originales
        int[] aCopy = Arrays.copyOfRange(a, 0, 200);
        int[] bCopy = Arrays.copyOfRange(b, 0, 200);
        int[] cCopy = Arrays.copyOfRange(c, 0, 200);
        int[] dCopy = Arrays.copyOfRange(d, 0, 200);
        int[] eCopy = Arrays.copyOfRange(e, 0, 200);
        int[] fCopy = Arrays.copyOfRange(f, 0, 200);

        //Ordena los arreglos utilizando diferentes algoritmos de ordenamiento
        complex.quickSort(aCopy, 0, aCopy.length - 1);
        complex.shellSort(bCopy);
        complex.mergeSort(cCopy, new int[cCopy.length], 0, cCopy.length - 1);
        complex.shellSort(dCopy);
        complex.radixSort(eCopy, eCopy.length);
        complex.mergeSort(fCopy, new int[fCopy.length], 0, fCopy.length - 1);

        //Muestra el contenido de cada arreglo ya ordenado (los primeros 100 elementos)
        System.out.println("\nPrimeros 100 elementos de a ordenados: " + Arrays.toString(Arrays.copyOfRange(aCopy, 0, 100)));
        System.out.println("Primeros 100 elementos de b ordenados: " + Arrays.toString(Arrays.copyOfRange(bCopy, 0, 100)));
        System.out.println("Primeros 100 elementos de c ordenados: " + Arrays.toString(Arrays.copyOfRange(cCopy, 0, 100)));
        System.out.println("Primeros 100 elementos de d ordenados: " + Arrays.toString(Arrays.copyOfRange(dCopy, 0, 100)));
        System.out.println("Primeros 100 elementos de e ordenados: " + Arrays.toString(Arrays.copyOfRange(eCopy, 0, 100)));
        System.out.println("Primeros 100 elementos de f ordenados: " + Arrays.toString(Arrays.copyOfRange(fCopy, 0, 100)));



    }


}