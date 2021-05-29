package com.training.questions;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Snippet {
	public static int hourglassSum(List<List<Integer>> arr) {
	    // Write your code here
	        List<Integer> result =new ArrayList<>();
	        for (int row=0; row < arr.size()-2; row++) {               
	            for (int col=0; col< arr.size()-2; col++) {
	                int sum=0;
	                for (int subRow =row; subRow < row+3; subRow++) {    
	                    if (subRow != row+1) {
	                        for (int subCol =col; subCol < col+3; subCol++) {
	                            sum  = sum + arr.get(subRow).get(subCol);
	                        } 
	                    }else {
	                        sum = sum + arr.get(subRow).get(col+1);
	                    }                      
	                }
	                result.add(sum);
	            }                            
	        }
	        Collections.sort(result);
	        return result.get(result.size()-1);
	    }
	
	
	public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = hourglassSum(arr);

        try {
			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
	        bufferedReader.close();
	        bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}

