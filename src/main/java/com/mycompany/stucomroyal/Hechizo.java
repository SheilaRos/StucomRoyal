package com.mycompany.stucomroyal;

public class Hechizo extends Cartas{
  private int nivelAlcance;
  private String modo;

    public Hechizo(int nivelAlcance, String modo, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAlcance = nivelAlcance;
        this.modo = modo;
    }
  
}
