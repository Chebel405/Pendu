import com.example.pendu.GuessGame;
import org.springframework.boot.SpringApplication;


import java.util.Random;
import java.util.Scanner;

/**
 * Classe du point d'entrée du jeu
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Point d'entréedu main avec l'algorythme principal
         */

        final var random = new Random();
        final var words = "chien chat loup apocope apherese malade epilespie".split(" ");
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("Debut du jeu du pendu");

        while (true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre : ");

            // Voir si la lettre est correcte
            game.guessLetter(letter);

            // Savoir si la lettre est correcte ou non
            if(game.isLost()){
                System.out.println(game);
                System.out.println("Perdu ");
            }
            if(game.isWon()){
                System.out.println(game);
                System.out.println("Gagné ");
            }
            if(game.isWon() || game.isLost()){
                var replayAnswer = scanLetter("Voulez-vous rejouer ?");
                if (replayAnswer == 'y' || replayAnswer == 'Y' || replayAnswer == 'o' || replayAnswer == 'O'){
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, 10);
                }else{
                    break;
                }
            }

        }

    }
    private static char scanLetter(String question){
        final var scanner = new Scanner(System.in);
        Character letter = null;

        do{
            System.out.println(question);
            var input = scanner.nextLine();
            if(input.length() == 1){
                letter = input.charAt(0);
            }
        } while (letter == null);
        return letter;
    }

}
