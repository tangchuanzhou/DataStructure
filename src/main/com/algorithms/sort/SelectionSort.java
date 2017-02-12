package com.algorithms.sort;

import com.algorithms.sort.util.SortUtil;
import com.algorithms.util.In;

/**
 * Selection Sort(select the min value then exchange): 
 * each time we select a min value 
 * then exchange with the first value of unsorted array 
 * */
public class SelectionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			
			//find the min value and then exchange with i
			int min = i;
			for(int j = i+1; j < N; j++) {
				if(SortUtil.less(a[j], a[min])) { 
					min = j;
				}
			}
			SortUtil.exch(a, i, min);
		}
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert SortUtil.isSorted(a);
		SortUtil.show(a);		
	}
}
