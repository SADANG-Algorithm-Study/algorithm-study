public class Solution_Lv0_공던지기 {

    public int solution(int[] numbers, int k) {
        int index = 2 * (k - 1);
        return numbers[index % numbers.length];
    }
}
