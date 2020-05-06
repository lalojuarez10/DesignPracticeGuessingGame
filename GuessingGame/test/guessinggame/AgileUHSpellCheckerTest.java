package guessinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgileUHSpellCheckerTest {
  private AgileUHSpellChecker spellChecker;

  @Test
  void canary() {
    assertTrue(true);
  }

  @BeforeEach
  void init() {
    spellChecker = new AgileUHSpellChecker();
  }

  @Test
  void spellCheckForMonkeyReturnsTrue() {
    assertEquals(true, spellChecker.checkSpelling("monkey"));
  }

  @Test
  void spellCheckForMonReturnsFalse() {
    assertEquals(false, spellChecker.checkSpelling("mon"));
  }
}
