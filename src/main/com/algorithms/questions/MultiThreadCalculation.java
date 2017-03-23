package com.algorithms.questions;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.algorithms.util.StdOut;

/**
 * suppose there is a large array maybe billion, 
 * how we get the summary of all elements with multiple thread
 * hint Java Concurrent forkjoin
 * */
public class MultiThreadCalculation extends RecursiveTask<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2425041673683123358L;
	public static final int THRESHOLD = 10;
	private int start ;
	private int end;
	
	public MultiThreadCalculation(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		int sum = 0;
		
		if(end-start <= THRESHOLD) {
			for(int i = start; i <= end; i++) {
				sum += i;
//				StdOutprint("temp sum is " + sum);
			}
		}else {
			int middle = (start + end) / 2;
			MultiThreadCalculation left = new MultiThreadCalculation(start, middle);
			MultiThreadCalculation right = new MultiThreadCalculation(middle+1, end);
			
			//fork/join
			left.fork();
			right.fork();
			
			sum = left.join() + right.join();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int testSize = 1000000;
		int cores = Runtime.getRuntime().availableProcessors();
		StdOut.println("test with cores number:" + cores);
		ForkJoinPool calPool = new ForkJoinPool(cores);
		MultiThreadCalculation task = new MultiThreadCalculation(0, testSize);
		long startTime = System.currentTimeMillis();
		Integer result = calPool.invoke(task);
		if(task.isCompletedAbnormally()) {
			StdOut.print(task.getException());
		}
		long endTime = System.currentTimeMillis();
		StdOut.println("fork join result is " + result + " time cost is  " + (endTime-startTime) + "ms");
		
		//let's see if fokr/join really good has performance for calculation.interesting:)
		startTime = System.currentTimeMillis();
		result = 0;
		for(int i = 0; i <= testSize; i++) {result += i;}
		endTime = System.currentTimeMillis();
		StdOut.println("loop result is " + result + " time cost is " + (endTime-startTime) + "ms");		
	}

}
