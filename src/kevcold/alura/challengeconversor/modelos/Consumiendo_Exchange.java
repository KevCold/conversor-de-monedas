package kevcold.alura.challengeconversor.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consumiendo_Exchange {
    private static final String EXCH_KEY = "98d891f2d6d037ae614ded1e";
    private static final String URL = "https://v6.exchangerate-api.com/v6/" + EXCH_KEY + "/latest/";

    public Monedas BuscarMonedas(String busqueda) {
        URI direccion = URI.create(URL + busqueda);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}
