/**
 * 
 */
package com.algorithms.sort;

import com.algorithms.sort.util.SortUtil;
import com.algorithms.util.In;

/**
 *InsertionSort is like how people play and organize cards.
 *first with one card, then will insert latest cards 
 *into hands' cards with correct location.
 *
 * from computer's side, the latest card will compare from
 * end to begin until find the correct location.
 */
public class InsertionSort {
	
	/**
	 * my understanding of the insertion sort
	 * */
	public static void sort(Comparable[] a) {
		for(int i = 0; i < a.length-1; i++) {
			//insert a[j] into a[j-1],a[j-2]....a[0].
			for(int j = i+1; j > 0; j--) {
				if(SortUtil.less(a[j], a[j-1])) {
					SortUtil.exch(a, j, j-1);
				}
			}
		}
	}
	
	/**
	 * from Seg's text book which code is more beautiful and simple
	 * */
	public static void sort2(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			for(int j = i; j > 0 && SortUtil.less(a[j], a[j-1]); j--) {
				SortUtil.exch(a, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert SortUtil.isSorted(a);
		SortUtil.show(a);		
		String[] b = In.readStrings("src/testcase/tiny.txt");
		sort2(b);
		assert SortUtil.isSorted(b);
		SortUtil.show(b);		
		
	}
}
