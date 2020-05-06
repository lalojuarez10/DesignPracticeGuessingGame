package guessinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class AgileUHSpellChecker implements SpellChecker {
  @Override
  public boolean checkSpelling(String word) {
    try {
      return Boolean.valueOf(getDataFromURL(word));
    }
    catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  protected String getDataFromURL(String word) throws IOException {
    String uri = "http://agile.cs.uh.edu/spell?check=";
    URL url = new URL(uri + word);

    var input = new BufferedReader(new InputStreamReader(url.openStream()));

    return input.readLine();
  }
}
