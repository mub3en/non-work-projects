
public class Recursion {
	

	//Calculate sum recursively 
	public static int sum(int n) {
		if (n >= 1)
			return sum(n-1) +n;
		//3+4
		//2+3+4
		//1+2+3+4
		
		return n;
	}
	
	//calculate factorial recursively
	public static int factorial(int n) {

		if(n !=0)
			return n * factorial(n-1);
		else
			return 1;
	}
	
	//Power of 10
	public static int powerOf10(int n) {
		if(n ==0)
			return 1;
		else
			return powerOf10(n-1) * 10;			
	}
	
	//power of x^p
	public static int powerOfN(int x, int p) {
		//x = base
		//p - power
		if(p != 0 )
			return x * powerOfN(x, p-1);
		else
			return 1;

	}
	
	//Bunnies have two ears. 
	public static int bunnyEars(int n) {
		if (n == 0)		
			return 0;
		
		return 2 + bunnyEars(n-1);
		
//		return 2 * n;
		
	}
	
	public static int fibonacci(int n) {
	   if (n <= 1) {
	      return n;
	   }
	   return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static String toBinary(int n) {
	    if (n <= 1 ) {
	        return String.valueOf(n);
	    }
	    return toBinary(n / 2) + String.valueOf(n % 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sum of numbers from 1 to 4: " + sum(4));
		System.out.println("Factorial of 4: " + factorial(4));
		System.out.println("Power of 10 ^ 3: " + powerOf10(3));
		System.out.println("Fibonacci sequence for the number 10: " + fibonacci(10));
		System.out.println("Conversion of Integer(5) to Binary: " + toBinary(5));
		System.out.println("Power of 2 ^ 3: " + powerOfN(2,3));
		System.out.println("Total number of ears of 3 bunnies: " + bunnyEars(3));
		
	}

}
