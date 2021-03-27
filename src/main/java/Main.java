import com.johanastrom.Calculator;
import com.johanastrom.StringUtilities;
import com.johanastrom.WebUtilities;

/**
 * Johan Åström 26/3 2021
 */

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        double result = calc.evaluate("3-1*2/8+5*10");
        System.out.println(result);
    }
}
