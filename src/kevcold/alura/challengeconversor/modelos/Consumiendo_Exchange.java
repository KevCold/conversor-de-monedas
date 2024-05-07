package kevcold.alura.challengeconversor.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api_Exchange {
    private static final String EXCH_RATE = "98d891f2d6d037ae614ded1e";

    public String BuscarValorDolar() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + EXCH_RATE + "/latest/USD");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response =client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}
