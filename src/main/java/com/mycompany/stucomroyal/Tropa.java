package com.mycompany.stucomroyal;

public class Tropa extends Cartas{
    private int nivelAtaque;
    public Tropa(int nivelAtaque, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAtaque = nivelAtaque;
    }
    public int getNivelAtaque() {return nivelAtaque;}
    public void setNivelAtaque(int nivelAtaque) {this.nivelAtaque = nivelAtaque;}
    @Override public int accionCarta() {
       return nivelAtaque/2;
    }
    @Override
    public String toString() {
        return "Tropa{" + "nombre=" + this.getNombre() + ", costeElixir=" + this.getCosteElixir() + ", nivelVida=" + this.getNivelVida()  + ", nivelAtaque=" + nivelAtaque + '}'+"\n";
    }
}
