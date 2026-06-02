package controllers;

import models.Persona;
// metodo de ordenamiento insercion
public class SortPersonaMethods{
    public void insertionSort(Persona[] personas){
        for(int i = 1; i < personas.length; i ++){
            Persona actual = personas[i];
            int j = i - 1;
            while(j >= 0 && personas[j].getCriteriosDeOrdenamiento()> actual.getCriteriosDeOrdenamiento()){
                personas[j + 1] = personas [j];
                j -- ;
            }
            personas [ j + 1] = actual;

        }
    }
    // metodo quick sort:
    public void quickSort(Persona[] personas, int inicio, int fin){
        if(inicio < fin){
            int pivote = particionar(personas, inicio, fin);
            quickSort(personas, inicio, pivote -1);
            quickSort(personas, pivote + 1 , fin);
        }
    }
    private int particionar(Persona[] personas, int inicio,int fin){

        Persona pivote = personas[fin];

        int i = inicio - 1;
        for (int j = inicio; j < fin; j ++){
            if(personas[j].getCriteriosDeOrdenamiento() <= pivote.getCriteriosDeOrdenamiento()){

                i ++;
                intercambiar(personas, i , j);
            }
        }
        intercambiar(personas, i + 1, fin);
        return i + 1;
    }
    private void  intercambiar(Persona[] personas, int i , int j){
        Persona aux = personas[i];
        personas[i] = personas [j];
        personas[j] = aux;
    }
}