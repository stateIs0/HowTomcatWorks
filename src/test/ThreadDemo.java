package test;

public class ThreadDemo extends Thread {

  public void run() {
    int counter = 0;
    while (counter < 5) {
      System.out.println("running " + counter);
      counter++;
    }
  }

  public static void main(String[] args) {
    ThreadDemo demo = new ThreadDemo();
    demo.start();
  }
}