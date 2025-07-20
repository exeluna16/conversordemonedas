package com.conversordemonedas.modelos;

/* --DATOS--
String base_code -> moneda base
String target_code -> moneda que quiero obtener
Double conversion_rate -> ratio de conversion
*/
public record CambioExchangeRateAPI(String base_code,
                     String target_code,
                     Double conversion_rate) {

}
