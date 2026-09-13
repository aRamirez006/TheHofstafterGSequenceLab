package org.example;

public class App {
    public static void main(String[] args) {
      Hofstadter hofstadter = new Hofstadter();

      for (int i = 0; i <= 6; i++) {
        System.out.println("G(" + i + ") = " + hofstadter.naivegSequence(i));
      }

      for (int i = 0; i <= 6; i++) {
        System.out.println("G(" + i + ") = " + hofstadter.memogSequence(i));
      }
    }
}
