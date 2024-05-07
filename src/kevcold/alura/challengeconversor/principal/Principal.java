package kevcold.alura.challengeconversor.principal;

import kevcold.alura.challengeconversor.modelos.Consumiendo_Exchange;

public class Prueba {
    public static void main(String[] args) {
        Consumiendo_Exchange cop = new Consumiendo_Exchange();

        System.out.println(cop.BuscarMonedas("USD"));
    }
}
