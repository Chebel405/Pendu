import com.example.pendu.GuessGame;
import org.springframework.boot.SpringApplication;


import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        final var random = new Random();
        final var words = "chien chat loup apocope apherese malade epilespie".split(" ");
        final var wordToGuess = words[ random.nextInt(words.length) ];
        final var game = new GuessGame(wordToGuess, 10);

        System.out.println("Debut du jeu du pendu");

        while (true) {
            System.out.println(game);
            System.out.println("Entrez une lettre : ");
            final var letter = scanner.nextLine().charAt(0);

            // Voir si la lettre est correcte
            game.guessLetter(letter);

            // Savoir si la lettre est correcte ou non
            if(game.isLost()){
                System.out.println(game);
                System.out.println("Perdu ");
                break;

            }
            if(game.isWon()){
                System.out.println(game);
                System.out.println("Gagné ");
                break;

            }
        }

    }

}
