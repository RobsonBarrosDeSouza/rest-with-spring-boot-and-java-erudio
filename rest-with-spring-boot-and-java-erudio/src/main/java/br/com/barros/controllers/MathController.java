package br.com.barros.controllers;

import br.com.barros.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return convertToDouble(numberOne)  + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo)throws Exception{
        if(!isNumber(numberOne) || !isNumber(numberTwo)) throw  new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
     }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo)throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo))
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @PostMapping("/average")
    public Double average(@RequestBody List<Integer> numbers){
        Double average = calculateAverage(numbers);
        return average;
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number)throws Exception{
        if(!isNumber(number))throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
      return  convertSquareRoot(number);

    }

    private Double convertSquareRoot(String number) {
        if(convertToDouble(number) < 0.0) throw new UnsupportedMathOperationException("não é possivel calcular Raiz quadrada de um numero negativo!");
        return Math.sqrt(convertToDouble(number));
    }

    private Double calculateAverage(List<Integer> numbers) {
       if(numbers == null || numbers.isEmpty()){
           return 0.0;
       }
       OptionalDouble mediaOptional = numbers.stream()
               .mapToDouble(Integer::doubleValue)
               .average();
       return mediaOptional.orElse(0.0);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Por favor, adicione um valor numerico!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumber(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
