package com.problem_solving.interview_questions;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product. Return the product
 * Ex : Input : [2, 3, -2, 4] Output : 6
 * Explanation: [2,3] has the highest product 6
 * */
public class ContiguousNonEmptySubarray {
	
	public static void main(String[] args) {
				
		int[] nums = {2, 3, -2, 4};
		getproduct(nums);		
		
	}
	
	private static void getproduct(int[] nums) {
		for(int i = 0; i<nums.length-1; i++) {
			for(int j = i+1; j<nums.length; j++) {
				System.out.println(i+", "+j);
				
			}
		}
	}
	
	

}
