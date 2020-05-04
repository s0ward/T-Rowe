public class Solution {
  public static void main(String[] args){
    String sentence1 = "The cow jumped over the moon.";
    assertEquals(longestWord(sentence1).toString(), "[jumped] of length 6");
    assertEquals(shortestWord(sentence1).toString(), "[The] of length 3");
    //spaces
    String sentence2 = "      ";
    assertEquals(longestWord(sentence2).toString(), "[] of length 0");
    assertEquals(shortestWord(sentence2).toString(), "[] of length 0");
    //tabs
    String sentence3 = "          ";
    assertEquals(longestWord(sentence3).toString(), "[] of length 0");
    assertEquals(shortestWord(sentence3).toString(), "[] of length 0");
    //empty string
    String sentence4 = "";
    assertEquals(longestWord(sentence4).toString(), "[] of length 0");
    assertEquals(shortestWord(sentence4).toString(), "[] of length 0");
    //punctuation test
    String sentence5 = "This tests punctuation, huh?";
    assertEquals(longestWord(sentence5).toString(), "[punctuation] of length 11");
    assertEquals(shortestWord(sentence5).toString(), "[huh] of length 3");
  }

  private static Word longestWord(String s){
    s = removePunctuation(s);
    String[] stringSplit = s.split("\\s+");
    if(stringSplit.length == 0)
      return new Word("",0);
    String longestWord = "";
    int longestWordLength = 0;
    for(String word: stringSplit){
      if(word.length() > longestWordLength) {
        longestWordLength = word.length();
        longestWord = word;
      }
    }
    return new Word(longestWord, longestWordLength);
  }

  private static Word shortestWord(String s){
    s = removePunctuation(s);
    String[] stringSplit = s.split("\\s+");
    if(stringSplit.length == 0)
      return new Word("",0);
    String shortestWord = "";
    int shortestWordLength = Integer.MAX_VALUE;
    for(String word: stringSplit){
      if(word.length() < shortestWordLength) {
        shortestWordLength = word.length();
        shortestWord = word;
      }
    }
    return new Word(shortestWord, shortestWordLength);
  }

  //could be improved and simplified using regex, based on the input space
  private static String removePunctuation(String s){
    return s.replace("." , " ")
    .replace("," , " ")
    .replace("!" , " ")
    .replace("?" , " ");
  }

  //a very basic unit test method in order to avoid using external frameworks such as JUnit
  private static void assertEquals(String actual, String expected){
    if(actual.equals(expected))
      System.out.println("PASSED");
    else{
      System.out.println("[FAILED]: actual("+actual+"), expected("+expected+")");
    }
  }

  //a helper class that would allow us to return 2 variables
  static class Word{
    String word;
    int length;

    Word(String word, int length){
      this.word = word;
      this.length = length;
    }

    @Override
    public String toString(){
      return "[" + this.word + "] of length " + this.length;
    }
  }
}
