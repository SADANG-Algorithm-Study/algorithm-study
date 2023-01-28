package _2023_01_21.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        int sum = start;

        while(start <= n) {
            if(sum == n) answer++;
            if(sum > n || end == n) {
                sum -= start++;
            }
            else {
                sum += ++end;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
