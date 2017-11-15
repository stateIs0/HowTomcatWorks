package test;

import java.io.File;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.xml.sax.Attributes;

public class UseDigesterExample {

  public void parse() {
    String path = System.getProperty("user.dir") + File.separator  + "etc";
    File file = new File(path, "MyDocument-1.xml");

    Digester digester = new Digester();
    try {
      Rule rule = new MyRule();
      digester.addRule("book", rule);
      //digester.addRule("a/b", rule);
      digester.parse(file);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    UseDigesterExample digester = new UseDigesterExample();
    digester.parse();
  }
}


class MyRule extends Rule {
  public void begin(Attributes attributes) throws Exception {
    System.out.println("begin");
  }

  public void body(String text) throws Exception {
    System.out.println("body. Text:" + text);
  }

  public void end() throws Exception {
    System.out.println("end");
  }

  public void finish() throws Exception {
    System.out.println("finish");
  }

}
