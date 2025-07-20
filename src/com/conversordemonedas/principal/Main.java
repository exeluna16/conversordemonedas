package com.conversordemonedas.principal;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/e90e26a02d3beee817ad7f89/latest/USD";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> respuesta = cliente
                .send(peticion, HttpResponse.BodyHandlers.ofString());


        System.out.println(respuesta.body());
    }
}