package _2023_01_07.prog_공던지기;

class Solution {
    public int solution(int[] numbers, int k) {
        int idx = 0;
        int size = numbers.length;

        for(int i = 1; i < k; i++) {
            idx = (idx + 2) % size;
        }

        return numbers[idx];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
