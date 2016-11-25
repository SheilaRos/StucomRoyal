package com.mycompany.stucomroyal;

public class Tropa extends Cartas{
    private int nivelAtaque;
    public Tropa(int nivelAtaque, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAtaque = nivelAtaque;
    }
    
}
