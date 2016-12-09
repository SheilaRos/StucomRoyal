package com.mycompany.stucomroyal;


public abstract class Cartas implements Cloneable{
    private String nombre;
    private int costeElixir;
    private int nivelVida;
    public Cartas(String nombre, int costeElixir, int nivelVida) {
        this.nombre = nombre;
        this.costeElixir = costeElixir;
        this.nivelVida = nivelVida;
    }
    public int getNivelVida() {return nivelVida;}
    public void setNivelVida(int nivelVida) {this.nivelVida = nivelVida;}
    public int getCosteElixir() {return costeElixir;}
    public void setCosteElixir(int costeElixir) {this.costeElixir = costeElixir;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public abstract int accionCarta();
    @Override
    public String toString() {
        return "Cartas{" + "nombre=" + nombre + ", costeElixir=" + costeElixir + ", nivelVida=" + nivelVida + '}';
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
