package com.develogical;

import java.util.Arrays;

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
            //what is the largest:2064,2061,2042,2052:
            String[] splitString = query.split(":")[1].split(",");
            Arrays.sort(splitString);
            return splitString[splitString.length-1];
        }
        return "";
    }
}
