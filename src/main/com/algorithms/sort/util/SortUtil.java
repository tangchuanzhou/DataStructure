package com.algorithms.sort.util;

import java.util.Arrays;

import com.algorithms.util.In;
import com.algorithms.util.StdOut;

/******************************************************************************
 *
 * SortUtil provides help methods for InsertionSort, MergeSort and ....
 * provide methods like less(); exch();show(); isSorted(); 
 ******************************************************************************/

public class SortUtil {
	
	/**
	 * use the java.util.Arrays.sort() as the test method
	 * we will imply more specific method later
	 * */
	public static void sort(Comparable[] a) {
		Arrays.sort(a);
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert isSorted(a);
		show(a);
		
		String[] b = In.readStrings("src/testcase/words.txt");
		sort(b);
		assert isSorted(b);
		show(b);
	}
	
}
