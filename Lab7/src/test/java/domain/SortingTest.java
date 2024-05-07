package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortingTest {

    @Test
    void elementaryTest() {
        //6 arreglos con 20,000 valores enteros positivos
        int[] a = new int[20000];
        int[] b = new int[20000];
        int[] c = new int[20000];
        int[] d = new int[20000];
        int[] e = new int[20000];
        int[] f = new int[20000];

        for (int i = 0; i < 20000; i++) {
            a[i] = (int) (Math.random() * 999) + 1; //Rango entre 1 y 999
            b[i] = (int) (Math.random() * 999) + 1;
            c[i] = (int) (Math.random() * 999) + 1;
            d[i] = (int) (Math.random() * 999) + 1;
            e[i] = (int) (Math.random() * 999) + 1;
            f[i] = (int) (Math.random() * 999) + 1;
        }

        //Muestra el contenido de los primeros 500 elementos de cada arreglo por consola
        System.out.println("\nPrimeros 500 elementos de a: " + Arrays.toString(Arrays.copyOfRange(a, 0, 500)));
        System.out.println("Primeros 500 elementos de b: " + Arrays.toString(Arrays.copyOfRange(b, 0, 500)));
        System.out.println("Primeros 500 elementos de c: " + Arrays.toString(Arrays.copyOfRange(c, 0, 500)));
        System.out.println("Primeros 500 elementos de d: " + Arrays.toString(Arrays.copyOfRange(d, 0, 500)));
        System.out.println("Primeros 500 elementos de e: " + Arrays.toString(Arrays.copyOfRange(e, 0, 500)));
        System.out.println("Primeros 500 elementos de f: " + Arrays.toString(Arrays.copyOfRange(f, 0, 500)));

        Elementary elementary = new Elementary();


        //Ordena los arreglos utilizando diferentes algoritmos de ordenamiento
        if (!isSorted(a)) {
            elementary.improvedBubbleSort(a);
        }
        if (!isSorted(b)) {
            elementary.bubbleSort(b);
        }
        if (!isSorted(c)) {
            elementary.selectionSort(c);
        }
        if (!isSorted(d)) {
            elementary.improvedBubbleSort(d);
        }
        if (!isSorted(e) || !isSorted(f)) {
            elementary.selectionSort(e);
            elementary.selectionSort(f);
        }

        //Muestra el contenido de los primeros 500 elementos de cada arreglo ya ordenado
        System.out.println("\nPrimeros 500 elementos de a ordenados: " + Arrays.toString(Arrays.copyOfRange(a, 0, 500)));
        System.out.println("Primeros 500 elementos de b ordenados: " + Arrays.toString(Arrays.copyOfRange(b, 0, 500)));
        System.out.println("Primeros 500 elementos de c ordenados: " + Arrays.toString(Arrays.copyOfRange(c, 0, 500)));
        System.out.println("Primeros 500 elementos de d ordenados: " + Arrays.toString(Arrays.copyOfRange(d, 0, 500)));
        System.out.println("Primeros 500 elementos de e ordenados: " + Arrays.toString(Arrays.copyOfRange(e, 0, 500)));
        System.out.println("Primeros 500 elementos de f ordenados: " + Arrays.toString(Arrays.copyOfRange(f, 0, 500)));
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
            a[i] = (int) (Math.random() * 999) + 1; //Rango entre 1 y 99999
            b[i] = (int) (Math.random() * 999) + 1;
            c[i] = (int) (Math.random() * 999) + 1;
            d[i] = (int) (Math.random() * 999) + 1;
            e[i] = (int) (Math.random() * 999) + 1;
            f[i] = (int) (Math.random() * 999) + 1;
        }


        //Muestra el contenido de los primeros 200 elementos de cada arreglo por consola
        System.out.println("Primeros 200 elementos de a: " + Arrays.toString(Arrays.copyOfRange(a, 0, 200)));
        System.out.println("Primeros 200 elementos de b: " + Arrays.toString(Arrays.copyOfRange(b, 0, 200)));
        System.out.println("Primeros 200 elementos de c: " + Arrays.toString(Arrays.copyOfRange(c, 0, 200)));
        System.out.println("Primeros 200 elementos de d: " + Arrays.toString(Arrays.copyOfRange(d, 0, 200)));
        System.out.println("Primeros 200 elementos de e: " + Arrays.toString(Arrays.copyOfRange(e, 0, 200)));
        System.out.println("Primeros 200 elementos de f: " + Arrays.toString(Arrays.copyOfRange(f, 0, 200)));



        Complex complex = new Complex();

        //Ordena los arreglos utilizando diferentes algoritmos de ordenamiento
        complex.quickSort(a, 0, a.length - 1);
        complex.shellSort(b);
        complex.mergeSort(c, new int[c.length], 0, c.length - 1);
        complex.shellSort(d);
        complex.radixSort(e, e.length);
        complex.mergeSort(f, new int[f.length], 0, f.length - 1);

        //Muestra el contenido de cada arreglo ya ordenado (los primeros 100 elementos)
        System.out.println("\nPrimeros 100 elementos de a ordenados: " + Arrays.toString(Arrays.copyOfRange(a, 0, 100)));
        System.out.println("Primeros 100 elementos de b ordenados: " + Arrays.toString(Arrays.copyOfRange(b, 0, 100)));
        System.out.println("Primeros 100 elementos de c ordenados: " + Arrays.toString(Arrays.copyOfRange(c, 0, 100)));
        System.out.println("Primeros 100 elementos de d ordenados: " + Arrays.toString(Arrays.copyOfRange(d, 0, 100)));
        System.out.println("Primeros 100 elementos de e ordenados: " + Arrays.toString(Arrays.copyOfRange(e, 0, 100)));
        System.out.println("Primeros 100 elementos de f ordenados: " + Arrays.toString(Arrays.copyOfRange(f, 0, 100)));



    }


}