import controllers.SortPersonaMethods;
import models.Persona;
import models.Resultado;
import utils.BenchMarking;

public class App {
    public static Persona[] generarPersonas(int cantidad) {
        Persona[] personas = new Persona[cantidad];

        for (int i = 0; i < cantidad; i++) {

            String nombre = "Persona " + (i + 1);
            int edad = (int) (Math.random() * 101);

            personas[i] = new Persona(nombre, edad);
        }

        return personas;
    }

    public static void main(String[] args) {

        SortPersonaMethods sorter = new SortPersonaMethods();

        int[] muestras = {10000, 50000, 100000};

        System.out.println("================================");
        System.out.println("ESCENARIO 1: ARREGLO DESORDENADO");
        System.out.println("================================");

        for (int size : muestras) {

            Persona[] base = generarPersonas(size);

            Persona[] copiaInsercion = base.clone();
            Persona[] copiaQuick = base.clone();

            Resultado insercion = BenchMarking.medirTiempo(
                    () -> {
                        sorter.insertionSort(copiaInsercion);
                        return null;
                    },
                    "Insercion",
                    "Desordenado",
                    size);

            Resultado quick = BenchMarking.medirTiempo(
                    () -> {
                        sorter.quickSort(
                                copiaQuick,
                                0,
                                copiaQuick.length - 1);
                        return null;
                    },
                    "QuickSort",
                    "Desordenado",
                    size);
            System.out.println("Procesando muestra: " + size);
            System.out.println(insercion);
            System.out.println(quick);
            System.out.println();
        }

        System.out.println("=========================================");
        System.out.println("ESCENARIO 2: ORDENADO + NUEVA PERSONA");
        System.out.println("=========================================");

        for (int size : muestras) {

            Persona[] base = generarPersonas(size);

            sorter.quickSort(base, 0, base.length - 1);

            Persona[] nuevo = new Persona[base.length + 1];

            for (int i = 0; i < base.length; i++) {
                nuevo[i] = base[i];
            }

            nuevo[nuevo.length - 1] =
                    new Persona("Nueva Persona", 50);

            Persona[] copiaInsercion = nuevo.clone();
            Persona[] copiaQuick = nuevo.clone();

            Resultado insercion = BenchMarking.medirTiempo(
                    () -> {
                        sorter.insertionSort(copiaInsercion);
                        return null;
                    },
                    "Insercion",
                    "Casi ordenado + 1 persona",
                    nuevo.length);

            Resultado quick = BenchMarking.medirTiempo(
                    () -> {
                        sorter.quickSort(
                                copiaQuick,
                                0,
                                copiaQuick.length - 1);
                        return null;
                    },
                    "QuickSort",
                    "Casi ordenado + 1 persona",
                    nuevo.length);

            System.out.println(insercion);
            System.out.println(quick);
            System.out.println();
        }
    }
}