package guessinggame;

import java.util.Arrays;

public class PointChecker {
  private int score;
  private SpellChecker spellChecker;

  PointChecker(SpellChecker aSpellChecker) {
    spellChecker = aSpellChecker;
  }

  public boolean checkSpelling(String word) {
    return spellChecker.checkSpelling(word);
  }

  public boolean isAVowel(String letter) {
    return Arrays.stream(Vowels.values())
      .anyMatch(vowel -> vowel.name().equals(letter));
  }

  public void checkVowels(String word) {
    if(checkSpelling(word)) {
      for(Character letter : word.toCharArray()) {
        if(isAVowel(letter.toString().toUpperCase())) {
          score += 1;
        }
      }
    }
  }

  public int getScore() {
    return score;
  }

  public void checkConsonants(String word) {
    if(checkSpelling(word)) {
      for(Character letter : word.toCharArray()) {
        if(isAConsonant(letter.toString().toUpperCase())) {
          score += 2;
        }
      }
    }
  }

  private boolean isAConsonant(String letter) {
    return Arrays.stream(Consonants.values())
      .anyMatch(consonant -> consonant.name().equals(letter));
  }
}
