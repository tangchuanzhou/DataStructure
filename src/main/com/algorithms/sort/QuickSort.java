package com.algorithms.sort;

import com.algorithms.sort.util.SortUtil;
import com.algorithms.util.In;

/**
 * partition the array into two and sort each of them recursively
 * then the total array would be in order
 * */
public class QuickSort {
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	
	public static void sort(Comparable[] a, int low, int high) {
		if(low >= high)
			return;
		int j = partition(a, low, high);
		sort(a, low, j-1);
		sort(a, j+1, high);
	}
	
	public static int partition(Comparable[] a, int low, int high) {
		int i = low; int j = high+1;
		Comparable v = a[low];
		while(true) {
			//move the point i until find bigger value than the key or to the right
			while(SortUtil.less(a[++i], v)) if(i == high) break;  			
			//move the pint j until find one smaller value than the key or to the left 
			while(SortUtil.less(v, a[--j])) if(j == low) break;
			if(i >= j) {
				break;
			}
			SortUtil.exch(a, i, j);
		}
		SortUtil.exch(a, low, j);
		return j;
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert SortUtil.isSorted(a);
		SortUtil.show(a);		
	}	
}
