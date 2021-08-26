package com.problem_solving.interview_questions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TempAmplitude {

	public static void main(String[] args) {
		System.out.println(new TempAmplitude().bestSolution(new int[] { -1, -10, 10, 5, 30, 15, 20, -10, 30, 10, 29, 20 }));		
	}

	enum Seasons {
		WINTER, SPRING, SUMMER, AUTUMN
	}

	public String solution(int[] T) {
		final int count = T.length / 4;
		int indx = 0;
		int last = Integer.MIN_VALUE;
		for (int i = 0; i < 4; ++i) {
			int diff = IntStream.of(T).skip(count * i).limit(count).max().getAsInt()
					- IntStream.of(T).skip(count * i).limit(count).min().getAsInt();
			if (diff > last) {
				indx = i;
				last = diff;
			}
		}
		final String[] seasons = { "WINTER", "SPRING", "SUMMER", "AUTUMN" };
		return seasons[indx];
	}

	public String solution1(int[] T) {
		int totalTempReadings = T.length;
		int median = totalTempReadings / 4;
		ArrayList<Integer> winterTemp = new ArrayList<Integer>();
		ArrayList<Integer> springTemp = new ArrayList<Integer>();
		ArrayList<Integer> summerTemp = new ArrayList<Integer>();
		ArrayList<Integer> autumnTemp = new ArrayList<Integer>();

		for (int i = 0; i < totalTempReadings; i++) {
			if (i >= 0 && i <= median - 1) {
				winterTemp.add(T[i]);
			} else if (i >= median && i <= (2 * median) - 1) {
				springTemp.add(T[i]);
			} else if (i >= 2 * median && i <= (3 * median) - 1) {
				summerTemp.add(T[i]);
			} else if (i >= 3 * median && i <= (4 * median) - 1) {
				autumnTemp.add(T[i]);
			}
		}
		winterTemp.sort((a, b) -> a > b ? 1 : -1);
		int winterAmplitude = Math.abs(Math.abs(winterTemp.get(winterTemp.size() - 1)) - Math.abs(winterTemp.get(0)));
		springTemp.sort((a, b) -> a > b ? 1 : -1);
		int springAmplitude = Math.abs(Math.abs(springTemp.get(springTemp.size() - 1)) - Math.abs(springTemp.get(0)));
		summerTemp.sort((a, b) -> a > b ? 1 : -1);
		int summerAmplitude = Math.abs(Math.abs(summerTemp.get(summerTemp.size() - 1)) - Math.abs(summerTemp.get(0)));
		autumnTemp.sort((a, b) -> a > b ? 1 : -1);
		int autumnAmplitude = Math.abs(Math.abs(autumnTemp.get(autumnTemp.size() - 1)) - Math.abs(autumnTemp.get(0)));

		System.out.println("WINTER: " + winterAmplitude + "||" + "SPRING: " + springAmplitude + "||" + "SUMMER: "
				+ summerAmplitude + "||" + "AUTUMN: " + autumnAmplitude);

		Map<Integer, Seasons> seasonAmplitude = new HashMap<Integer, Seasons>();
		seasonAmplitude.put(winterAmplitude, Seasons.WINTER);
		seasonAmplitude.put(springAmplitude, Seasons.SPRING);
		seasonAmplitude.put(summerAmplitude, Seasons.SUMMER);
		seasonAmplitude.put(autumnAmplitude, Seasons.AUTUMN);

		List<Integer> alltemps = Arrays
				.asList(new Integer[] { winterAmplitude, springAmplitude, summerAmplitude, autumnAmplitude });
		alltemps.sort((a, b) -> a > b ? 1 : -1);
		return seasonAmplitude.get(alltemps.get(alltemps.size() - 1)).name();
	}
	
	/**
	 * BEST SOLUTION: 
	 * */
	public String bestSolution(int[] T) {
	    final int count = T.length / 4;
	    int indx = 0;
	    int last = Integer.MIN_VALUE;
	    for (int i = 0; i < 4; ++i) {
	        int diff = IntStream.of(T).skip(count * i).limit(count).max().getAsInt()
	                 - IntStream.of(T).skip(count * i).limit(count).min().getAsInt();
	        if (diff > last) {
	            indx = i;
	            last = diff;
	        }
	    }
	    final String[] seasons = { "WINTER", "SPRING", "SUMMER", "AUTUMN" };
	    return seasons[indx];
	}
	
}
