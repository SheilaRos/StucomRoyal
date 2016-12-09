package com.mycompany.stucomroyal;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StucomRoyalAPP {
    public static List<Jugador> jugador = new ArrayList<>();
    public static List<Cartas> cartas = new ArrayList<>();
    
    public static void main(String[] args) {  
        jugador.add(new Jugador("bimu", "123"));
        jugador.add(new Jugador("yuna", "123"));
        jugador.add(new Jugador("jugador123", "123"));
        jugador.add(new Jugador("error404", "123"));
        
        cartas.add(new Tropa(20, "Supertropa", 2, 50));
        cartas.add(new Tropa(18, "Casi 300", 3, 45));
        cartas.add(new Tropa(18, "300", 4, 65));
        
        cartas.add(new Estructura(10, "Muro de Mexico", 4, 60));
        cartas.add(new Estructura(8, "Muro de Berlin", 1, 40));
        cartas.add(new Estructura(9, "La muralla China", 3, 65));
        
        cartas.add(new Hechizo(5,"ataque" , "Supernova", 2, 15));
        cartas.add(new Hechizo(7, "defensa", "Superescudo", 3, 10));
        cartas.add(new Hechizo(6, "ataque","Agujero negro", 1, 13));
            
        int opcion=0;
		 do{
                    menu();
                    opcion= EntradaDatos.pedirEntero("Escoge una opción");
                    switch(opcion){
			case 1:
                            conseguirCartas();
			break;
			case 2:
                            batalla();
			break;
			case 3:
                            ranking();
			break;
                        case 4:
                            System.out.println("Hasta luego! ^^");
			break;
			default: System.out.println("opción incorrecta.");
                    }
		 }while(opcion!=4);
    }
    public static void menu(){
        System.out.println("<~~ Menú ~~>");
        System.out.println("[1]~ Conseguir cartas.");
        System.out.println("[2]~ Batalla.");
        System.out.println("[3]~ Ranking.");
        System.out.println("[4]~ Salir.");
    }
    public static String pedirCadenaNoVacia(String msg){
        String cadena;
	do{
            cadena=EntradaDatos.pedirCadena(msg);
            if(cadena.equals("")){
                System.out.println("No se puede dejar en blanco");
            }
	}while(cadena.equals(""));
	return cadena;
    }
    public static Jugador validar(){
        String usuario = pedirCadenaNoVacia("Introduce el usuario:");
        String pass = pedirCadenaNoVacia("Introduce la contraseña:");
        Jugador validar = null;
        for(Jugador j : jugador){
            if(j.getUsuario().equals(usuario) && j.getPassword().equals(pass)){
               validar = j;
            }
        }
        return validar;
    }
    public static void conseguirCartas(){
        //Valido y me traigo el jugador
        Jugador j = validar();
        boolean salir = false;
        //Si el jugador se ha introducido mal, nos avisa y devuelve al menú
        if(j == null){
            System.out.println("El usuario o contraseña introducidos no son validos.");
        }else{//comprueba que tenga menos de 6 cartas
           if(j.getGrupoCartas().size()<6){
            while(!salir){
                //muestra todas las cartas posibles y pide el nombre de la carta que quiere añadir
               mostrarCartas(cartas);
               String nombreCarta = pedirCadenaNoVacia("Introduce el nombre de la carta que quieres incluir en tus cartas:");
               boolean comprobarCarta = comprobarCarta(j.getGrupoCartas(), nombreCarta);
               boolean comprobarExisteCarta = comprobarCarta(cartas, nombreCarta);
               if(!comprobarCarta && comprobarExisteCarta){
                Cartas c = obtenerCarta(nombreCarta);
                j.getGrupoCartas().add(c);
                System.out.println("Carta añadida con exito.");
                salir = true;
               }else{ 
                  System.out.println("Ya tienes está carta.");
                }
            }
           }else{ //si tiene más de 6 cartas
               System.out.print("Ya tienes el máximo de cartas.");
               System.out.print(j.getGrupoCartas());
           }
        }
    }
    public static Cartas obtenerCarta(String carta2){
            for(Cartas c : cartas){
                if(c.getNombre().equalsIgnoreCase(carta2) ){
                return c;
                }
            }
        return null;
    }
    public static boolean comprobarCarta(List<Cartas> lista, String carta2){
        boolean laTiene=false;
        for(Cartas carta1 : lista){
            if(carta1.getNombre().equalsIgnoreCase(carta2)){
               return true;
            }
        }
        return laTiene;
    }
    public static void mostrarCartas(List<Cartas> cartas){
        for(Cartas c: cartas){
            System.out.println(c);
        }
    }
    public static void batalla(){
        List<Cartas> cartasJ1 = new ArrayList<>();
        List<Cartas> cartasJ2 = new ArrayList<>();
        Jugador j1 = validar();
        Jugador j2 = validar();
        if(j1 == j2){
            System.out.println("Se ha validado dos veces el mismo jugador.");
        }else{
            cartasJ1 = elegirCartas(j1, j1.getGrupoCartas());
            cartasJ2 = elegirCartas(j2, j2.getGrupoCartas());
            if(cartasJ1.size()>0 && cartasJ2.size()>0){
            System.out.println("Cartas para la batalla de "+j1.getUsuario()+":");
            System.out.println(cartasJ1);
            System.out.println("Cartas para la batalla de "+j2.getUsuario()+":");
            System.out.println(cartasJ2);
            accionCartas(cartasJ1, cartasJ2, j1.getUsuario(), j2.getUsuario());
            ganador(cartasJ1, cartasJ2, j1, j2);
            }
        }
    }
    public static void accionCartas(List<Cartas> cartas1, List<Cartas> cartas2, String nombre1, String nombre2){
        int random = (int)(Math.random()*2);
        if(random == 0){
            System.out.println("Comienza "+nombre1);
            ataca(cartas1, cartas2);
            ataca(cartas2, cartas1);
        }else{
            System.out.println("Comienza "+nombre2);
            ataca(cartas2, cartas1);
            ataca(cartas1, cartas2);
        }  
    }
    public static void ataca(List<Cartas> cartas1, List<Cartas> cartas2){
         for(int i=0; i<3; i++){
                if(cartas1.get(i).getClass()== Tropa.class){
                    Tropa cartaT = (Tropa) cartas1.get(i);
                    int damage = cartaT.accionCarta();
                    damage = cartas2.get(i).getNivelVida() - damage;
                    cartas2.get(i).setNivelVida(damage);
                }else if(cartas1.get(i).getClass()== Hechizo.class){
                   Hechizo cartaH = (Hechizo) cartas1.get(i);
                   if(cartaH.getModo().equals("ataque")){
                       cartas2.get(i).setNivelVida(cartas2.get(i).getNivelVida() - cartaH.accionCarta());
                   }else{
                       cartas1.get(i).setNivelVida(cartaH.getNivelVida() + cartaH.accionCarta());
                   }
                }else if(cartas1.get(i).getClass()== Estructura.class){
                   Estructura cartaE = (Estructura) cartas1.get(i);
                   cartas1.get(i).setNivelVida(cartaE.getNivelVida() + cartaE.accionCarta());
                }
            }
    }
    public static void ganador(List<Cartas> cartas1, List<Cartas> cartas2, Jugador j1, Jugador j2){
        int vidaJ1 = 0;
        int vidaJ2 = 0;
        for(int i = 0; i<3; i++){
            vidaJ1 += cartas1.get(i).getNivelVida();
            vidaJ2 += cartas2.get(i).getNivelVida();
        }
        if(vidaJ1>vidaJ2){
            j1.setTrofeos(j1.getTrofeos()+5);
            System.out.println(j1.getUsuario()+" has ganado con una vida de "+vidaJ1+" a "+j2.getUsuario()+" con una vida de "+vidaJ2);
        }else if(vidaJ2>vidaJ1){
            j2.setTrofeos(j2.getTrofeos()+5);
            System.out.println(j2.getUsuario()+" has ganado con una vida de "+vidaJ2+" a "+j1.getUsuario()+" con una vida de "+vidaJ1);
        }else{
            System.out.println(j1.getUsuario()+" has empatado a "+j2.getUsuario()+" con una vida de "+vidaJ1);
        }
    }
    public static boolean comprobarCosteElixir(List<Cartas> cartasJugador, Cartas cartita){
        int elixir  = cartita.getCosteElixir();
        for(Cartas card : cartasJugador){
            elixir += card.getCosteElixir();
        }
        if(elixir>10){
            return true;
        }else{
        return false;
        }
    }
    public static boolean comprobarCosteElixir(List<Cartas> cartasJugador){
        int elixir=0;
        for(Cartas card : cartasJugador){
            elixir += card.getCosteElixir();
        }
        if(elixir>10){
            return true;
        }else{
        return false;
        }
    }
    public static List<Cartas> elegirCartas(Jugador j, List<Cartas> cartasJ){
        //creo una lista para las cartas clonadas y un contador para el número máximo de cartas que puede seleccionar
        List<Cartas> cartaCopias = new ArrayList<>();
        int contador = 1;
        if(comprobarCosteElixir(cartasJ) && cartasJ.size()<=3){
            System.out.println("No se puede acceder a la batalla porque el jugador tiene 3 o menos cartas y la suma de los elixires supera 10");
        }else{
        System.out.println(j.getUsuario()+" elige 3 cartas,en el orden que quieras usarlas, no puede superar 10 de elixir:");
        while(contador<4){
           boolean salir=false;
           do{ //enseño las cartas del jugador
            System.out.println(j.getGrupoCartas());
            //Le digo que seleccione la carta por el nombre que tiene y compruebo que no la haya seleccionado ya
            String nombre = pedirCadenaNoVacia("Selecciona el nombre de la "+contador+" carta que quieres elegir:");
            boolean comprobarQueLaCartaEsteEnSuLista = comprobarCarta(j.getGrupoCartas(), nombre); 
            boolean comprobarSiYaLaHaSeleccionado = comprobarCarta(cartaCopias, nombre);
            if(comprobarQueLaCartaEsteEnSuLista && !comprobarSiYaLaHaSeleccionado){
                Cartas cartita = obtenerCarta(nombre);
                 boolean elixir = comprobarCosteElixir(cartaCopias, cartita);
                if(!elixir){
                    try{
                    Cartas copia = (Cartas) cartita.clone();
                    cartaCopias.add(copia);
                    contador++;
                    salir=true;
                    } catch (CloneNotSupportedException ex) {  
                    } 
                }else{
                    System.out.println("Superas el coste de elixir, el máximo es 10.");
                }
            }else{
                System.out.println("La carta seleccionada no está en tu mazo o ya la has seleccionado.");
            }
           }while(!salir);
        }
       }
        return cartaCopias;
    }
    public static void ranking(){
//        int max = 0;
          int num = 1;
//        for para conseguir el número de trofeos maximo
//        for(Jugador j : jugador){
//            if(j.getTrofeos()>max){
//                max=j.getTrofeos();
//            }
//        }
        Collections.sort(jugador);
        System.out.println("<~~ Ranking ~~>");
        //for para imprimir el ranking
        for(Jugador j: jugador){
                System.out.println("");
                System.out.println(num+" - "+ j.getUsuario()+", trofeos: "+j.getTrofeos());
                num++;
        }
    }
}
