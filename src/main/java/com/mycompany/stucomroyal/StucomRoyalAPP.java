package com.mycompany.stucomroyal;

public class StucomRoyalAPP {
    public static void main(String[] args) {
        
        int opcion=0;
		 do{
                    menu();
                    opcion= EntradaDatos.pedirEntero("Escoge una opción");
                    switch(opcion){
			case 1:
                            
			break;
			case 2:
                            
			break;
			case 3:
                            
			break;
                        case 4:
                            System.out.println("Hasta luego! ^");
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
}
