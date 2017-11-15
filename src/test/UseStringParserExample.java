package test;

import org.apache.catalina.util.StringParser;

public class UseStringParserExample {
  public static void main(String[] args) {
    StringParser parser = new StringParser();
    parser.setString("item1,item2");
    // Extract the comma-delimited entry
    int length = parser.getLength();
    int start = parser.getIndex();
    if (start < length) {
      int end = parser.findChar(',');
      String entry = parser.extract(start, end).trim();
      System.out.println(entry);
      parser.advance();   // For the following entry
      start = parser.getIndex();
      end = parser.findChar(',');
      entry = parser.extract(start, end).trim();
      System.out.println(entry);
    }
  }
}