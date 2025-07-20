package com.conversordemonedas.principal;

import com.conversordemonedas.calculos.Calculadora;
import com.conversordemonedas.modelos.CambioExchangeRateAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Menu {
    public int opcion;

    public Menu() throws IOException,InterruptedException {
        Calculadora calculadora = new Calculadora();
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("OPCIONES");
        System.out.println("Ingrese una opcion: ");
        //opcion = teclado.nextInt();
        String direccion = "https://v6.exchangerate-api.com/v6/e90e26a02d3beee817ad7f89/pair/ARS/USD";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> respuesta = cliente
                .send(peticion, HttpResponse.BodyHandlers.ofString());

        String json = respuesta.body();
        Gson gson = new Gson();

        CambioExchangeRateAPI datosDeCambio = gson.fromJson(json,CambioExchangeRateAPI.class);

        calculadora.calcularConversion(datosDeCambio,200.0);

        //System.out.println(datosDeCambio);
    }
}
