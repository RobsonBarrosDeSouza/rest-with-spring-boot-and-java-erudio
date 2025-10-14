package br.com.barros.controllers;

import br.com.barros.exception.UnsupportedMathOperationException;
import br.com.barros.math.SimpleMath;
import br.com.barros.request.converters.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private SimpleMath math;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo)throws Exception{
        if(!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) throw  new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
     }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo)throws Exception {
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo))
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo)throws Exception{
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo))
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return math.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number)throws Exception{
        if(!NumberConverter.isNumber(number))throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return math.squareRoot(NumberConverter.convertToDouble(number));

    }
}
