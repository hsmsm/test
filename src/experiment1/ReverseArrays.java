package experiment1;

import java.util.Arrays;

public class ReverseArrays {
	
	public static  int[] reverse(int[] value){ 
      int temp;
	  for(int i = 0;i < value.length / 2;i++){
	    temp = value[i];
	    value[i] = value[value.length - i -1];
	    value[value.length - i -1] = temp;
	  }
	  return value;
	}
	
	public static  Object[] reverse(Object[] value){ 
	  Object temp = null;
      for(int i = 0;i < value.length / 2;i++){
        temp = value[i];
        value[i] = value[value.length - i -1];
        value[value.length - i -1] = temp;
      }
      return value;
	}

	public static void main(String[] args) {
		  int[] array1 = {1,2,3,4,5,6};
		  
		  System.out.print("Before reversing,array1 is " + Arrays.toString(array1));
	      reverse(array1);
		  System.out.println("\nAfter reversing,array1 is " + Arrays.toString(array1));
	      
	      String[] array2 = {"ab","cd","ef","gh"};
		  System.out.print("Before reversing,array2 is " + Arrays.toString(array2));
	      reverse(array2);
		  System.out.print("\nAfter reversing,array2 is " + Arrays.toString(array2));
	}
}
