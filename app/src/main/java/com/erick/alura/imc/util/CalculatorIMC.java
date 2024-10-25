package com.erick.alura.imc.util;

import static com.erick.alura.imc.enums.StatusIMCEnum.NORMAL_WEIGHT;
import static com.erick.alura.imc.enums.StatusIMCEnum.OVERWEIGHT;
import static com.erick.alura.imc.enums.StatusIMCEnum.UNDERWEIGHT;

import com.erick.alura.imc.models.Person;

public class CalculatorIMC {

    private static Double calculateIMC(Person personCorporeData) {
        return personCorporeData.getCorporeWeight() / (personCorporeData.getCorporeHeight() * personCorporeData.getCorporeHeight());
    }

    static public String getIMCStatus(Person personCorporeData) {
        double imc = calculateIMC(personCorporeData);
        if (imc < 18.5) {
            return UNDERWEIGHT.getDescription();
        } else if (imc < 25) {
            return NORMAL_WEIGHT.getDescription();
        } else {
            return OVERWEIGHT.getDescription();
        }
    }
}
