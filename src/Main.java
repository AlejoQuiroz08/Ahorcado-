import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] palabras = {"java", "programacion", "computadora", "ahorcado", "desarrollo", "inteligencia", "artificial", "consola", "juego", "programador"};
        String palabraSecreta = seleccionarPalabra(palabras).toUpperCase();
        char[] palabraAdivinada = new char[palabraSecreta.length()];
        int intentosMaximos = 7;
        int intentosRealizados = 0;
        Scanner scanner = new Scanner(System.in);

        inicializarPalabraAdivinada(palabraAdivinada);

        System.out.println("¡Bienvenido al juego del ahorcado!");

        while (intentosRealizados < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + new String(palabraAdivinada));
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            if (adivinarLetra(letra, palabraSecreta, palabraAdivinada)) {
                System.out.println("¡Correcto!");
            } else {
                intentosRealizados++;
                System.out.println("Incorrecto. Te quedan " + (intentosMaximos - intentosRealizados) + " intentos.");
            }

            if (esPalabraCompleta(palabraAdivinada)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                break;
            }
        }

        if (!esPalabraCompleta(palabraAdivinada)) {
            System.out.println("¡Oh no! Se te acabaron los intentos. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }

    private static String seleccionarPalabra(String[] palabras) {
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    private static void inicializarPalabraAdivinada(char[] palabraAdivinada) {
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }
    }

    private static boolean adivinarLetra(char letra, String palabraSecreta, char[] palabraAdivinada) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    private static boolean esPalabraCompleta(char[] palabraAdivinada) {
        for (char c : palabraAdivinada) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
