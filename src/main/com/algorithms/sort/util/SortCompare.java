package com.algorithms.sort.util;

import com.algorithms.sort.InsertionSort;
import com.algorithms.sort.SelectionSort;
import com.algorithms.util.StdOut;
import com.algorithms.util.StdRandom;
import com.algorithms.util.Stopwatch;

/**
 * This class is used to compare the performance between different methods of sort
 * */
public class SortCompare {
	
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")) InsertionSort.sort(a);
		if(alg.equals("Selection")) SelectionSort.sort(a);
		return timer.elapsedTime();
	}
	
	/**
	 * @param N; the size of the array used for test
	 * @param T; test for N batch times and get the total
	 * args[] = Insertion Selection 1000 100
	 * */
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for(int t = 0; t < T; t++) {
			//have a batch test
			for(int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T); //total time for the algorithms1
		double t2 = timeRandomInput(alg2, N, T); //total time for the algorithms2
		
		StdOut.printf("For %d random Doubles \n %s is", N, alg1);
		StdOut.printf(" %.1f times faster tham %s\n", t2/t1, alg2);
	}
}
