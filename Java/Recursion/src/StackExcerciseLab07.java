import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class StackExcerciseLab07 {

	public static void InverseNumbers(int n) {
		// last in first out
		Stack<Integer> s = new Stack<Integer>();
		int digit = 0, rev_num = 0, power = 0;
		while (n > 0) {
			digit = n % 10;
			s.push(digit);
			n /= 10;
		}

		while (!s.isEmpty()) {
			digit = s.pop();
			rev_num = rev_num + digit * (int) Math.pow(10, power);
			power = power + 1;
		}

		System.out.println(rev_num);
	}
	
	public static String reverse(String sentence) {
		String reversed = "";
		
		Stack<String> stack = new Stack<>();
		Scanner scanner = new Scanner(sentence);
		// Get the words in a sentence
		while (scanner.hasNext()) {
			String pushWord = scanner.next();
			// your code here.			
			// Call a method processSentence when you find a period.			
			if(pushWord.contains(".")) {
				pushWord = pushWord.replace(".", "");
				String firstLetter = pushWord.substring(0, 1); 
				pushWord =  firstLetter.toUpperCase() + pushWord.substring(1);
				stack.push(pushWord);
				reversed =  processSentence(stack, reversed);
			}else {
				pushWord = pushWord.toLowerCase();
				stack.push(pushWord);

			}

		}
		
		scanner.close();
		
		return reversed;
	}
	
	
	public static String processSentence(Stack<String> stack, String reversed) {
	     // your code here.
		int start =0;
		int size = stack.size();
		while(!stack.isEmpty()) {
			start++;
			if(start == size)
				reversed = reversed+ "" +stack.pop() + ". " ;
			else
				reversed = reversed+ "" +stack.pop() + " " ;
		}
		
		return reversed;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("The inverse of numbers 1234: ");
		InverseNumbers(1234);
		String original = "Mary had a little lamb.  His fleece was as white as snow.";
		String reverse_str = reverse(original);
		System.out.println("\n\nOrginal sentences:  " + original);
		System.out.println("Sentences reverse:  " + reverse_str);

		
		
 

	}

}
