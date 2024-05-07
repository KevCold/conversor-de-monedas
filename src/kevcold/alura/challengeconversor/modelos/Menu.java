package kevcold.alura.challengeconversor.modelos;

import javax.swing.*;

public class Menu {
    public static final String INDICE = """
            *********************************************************************
                       Conversor de Monedas - Primer Challenge Backend
            """;
    public static final String SUB_MENU = """
                        Se bienvenido al este conversor de monedas
                      Presiona (99) para ver el menú de instrucciones
                                 Presiona (0) para salir
            
            ********* 1  - Dólar              >>>>>>>    Peso Colombiano ********
            ********* 2  - Peso Colombiano    >>>>>>>    Dólar           ********
            ********* 3  - Dólar              >>>>>>>    Real Brasileño  ********
            ********* 4  - Real Brasileño     >>>>>>>    Dólar           ********
            ********* 5  - Dólar              >>>>>>>    Euro            ********
            ********* 6  - Euro               >>>>>>>    Dólar           ********
            ********* 7  - Dólar              >>>>>>>    Peso Mexicano   ********
            ********* 8  - Peso Mexicano      >>>>>>>    Dólar            ********
            ********* 9  - Dólar              >>>>>>>    Peso Argentino  ********
            ********* 10 - Peso Argentino     >>>>>>>    Dólar           ********
            """;
    public static final String DESPEDIDA = """
            *********************************************************************
                     Conversor de Monedas - Primer Challenge Backend
                                            Calificame!
            """;
    public static final String INSTRUCCIONES = """
            *********************************************************************
            ******* -  Conversor de Monedas - Primer Challenge Backend  - *******
            ********************** - Instrucciones de uso - *********************
            **** 1 - Elige una moneda para convertir                         ****
            **** 2 - Ingresa un monto a convertir                            ****
            *********************************************************************
            **** 3 - Para salir presiona (0)                                 ****
            *********************************************************************
            """;

    public static void mostrarIndice() {
        JOptionPane.showMessageDialog(null, INDICE);
    }

    public static void mostrarSubMenu() {
        JOptionPane.showMessageDialog(null, SUB_MENU);
    }

    public static void mostrarDespedida() {
        JOptionPane.showMessageDialog(null, DESPEDIDA);
    }

    public static void mostrarInstrucciones() {
        JOptionPane.showMessageDialog(null, INSTRUCCIONES);
    }
}
