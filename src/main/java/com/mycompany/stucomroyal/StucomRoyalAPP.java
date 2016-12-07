package com.mycompany.stucomroyal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StucomRoyalAPP {
    public static void main(String[] args) {
        List<Jugador> jugador = new ArrayList<>();
        jugador.add(new Jugador("Bimu", "123456"));
        jugador.add(new Jugador("Yuna", "123456"));
        jugador.add(new Jugador("Jugador123", "123456"));
        jugador.add(new Jugador("Error404", "123456"));
        
        List<Cartas> cartas = new ArrayList<>();
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
                            conseguirCartas(jugador, cartas);
			break;
			case 2:
                            
			break;
			case 3:
                            ranking(jugador);
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
    public static Jugador validar(List<Jugador> jugador){
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
    public static void conseguirCartas(List<Jugador> jugador, List<Cartas> cartas){
        Jugador j = validar(jugador);
        boolean salir = false;
        if(j == null){
            System.out.println("El usuario o contraseña introducidos no son validos.");
        }else{
           if(j.getGrupoCartas().size()<6){
            while(!salir){
               mostrarCartas(cartas);
               String nombreCarta = pedirCadenaNoVacia("Introduce el nombre de la carta que quieres incluir en tus cartas:");
                for(Cartas c : j.getGrupoCartas()){
                    if(c.getNombre().equalsIgnoreCase(nombreCarta)){
                        System.out.println("Ya tienes está carta.");
                    }else{
                        j.getGrupoCartas().add(c);
                        System.out.println("Carta añadida con exito.");
                        salir = true;
                    }
                }
            }
           }else{
               System.out.print("Ya tienes el máximo de cartas.");
               System.out.print(j.getGrupoCartas());
           }
        }
    }
    public static void mostrarCartas(List<Cartas> cartas){
        for(Cartas c: cartas){
            System.out.println(c);
        }
    }
    public static void batalla(List<Jugador> jugador){
        Jugador j1 = validar(jugador);
        Jugador j2 = validar(jugador);
        if(j1 == j2){
            System.out.println("Se ha validado dos veces el mismo jugador.");
        }else{
            
            
            
        }
    }
    public static List<Cartas> elegirCartas(Jugador j, List<Cartas> cartasJ){
        List<Cartas> carta = new ArrayList<>();
        int contador = 1;
        System.out.println(j.getUsuario()+" elige 3 cartas:");
        while(contador<4){
            System.out.println(j.getGrupoCartas());
            String nombre = pedirCadenaNoVacia("Selecciona el nombre de la "+contador+" carta que quieres elegir:");
            //Falta pasar el comprobar si la carta es la misma o no en conseguir carta(pasarlo a un metodo) y aqui
            for(Cartas c: carta){
                if(!c.getNombre().equalsIgnoreCase(nombre)){
                    
                }
            }
            
        }
        
        return carta;
    }
    public static void ranking(List<Jugador> jugador){
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
