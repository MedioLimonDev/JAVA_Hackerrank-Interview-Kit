package com.denise.limon.dev.hackerrank_interview_kit.WarmUpChallenges;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SalesByMatch {
	public int calculateSalesByMatch(int n, int[] arr) {
		return createMap(arr);
	}
	
	private Integer createMap(int[] arr){
		if(arr.length >= 1 && arr.length <= 100) {
			Map countMap = new LinkedHashMap<>();
			
			for(int i = 0; i < arr.length; i++) {
				if(countMap.containsKey(arr[i])) {
					int auxValue = (int) countMap.get(arr[i]);
					countMap.replace(arr[i], auxValue, auxValue++);
				} else {
					countMap.put(arr[i], 1);
				}
			}
			
			countPairs(countMap);
			
			return 1;
		} else {
			return null;
		}
	}
	
	private int countPairs(Map<int,int> countMap) {	
		Integer totalCount = 0; 
		for (Map.Entry<Integer, Integer> m : countMap.entrySet()) {
			int valueAux = m.getValue();
			if(valueAux != 1) {
				if(valueAux % 2 == 0) {//Si es par
					totalCount += (valueAux / 2);
				} else {
					totalCount += ((valueAux - 1) / 2);
				}
			}
		}
		
		return totalCount; 
	}

}
