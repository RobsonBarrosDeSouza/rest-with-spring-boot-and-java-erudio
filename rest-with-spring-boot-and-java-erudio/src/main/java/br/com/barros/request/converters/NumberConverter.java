package br.com.barros.request.converters;

import br.com.barros.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class NumberConverter {

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumber(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
