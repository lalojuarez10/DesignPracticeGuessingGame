package guessinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class PointCheckerTest {
  private SpellChecker spellChecker;
  private PointChecker pointChecker;

  @BeforeEach
  void init() {
    spellChecker = mock(SpellChecker.class);
    when(spellChecker.checkSpelling(any(String.class))).thenReturn(true);

    pointChecker = new PointChecker(spellChecker);
  }

  @Test
  void pointCheckerReturnsZeroForNoVowelAndCorrectWord() {
    pointChecker.checkVowels("crypt");

    assertEquals(0, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsZeroForOneVowelAndMispelledWord() {
    when(spellChecker.checkSpelling("Mon")).thenReturn(false);

    pointChecker.checkVowels("Mon");

    assertEquals(0, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsOneForOneVowelAndCorrectWord() {
    pointChecker.checkVowels("Monk");

    assertEquals(1, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsTwoForTwoVowelsAndCorrectWord() {
    pointChecker.checkVowels("Apple");

    assertEquals(2, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsThreeForThreeVowelsAndCorrectWord() {
    pointChecker.checkVowels("Bananna");

    assertEquals(3, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsZeroForNoConsonant() {
    pointChecker.checkConsonants("e");

    assertEquals(0, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsTwoPointsForOneConsonant() {
    pointChecker.checkConsonants("Ap");

    assertEquals(2, pointChecker.getScore());
  }

  @Test
  void pointCheckerReturnsFourPointsForTwoConsonants() {
    pointChecker.checkConsonants("App");

    assertEquals(4, pointChecker.getScore());
  }
}
