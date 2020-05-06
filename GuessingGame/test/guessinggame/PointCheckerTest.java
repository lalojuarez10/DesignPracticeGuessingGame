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
  void pointCheckerReturnsFalseForMispelledWord() {
    when(spellChecker.checkSpelling("Mon")).thenReturn(false);

    assertEquals(false, pointChecker.checkSpelling("Mon"));
  }

  @Test
  void pointCheckerReturnsZeroForNoVowelAndCorrectWord() {
    assertEquals(0, pointChecker.checkVowels("crypt"));
  }

  @Test
  void pointCheckerReturnsZeroForOneVowelAndMispelledWord() {
    when(spellChecker.checkSpelling("Mon")).thenReturn(false);

    assertEquals(0, pointChecker.checkVowels("Mon"));
  }

  @Test
  void pointCheckerReturnsOneForOneVowelAndCorrectWord() {
    assertEquals(1, pointChecker.checkVowels("Monk"));
  }
}
