package basics;

import java.util.Arrays;

/**
 * TODO complexities?!
 *
 * @author vjankovic
 */
public class Numbers {

  /**
   * Check if a number is prime.
   *
   * @param num
   * @return
   */
  public static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    // There are no even primes > 2
    if (num % 2 == 0) {
      return false;
    }

		/*
    If n divides a number that is greater than m
		then the result of that division will be some 
		number less than m and thus n will also divide
		a number less or equal to m.
		*/
    int m = (int) Math.sqrt(num);

    for (int i = 3; i <= m; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }


  /**
   * Generating primes from 2 to a given number n -- Sieve of Eratosthenes <br/>
   * 1. Assume all numbers are prime <br/>
   * 2. Take the first prime number and remove all of its multiples <br/>
   * 3. Apply the same method to the next prime number <br/>
   * 4. Continue until all numbers have been processed <br/>
   *
   * @param n
   * @return Array of n+1 booleans, from 0 to n; index marks the number, boolean marks if the number is prime
   */
  public static boolean[] sieveOfEratosthenes(int n) {
    boolean[] primes = new boolean[n + 1];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;
    int root = (int) Math.sqrt(n);

    for (int i = 2; i <= root; i++) {
      if (primes[i]) {
        for (int j = 2; j * i < primes.length; j++) {
          primes[j * i] = false;
        }
      }
    }
    return primes;
  }

  /**
   * Calcualtes GCD using Euclid's algorithm. Assumes that a and b cannot both be 0.
   *
   * @param a
   * @param b
   * @return GCD of a and b
   */
  public static int greatestCommonDivisor(int a, int b) {
    if (b == 0) {
      return a;
    }
    return greatestCommonDivisor(b, a % b);
  }

  /**
   * Converts a number n in base b (2<=b<=10) to a decimal number
   *
   * @param number The number to convert to decimal
   * @param base   Base of number
   * @return
   */
  public static int toDecimalBase(int number, int base) {
    int result = 0;
    int multiplier = 1;
    while (number > 0) {
      result += number % 10 * multiplier;
      multiplier *= base;
      number /= 10;
    }
    return result;
  }

  /**
   * Converts a decimal number n to base b (2<=b<=10)
   *
   * @param number The decimal number to convert
   * @param base   Base to convert to
   * @return
   */
  public static int fromDecimalBase(int number, int base) {
    int result = 0;
    int multiplier = 1;
    while (number > 0) {
      result += number % base * multiplier;
      multiplier *= 10;
      result /= base;
    }
    return result;
  }

  public static void main(String[] args) {
    boolean[] primes = sieveOfEratosthenes(30);
    for (int i = 0; i < primes.length; i++) {
      System.out.print((primes[i] ? i + ", " : ""));
    }
    System.out.println();

    Integer seven = Integer.parseInt("111", 2);
    System.out.println("Should be seven: " + seven);
  }

}
