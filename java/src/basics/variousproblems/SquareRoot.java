package basics.variousproblems;

// Calculate square root of a number, rounded down to the nearest integer,
// of course, without using Math.sqrt()
public class SquareRoot {

    public int calculate(int num) {
        if (num < 0)
            return -1;
        else if (num == 0)
            return 0;
        else if (num == 1)
            return 1;

        int low = 0;
        int high = num / 2 + 1;
        int maxBestSqrt = -1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int sqr = middle * middle;
            if (sqr == num) {
                return middle;
            } else if (sqr < num) {
                if (middle > maxBestSqrt)
                    maxBestSqrt = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return maxBestSqrt;
    }

    public static void main(String[] args) {
        SquareRoot sqrt = new SquareRoot();
        System.out.println("Sqrt(4) = " + sqrt.calculate(4)); // 2
        System.out.println("Sqrt(5) = " + sqrt.calculate(5)); // 2
        System.out.println("Sqrt(6) = " + sqrt.calculate(6)); // 2
        System.out.println("Sqrt(10) = " + sqrt.calculate(10)); // 3
        System.out.println("Sqrt(15) = " + sqrt.calculate(15)); // 3
        System.out.println("Sqrt(20) = " + sqrt.calculate(20)); // 4
        System.out.println("Sqrt(25) = " + sqrt.calculate(25)); // 5
    }

}
