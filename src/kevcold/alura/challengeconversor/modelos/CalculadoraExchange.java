package kevcold.alura.challengeconversor.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.swing.*;

public class CalculadoraExchange {
    // Gson para manejar la conversión de JSON
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void calcular(String busqueda, String nombreMonedaActual,
                         String monedaAConvertir, String nombreDeMonedaAConvertir) {
        // Mensaje de confirmación de selección
        String mensaje = "Su selección fue convertir: ";
        String valorIngresado;

        // Consumir la API para obtener los datos de conversión
        Consumiendo_Exchange consumiendo = new Consumiendo_Exchange();
        String datos = gson.toJson(consumiendo.BuscarMonedas(busqueda));

        // Convertir el JSON a un objeto JsonObject
        JsonObject objetoJson = gson.fromJson(datos, JsonObject.class);

        // Obtener la moneda actual y las tasas de conversión
        String monedaActual = objetoJson.get("base_code").getAsString();
        JsonObject conversionRates = objetoJson.getAsJsonObject("conversion_rates");
        double valorDeMonedaAConvertir = conversionRates.get(monedaAConvertir).getAsDouble();

        // Mostrar un mensaje con la selección del usuario usando JOptionPane
        JOptionPane.showMessageDialog(null, mensaje +
                nombreMonedaActual + " >>>>>>>>>> " + nombreDeMonedaAConvertir);

        // Solicitar al usuario el valor a convertir utilizando JOptionPane
        valorIngresado = JOptionPane.showInputDialog("Ingresa el valor de " +
                monedaActual + " a convertir");
        valorIngresado = valorIngresado.replace(".", ",");
        Double valorIngresadoADouble = Double.parseDouble(valorIngresado);

        // Mostrar una barra de carga simulada con JOptionPane
        BarraDeCargaOptionPane barraDeCarga = new BarraDeCargaOptionPane();
        barraDeCarga.mostrarBarraDeCarga("Calculando...", 2000); // 2 segundos de duración

        // Simular una pausa de 2 segundos para representar el cálculo de conversión
        try {
            Thread.sleep(2000); // Simular una pausa de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Realizar la conversión y mostrar el resultado utilizando JOptionPane
        if (valorIngresadoADouble <= 0) {
            // Si el valor ingresado es menor o igual a cero, solicitar otro valor al usuario
            JOptionPane.showMessageDialog(null,
                    "!Ingresa una cantidad mayor!");
            valorIngresadoADouble = Double.parseDouble(JOptionPane
                    .showInputDialog("Por favor ingresa un valor mayor"));
        } else if (valorIngresadoADouble >= 1) {
            // Calcular el valor convertido y mostrar el resultado
            double calcularValor = valorIngresadoADouble * valorDeMonedaAConvertir;
            String calcularValorDosDecimal = String.format("%.2f", calcularValor);

            // Determinar la forma plural adecuada del nombre de la moneda según el valor ingresado
            String nombreMonedaPlural = nombreMonedaActual + (valorIngresadoADouble == 1 ? "" : "s");
            String nombreDeMonedaPlural = nombreDeMonedaAConvertir + (calcularValor == 1 ? "" : "s");

            // Mostrar el resultado de la conversión utilizando JOptionPane
            JOptionPane.showMessageDialog(null, "$" + valorIngresadoADouble
                    + " " + nombreMonedaPlural + " equivalen a >>>> "
                    + calcularValorDosDecimal + " " + nombreDeMonedaPlural);
        }
    }
}
