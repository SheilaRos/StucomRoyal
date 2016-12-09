package com.mycompany.stucomroyal;

public class Estructura extends Cartas{
    private int nivelDefensa;
    public Estructura(int nivelDefensa, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelDefensa = nivelDefensa;
    }
    public int getNivelDefensa() {return nivelDefensa;}
    public void setNivelDefensa(int nivelDefensa) {this.nivelDefensa = nivelDefensa;}
    @Override public int accionCarta() {
        return nivelDefensa+8;
    }

    @Override
    public String toString() {
        return "Estructura{" + "nombre=" + this.getNombre() + ", costeElixir=" + this.getCosteElixir() + ", nivelVida=" + this.getNivelVida()  + ", nivelDefensa=" + nivelDefensa + '}'+"\n";
    }
}
