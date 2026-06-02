package models;

public class Resultado {

    private String algoritmo;
    private String escenario;
    private int sample;
    private double tiempoNano;
    private double tiempoMillis;

    public Resultado(String algoritmo,String escenario,int sample,double tiempoNano) {

        this.algoritmo = algoritmo;
        this.escenario = escenario;
        this.sample = sample;
        this.tiempoNano = tiempoNano;
        this.tiempoMillis = tiempoNano / 1_000_000.0;
    }

    @Override
    public String toString() {
        return escenario + " | "
                + algoritmo + " | "
                + sample + " | "
                + tiempoMillis + " ms";
    }
}