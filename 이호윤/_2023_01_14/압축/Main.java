package _2023_01_14.압축;

import java.util.*;

class Solution {
    private List<String> dict = new ArrayList<>(List.of("-", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        String word = "";
        int idx = -1;
        for(String w : msg.split("")) {
            while(true) {
                int nextIdx = dict.indexOf(word + w);
                if(nextIdx != -1) {
                    word += w;
                    idx = nextIdx;
                    break;
                }
                else {
                    answer.add(idx);
                    dict.add(word + w);
                    word = "";
                }
            }
        }
        answer.add(dict.indexOf(word));

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
