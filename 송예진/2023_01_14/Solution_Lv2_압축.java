import java.util.*;

public class Solution_Lv2_압축 {

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> dictionary = initDictionary(); // 사전 초기화
        int dicIndex = dictionary.size() + 1;
        int msgLength = msg.length();

        // currentIdx : 현재 글자 첫 문자의 msg index
        // nextIdx : 현재 글자 마지막 문자 한 칸 오른쪽의 msg index
        for (int currentIdx = 0; currentIdx < msgLength; currentIdx++) {
            int nextIdx = currentIdx;
            while (true) {
                nextIdx++;

                if (nextIdx > msgLength) {
                    // 마지막으로 처리되지 않은 글자
                    String lastMsg  = msg.substring(currentIdx, msgLength);
                    answer.add(dictionary.get(lastMsg));
                    break;
                }

                String tempMsg = msg.substring(currentIdx, nextIdx);
                if (!dictionary.containsKey(tempMsg)) {
                    String existMsg = tempMsg.substring(0, tempMsg.length() - 1);
                    answer.add(dictionary.get(existMsg));
                    dictionary.put(tempMsg, dicIndex++);
                    break;
                }
            }
            currentIdx = nextIdx - 2;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private Map<String, Integer> initDictionary() {
        Map<String, Integer> dictionary = new HashMap<>();
        char character = 'A';
        for (int i = 1; i <= 26; i++) {
            dictionary.put(Character.toString(character++), i);
        }
        return dictionary;
    }
}
