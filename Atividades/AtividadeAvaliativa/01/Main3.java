public class Main3 {
    public static void main(String[] args) {

        String frase = "Bom dia pra você!";

        frase = frase.replace("!", "");

        String[] palavras = frase.split(" ");

        String resultado = "";

        for (int i = palavras.length - 1; i >= 0; i--) {
            resultado += palavras[i] + " ";
        }

        resultado = resultado.trim() + "!";

        System.out.println(resultado);
    }
}