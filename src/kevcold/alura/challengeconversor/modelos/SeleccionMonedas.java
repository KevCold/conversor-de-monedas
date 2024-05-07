package kevcold.alura.challengeconversor.modelos;

import javax.swing.*;

public class SeleccionMonedas {

    public void seleccionar() {
        Menu menu = new Menu(); // Crear una instancia de Menu

        int opcion;
        do {
            Menu.mostrarIndice();
            Menu.mostrarSubMenu();

            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una opción"));

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, Menu.DESPEDIDA);
                    break;
                case 1:
                    convertir("USD", "Dólar", "COP", "Peso Colombiano");
                    break;
                case 2:
                    convertir("COP", "Peso Colombiano", "USD", "Dólar");
                    break;
                case 3:
                    convertir("USD", "Dólar", "BRL", "Real Brasileño");
                    break;
                case 4:
                    convertir("BRL", "Real Brasileño", "USD", "Dólar");
                    break;
                case 5:
                    convertir("USD", "Dólar", "EUR", "Euro");
                    break;
                case 6:
                    convertir("EUR", "Euro", "USD", "Dólar");
                    break;
                case 7:
                    convertir("USD", "Dólar", "MXN", "Peso Mexicano");
                    break;
                case 8:
                    convertir("MXN", "Peso Mexicano", "USD", "Dólar");
                    break;
                case 9:
                    convertir("USD", "Dólar", "ARS", "Peso Argentino");
                    break;
                case 10:
                    convertir("ARS", "Peso Argentino", "USD", "Dólar");
                    break;
                case 99:
                    JOptionPane.showMessageDialog(null, Menu.INSTRUCCIONES);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, """
                            Error, opción no válida. Por favor, selecciona una opción válida.
                            Trabajamos para tener más monedas, selecciona una conversión disponible. 🛠️""");
            }
        } while (opcion != 0);

        System.out.println("Operación finalizada. ¡Hasta luego!");
    }

    // Método para realizar la conversión utilizando la clase CalculadoraExchange
    private void convertir(String codeMonedaActual, String nombreMonedaActual,
                           String codeMonedaAConvertir, String nombreDeMonedaAConvertir) {
        CalculadoraExchange calculadora = new CalculadoraExchange();
        calculadora.calcular(codeMonedaActual, nombreMonedaActual,
                codeMonedaAConvertir, nombreDeMonedaAConvertir);
    }
}
