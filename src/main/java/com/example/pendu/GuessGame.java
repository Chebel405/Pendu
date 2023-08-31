package com.example.pendu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe GuessGame qui fournit les méthodes pour :
 * - Valider si la partie est gagnée ou perdue
 * - Valider si une lettre donnée est considérée comme découverte ou non dans le mot secret
 */
public class GuessGame {
    /**
     * Attribut permettant de stocker le mot secret
     */
    private final List<Character> secretWord = new ArrayList<>();
    /**
     * Stocke le nombre restant de points de vie.
     */
    private int lifePoints;
    /**
     * Stocke les lettres découvertes par le joueur. '_' stocké pour les lettres non découvertes.
     */
    private final List<Character> guessWord = new ArrayList<>();
    /**
     * Stocke les lettres que le joueur a utilisées pour tenter de découvrir le mot secret.
     */
    private final Set<Character> guessedLetters = new HashSet<>();

    /**
     * Construisez un objet de jeu de devinnettes
     * @param wordToGuess le mot secret que le joueur doit découvrir.
     * @param lifePoints le nombre de tentatives autorisées pour découvrir le mot secret.
     */

    public GuessGame(String wordToGuess, int lifePoints) {
        for(char c : wordToGuess.toCharArray()){
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for(int index = 0; index < this.secretWord.size(); index++){
            this.guessWord.add('_');
        }
    }

    @Override
    public String toString() {
        return "GuessGame{" +
                "lifePoints=" + lifePoints +
                ", guessWord=" + guessWord +
                ", guessedLetters=" + guessedLetters +
                '}';
    }

    /**
     * Algorithme qui vérifie si un caractère donné par le joueur est découvert dans le mot secret.
     * @param letter La lettre à valider dans 'secretWord' et 'guessWord'.
     */
    public void guessLetter(char letter) {
        guessedLetters.add(letter);
        if(secretWord.contains(letter) && !guessWord.contains(letter)){
            var index = 0;
            //Si la lettre est présente à tel endroit
            for(char c : secretWord){

                if(c == letter) {
                    guessWord.set(index, c);
                }
                index++;

            }
        }else {
            lifePoints -= 1;
        }
    }

    /**
     * Vérifiez si la partie est perdue.
     * @return boolean true si la partie est perdue, sinon false.
     */
    public boolean isLost() {
        return lifePoints <= 0;
    }

    /**
     * Vérifiez si la partie est gagnée.
     * @return boolean true si la partie est gagnée, sinon false.
     */
    public boolean isWon() {
        return !guessWord.contains('_');
    }
}
