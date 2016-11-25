package com.mycompany.stucomroyal;

public class Estructura extends Cartas{
    private int nivelDefensa;
    
    public Estructura(int nivelDefensa, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelDefensa = nivelDefensa;
    }
    
}
