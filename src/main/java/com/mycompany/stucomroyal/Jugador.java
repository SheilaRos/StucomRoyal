package com.mycompany.stucomroyal;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Comparable<Jugador>{
    private String usuario;
    private String password;
    private int trofeos = 0;
    private List<Cartas> grupoCartas = new ArrayList<>();
    public Jugador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    } 
    public Jugador(String usuario, String password, int trofeos, ArrayList<Cartas> grupoCartas) {
        this(usuario, password);
        this.trofeos = trofeos;
        this.grupoCartas = grupoCartas;
    }
    public List<Cartas> getGrupoCartas() {return grupoCartas;}
    public void setGrupoCartas(List<Cartas> grupoCartas) {this.grupoCartas = grupoCartas;}
    public int getTrofeos() {return trofeos;}
    public void setTrofeos(int trofeos) {this.trofeos = trofeos;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    @Override
    public int compareTo(Jugador o) {
       if (trofeos > o.getTrofeos()) {
           return 1;
       } else if (trofeos < o.getTrofeos()) {
           return -1;
       } else {
           return 0;
       }
    }
}
