import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        int[] resultado = new int[N];
        int index = 0;

        for (int i = 1; i <= N / 2; i++) {
            resultado[index++] = i;
            resultado[index++] = -i;
        }

        if (N % 2 != 0) {
            resultado[index] = 0;
        }

        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}