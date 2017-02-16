package com.algorithms.sort;

import com.algorithms.sort.util.SortUtil;
import com.algorithms.util.In;

/**
 * traditional bubble sort, just write for record.
 * */

public class BubbleSort {
	public static void sort(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			for(int j = 1; j < a.length; j++) {
				if (SortUtil.less(a[j], a[j-1])) {
					SortUtil.exch(a, j, j-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert SortUtil.isSorted(a);
		SortUtil.show(a);					
	}	
}
