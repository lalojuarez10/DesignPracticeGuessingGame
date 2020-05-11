package guessinggame.main;

import guessinggame.AgileUHSpellChecker;
import guessinggame.PointChecker;
import guessinggame.SpellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RunGuessingGame {
  public static String scrambler(ArrayList<String> words){
    String randomWord = chooseRandomWord(words);

    List<String> letters = Arrays.asList(randomWord.split(""));
    Collections.shuffle(letters);

    String shuffledWord = "";

    for(String letter : letters) {
      shuffledWord += letter;
    }

    return shuffledWord;
  }

  public static String chooseRandomWord(ArrayList<String> words) {
    Random rand = new Random();

    int randomNumber = rand.nextInt(words.size());

    return words.get(randomNumber);
  }

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("sample.txt");

    Scanner scanner = new Scanner(file);

    ArrayList<String> words = new ArrayList<>();

    while (scanner.hasNextLine())
      words.add(scanner.nextLine());

    String scrambledWord = scrambler(words);

    Scanner userInputScanner = new Scanner(System.in);
    System.out.println("This is the scrambled word: " + scrambledWord);
    System.out.println("Enter a guess: ");

    String playerGuess = userInputScanner.nextLine();

    SpellChecker spellChecker = new AgileUHSpellChecker();
    PointChecker pointChecker = new PointChecker(spellChecker);

    pointChecker.checkConsonants(playerGuess);
    pointChecker.checkVowels(playerGuess);

    System.out.println("Score: " + pointChecker.getScore());
  }
}
