package com.conversordemonedas.calculos;

import com.conversordemonedas.modelos.CambioExchangeRateAPI;

public class Calculadora {
    public Calculadora() {
    }

    public void calcularConversion(CambioExchangeRateAPI datosDeCambio,Double cantidadIngresada){
        Double resultado = cantidadIngresada * datosDeCambio.conversion_rate();
        System.out.println("Usted convirtio $" + cantidadIngresada
                + " [" + datosDeCambio.base_code() + "]" + "en --> $" + resultado
                + "[" + datosDeCambio.target_code() + "]");
    }
}
