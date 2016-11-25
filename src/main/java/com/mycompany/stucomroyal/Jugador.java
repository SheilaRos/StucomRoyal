package com.mycompany.stucomroyal;

import java.util.ArrayList;

public class Jugador {
    
    private String usuario;
    private String password;
    private int trofeos;
    private ArrayList<Cartas> grupoCartas;

    public Jugador(String usuario, String password, int trofeos, ArrayList<Cartas> grupoCartas) {
        this.usuario = usuario;
        this.password = password;
        this.trofeos = trofeos;
        this.grupoCartas = grupoCartas;
    }

    public ArrayList<Cartas> getGrupoCartas() {
        return grupoCartas;
    }
    public void setGrupoCartas(ArrayList<Cartas> grupoCartas) {
        this.grupoCartas = grupoCartas;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
