package experiment1;

import java.util.Arrays;

public class SortedArrays {
	
	public static boolean isSorted(int[] table){
	  if(table == null)
        return false;
	  for(int i = 0;i < table.length - 1;i++)
	    if(table[i] > table[i+1])
	      return false;
	  return true;
	}
	
	public static <E extends Comparable<E>> boolean isSorted(E[] table){
	  if(table == null)
	    return false;
	  for(int i = 0;i < table.length - 1;i++)
		if(table[i].compareTo(table[i+1]) > 0)
		  return false;
	  return true;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1,3,5,6,8,9};
		int[] array2 = {1,2,5,8,6,7};
		String[] array3 = {"abbd","abcc","abcd"};
		String[] array4 = {"abcd","abcc","abbd"};
		
		System.out.println("Is the array " + Arrays.toString(array1) + " sorted? " + isSorted(array1));
		System.out.println("Is the array " + Arrays.toString(array2) + " sorted? " + isSorted(array2));
		System.out.println("Is the array " + Arrays.toString(array3) + " sorted? " + isSorted(array3));
		System.out.println("Is the array " + Arrays.toString(array4) + " sorted? " + isSorted(array4));
	}
}
