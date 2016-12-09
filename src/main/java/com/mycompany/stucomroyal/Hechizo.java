package com.mycompany.stucomroyal;

public class Hechizo extends Cartas{
  private int nivelAlcance;
  private String modo;
    public Hechizo(int nivelAlcance, String modo, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAlcance = nivelAlcance;
        this.modo = modo;
    }
    public int getNivelAlcance() {return nivelAlcance;}
    public void setNivelAlcance(int nivelAlcance) {this.nivelAlcance = nivelAlcance;}
    public String getModo() {return modo;}
    public void setModo(String modo) {this.modo = modo;}
    @Override public int accionCarta() {
        return (nivelAlcance*2)/3;
    }
    @Override
    public String toString() {
        return "Hechizo{" + "nombre=" + this.getNombre() + ", costeElixir=" + this.getCosteElixir() + ", nivelVida=" + this.getNivelVida()  + ", nivelAlcance=" + nivelAlcance + ", modo=" + modo + '}'+"\n";
    }
}
