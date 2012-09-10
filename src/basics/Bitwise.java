package basics;

public class Bitwise {
	
	public static int howManyOneBits(int num) {
		int oneBits = 0;
		int mask = 1;
		while (num > 0) {
			oneBits += num & mask;
			num = num >> 1;
		}
		return oneBits;
	}
	
	public static void main(String[] args) {
		int a = 11; //1011
		int b = 12; // 1100
		
		System.out.println(howManyOneBits(a));
		System.out.println(howManyOneBits(b));
		
	}

}
