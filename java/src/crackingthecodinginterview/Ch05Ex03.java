package crackingthecodinginterview;

/**
 * Given an integer, print the next smallest and next largest number that have
 * the same number of 1 bits in their binary representation.
 *
 * @author vedrana
 */
public class Ch05Ex03 {

    public static void sameNumberOfOnesAs(int number) {
        int numberOfBits = numberOfBits(number);
        int nextSmallest = number - 1;
        while (numberOfBits(nextSmallest) != numberOfBits)
            nextSmallest--;

        int nextLargest = number + 1;
        while (numberOfBits(nextLargest) != numberOfBits)
            nextLargest++;

        System.out.println("Number: " + number + " " + Integer.toBinaryString(number));
        System.out.println("Next smallest: " + nextSmallest + " " + Integer.toBinaryString(nextSmallest));
        System.out.println("Next largest: " + nextLargest + " " + Integer.toBinaryString(nextLargest));
    }

    private static int numberOfBits(int number) {
        int numberOfBits = 0;
        while (number > 0) {
            numberOfBits += number & 1;
            number = number >> 1;
        }
        return numberOfBits;
    }

    public static void main(String[] args) {
        sameNumberOfOnesAs(35);

    }

}
