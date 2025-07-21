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

public class Conversion {
    public Conversion() {

    }

    public void convertir(String url,Double cantidadIngresada)throws IOException, InterruptedException{
        Calculadora calculadora = new Calculadora();

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> respuesta = cliente
                .send(peticion, HttpResponse.BodyHandlers.ofString());

        String json = respuesta.body();
        Gson gson = new Gson();

        CambioExchangeRateAPI datosDeCambio = gson.fromJson(json, CambioExchangeRateAPI.class);

        calculadora.calcularConversion(datosDeCambio, cantidadIngresada);
    }
}
