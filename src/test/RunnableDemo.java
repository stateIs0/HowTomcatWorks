package test;

public class RunnableDemo implements Runnable {

  public void run() {
    int counter = 0;
    while (counter < 5) {
      System.out.println("running " + counter);
      counter++;
    }
  }

  public void start() {
    Thread thread = new Thread(this);
    thread.start();
  }

  public static void main(String[] args) {
    RunnableDemo demo = new RunnableDemo();
    demo.start();
  }
}