package eva3_1_ordenamiento;
public class EVA3_1_ORDENAMIENTO {
    public static void main(String[] args) {
        int [] original = new int[10];
        int[] selection,insertion,bubble,quick;
        long ini,fin,tiempo;
        llenarArreglo(original);
        imprimirArreglo(original);
        selection = copiarArreglo(original);
        System.out.println("***** SELECTION SORT *****");
        ini = System.nanoTime();
        selectionSort(selection);
        fin = System.nanoTime();
        imprimirArreglo(selection);
        tiempo = fin-ini;
        System.out.println("T = " + tiempo);
        // Insertion Sort
        insertion = copiarArreglo(original);
        System.out.println("***** INSERTION SORT *****");
        ini = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();
        imprimirArreglo(insertion);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);
         // Bubble Sort
        bubble = copiarArreglo(original);
        System.out.println("***** BUBBLE SORT *****");
        ini = System.nanoTime();
        bubbleSort(bubble);
        fin = System.nanoTime();
        imprimirArreglo(bubble);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);

        // Quick Sort
        quick = copiarArreglo(original);
        System.out.println("***** QUICK SORT *****");
        ini = System.nanoTime();
        quickSort(quick, 0, quick.length - 1);
        fin = System.nanoTime();
        imprimirArreglo(quick);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);
    }
    public static void llenarArreglo(int[] datos){
        for(int i =0; i< datos.length; i++){
            datos [i] = (int)(Math.random()*10000);
        }
    }
    public static void imprimirArreglo(int[] datos){
        for(int i =0; i< datos.length; i++){
            System.out.print("["+datos[i]+"]");
        }
        System.out.println("");
    }
        public static int[] copiarArreglo(int[] datos){
        int [] nuevo = new int[datos.length];
        for(int i =0; i < datos.length; i++){
            nuevo[i] = datos[i];
        }
        return nuevo;
    }
        public static void selectionSort(int[] datos){
            for (int i = 0; i < datos.length - 1; i++) {
            int min = i; // posición del valor mínimo
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[min]) {
                    min = j; // se encontró un valor menor
                }
            }
            // Intercambio
            int temp = datos[i];
            datos[i] = datos[min];
            datos[min] = temp;
        }
    }
        public static void insertionSort(int[] datos){
            for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];   // valor a insertar
            int j = i - 1;
            // desplazamiento hacia la derecha
            while (j >= 0 && datos[j] > temp) {
                datos[j + 1] = datos[j];
                j--;
            }
            datos[j + 1] = temp;
        }
        }
        public static void bubbleSort(int[] datos){
            for (int i = 0; i < datos.length - 1; i++) {
            for (int j = 0; j < datos.length - 1 - i; j++) {
                if (datos[j] > datos[j + 1]) { // intercambio si está fuera de orden
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                    }
                }
            }
        }
        public static void quickSort(int[] datos, int ini, int fin){
            if (ini < fin) {
            int pivote = particion(datos, ini, fin);
            quickSort(datos, ini, pivote - 1); // Lado izquierdo del pivote
            quickSort(datos, pivote + 1, fin); // Lado derecho del pivote
        }
    }
    public static int particion(int[] datos, int ini, int fin) {
        int pivote = datos[fin]; // pivote al final
        int i = ini - 1;
        for (int j = ini; j < fin; j++) {
            if (datos[j] <= pivote) {
                i++;
                // Intercambio
                int temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
            }
        }
        // Coloca el pivote en su posición final
        int temp = datos[i + 1];
        datos[i + 1] = datos[fin];
        datos[fin] = temp;
        return i + 1; // devuelve el índice del pivote
        }
}