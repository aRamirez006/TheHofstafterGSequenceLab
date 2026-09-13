package org.example;
import java.util.Arrays;

public class Hofstadter {
  // Your implementations of the sequence goes here.
  // Recall that you can calculate the nth term, G(n), using:
  // G(n) = n - G(G(n-1))
  // G(0) = 0
  public Integer naivegSequence(Integer index) {
    if (index == 0) {
      return 0;
    }
    return index - naivegSequence(naivegSequence(index - 1));
  }

  public Integer memogSequence(Integer index) {
    int[] memo = new int[index + 1];
    Arrays.fill(memo, -1);
    return memoHelper(index, memo);
  }

  private Integer memoHelper(Integer index, int[] memo) {
    if (index == 0) return 0;

    if (memo[index] != -1) {
      return memo[index];
    }

    int result = index - memoHelper(memoHelper(index - 1, memo), memo);
    memo[index] = result;
    return result;
  }
}
