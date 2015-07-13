package experiment3;

import java.util.Scanner; 
import experiment3.util.LinkedStack;

public class DecToBin {
	public static void main(String[] args){
		System.out.print("Input a decimal number:");
		Scanner input = new Scanner(System.in);
		int value = input.nextInt();
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		int n = Math.abs(value);
		while(n != 0){
			stack.push(n % 2);
			n = n / 2;
		}
		int result = 0;
		while(!stack.isEmpty())
			result = result * 10 + stack.pop();
		System.out.println("Convert " + value + " to binary:" + result);
	}
}
