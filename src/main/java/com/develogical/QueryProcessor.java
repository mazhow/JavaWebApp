package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("hopper")) {
            return "Grace Brewster Murray Hopper was an American computer scientist and " +
                    "United States Navy rear admiral. One of the first programmers of the " +
                    "Harvard Mark I computer, she was a pioneer of computer programming " +
                    "who invented one of the first linkers.";
        }
        if (query.toLowerCase().contains("name")) {
            return "MarieSidd";
        }
        if (query.toLowerCase().contains("largest")) {

            String[] splitStringA = query.split(":");
            String[] splitString = splitStringA[2].trim().split(",");

            int size = splitString.length;
            int [] arr = new int [size];
            for(int i=0; i<size; i++) {
                arr[i] = Integer.parseInt(splitString[i].trim());
            }
            Arrays.sort(arr);
            return Integer.toString(arr[arr.length-1]);
        }
        if (query.toLowerCase().contains("plus")) {

            int secondNum = Integer.parseInt(query.split("plus")[1].trim());
            int firstNum = Integer.parseInt(query.split("plus")[0].split("is")[1].trim());

            return Integer.toString(secondNum + firstNum);
        }
        if (query.toLowerCase().contains("multiplied by")) {

            int secondNum = Integer.parseInt(query.split("multiplied by")[1].trim());
            int firstNum = Integer.parseInt(query.split("multiplied by")[0].split("is")[1].trim());

            return Integer.toString(secondNum * firstNum);
        }
        if (query.toLowerCase().contains("colour is a banana")) {
            return "yellow";
        }
        if (query.toLowerCase().contains("james bond")) {
            return "sean connery";
        }
        if (query.toLowerCase().contains("eiffel tower")) {
            return "Paris";
        }
        if (query.toLowerCase().contains("prime")) {

            String[] splitStringA = query.split(":");

            List<String> splitString =
                    Arrays.asList(splitStringA[2].trim().split(","));

            int k=0;

            List<String> resultString = new ArrayList<>();
            for (String numToCheck : splitString) {
                if (isPrime(Integer.parseInt(numToCheck.trim()))) {
                    resultString.add(numToCheck.trim());
                }
            }
            return resultString.toString();
        }

        return "";
    }

    boolean isPrime(int n) {
        for(int i=2;2*i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
