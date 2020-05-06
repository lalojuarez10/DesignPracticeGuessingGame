package guessinggame;

import java.awt.*;

public class PointChecker {
  private int score;
  private SpellChecker spellChecker;

  PointChecker(SpellChecker aSpellChecker) {
    spellChecker = aSpellChecker;
  }

  public boolean checkSpelling(String word) {
    return spellChecker.checkSpelling(word);
  }

  public boolean isAVowel(Character letter) {
    return letter == 'A' || letter.equals('E') || letter == 'I' ||
      letter == 'O' || letter == 'U' || letter == 'a' ||
      letter == 'e' || letter == 'i' || letter == 'o' ||
      letter == 'u';
  }

  public int checkVowels(String word) {
    if(!checkSpelling(word)) {
      return 0;
    }

    for(Character letter : word.toCharArray()) {
      if(isAVowel(letter)) {
        score += 1;
      }
    }

    return score;
  }
}
