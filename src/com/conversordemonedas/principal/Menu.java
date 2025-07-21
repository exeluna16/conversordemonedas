package com.conversordemonedas.principal;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public Menu() throws IOException,InterruptedException {
        int opcion = -1;
        boolean salida = false;
        Scanner teclado = new Scanner(System.in);
        String direccion = "https://v6.exchangerate-api.com/v6/e90e26a02d3beee817ad7f89/pair";
        String url = "";
        Double cantidadIngresada = 0.0;
        Conversion conver = new Conversion();
        while(!salida){
            this.mostrarOpciones();
            System.out.println("Ingrese una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad a convertir");
                    cantidadIngresada = teclado.nextDouble();
                    url = direccion.concat("/ARS/USD");
                    conver.convertir(url,cantidadIngresada);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a convertir");
                    cantidadIngresada = teclado.nextDouble();
                    url = direccion.concat("/USD/ARS");
                    conver.convertir(url,cantidadIngresada);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a convertir");
                    cantidadIngresada = teclado.nextDouble();
                    url = direccion.concat("/USD/BRL");
                    conver.convertir(url,cantidadIngresada);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad a convertir");
                    cantidadIngresada = teclado.nextDouble();
                    url = direccion.concat("/BRL/USD");
                    conver.convertir(url,cantidadIngresada);
                    break;
                case 0:
                    salida = true;
                    break;
                default:
                    System.out.println("por favor ingrese una opcion valida");
            }
        }
        System.out.println("--FIN--");
    }

    public void mostrarOpciones(){
        System.out.println("***********************************\n" +
                "1) PESO ARGENTINO -> DOLAR\n" +
                "2) DOLAR -> PESO ARGENTINO\n" +
                "3) DOLAR -> REAL BRASILEÑO\n" +
                "4) REAL BRASILEÑO -> DOLAR\n" +
                "0) Salir\n"+
                "***********************************\n");
    }
}
