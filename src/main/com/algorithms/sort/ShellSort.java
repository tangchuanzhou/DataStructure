package com.algorithms.sort;

import com.algorithms.sort.util.SortUtil;
import com.algorithms.util.In;

/**
 * Shell Sort is the improvement of the Insertion Sort
 * we can exchange values which are far away which reduce the values' movement time
 * for Shell Sort, we each time do the movement as h
 * */
public class ShellSort {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		//generate the height we used for each SelectionSort
		int h = 1;
		while(h < N/3) h = 3*h +1 ;
		//1, 4, 13 ...
		//which can make sure h/3 loop on different locations
		while(h >= 1) {
			//InsertionSort
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && SortUtil.less(a[j], a[j-h]); j = j-h) {
					SortUtil.exch(a, j, j-h);
				}
			}
			h = h/3;
		}
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert SortUtil.isSorted(a);
		SortUtil.show(a);		
	}

}
