import java.util.*;

public class Main1 {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            numeros.add(Integer.parseInt(args[i]));
        }

        int maior = numeros.get(0); 

        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) > maior) {
                maior = numeros.get(i);
            }
        }

        System.out.println("O maior valor é: " + maior);
    }
}