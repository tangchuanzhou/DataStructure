package com.algorithms.sort;

import com.algorithms.sort.util.SortUtil;
import com.algorithms.util.In;

/**
 * MergeSort is a divide and conquer algorithm. 
 * After divide array to single one then it would be in order
 * the we will merger two ordered array into one.
 * them the full array would be in order.
 * */
public class MergeSort {
	
	//extra space used for MergeSort
	private static Comparable[] aux;
	
	public static void merge(Comparable[] a, int low, int mid, int high) {
		
		//copy original array to extra
		for(int i = low; i <= high; i++) {
			aux[i] = a[i];
		}
		int i = low; int j = mid+1;
		for(int k = low; k <= high; k++) {
			if(i > mid) a[k] = aux[j++]; //first array is done no need to compare append the second array
			else if(j > high) a[k] = aux[i++]; //send array is done no need to compare only append the first array 
			else if(SortUtil.less(aux[i], aux[j])) a[k] = aux[i++];  //compare the value in two arrays and choose the smaller one to append
			else a[k] = aux[j++];
		}
	}	
	
	public static void sort(Comparable[] a, int low, int high) {
		//always return when using recursion
		if(high <= low) return;
		int mid = (low+high)/2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge(a, low, mid, high);		
	}
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("src/testcase/tiny.txt");
		sort(a);
		assert SortUtil.isSorted(a);
		SortUtil.show(a);		
	}	
}
