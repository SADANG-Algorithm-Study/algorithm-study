import java.util.*;

public class Solution_Lv1_개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        Map<String, String> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termList = term.split(" ");
            termMap.put(termList[0], termList[1]);
        }

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] privacyList = privacy.split(" ");

            if (checkDeletePrivacy(privacyList[0], today, termMap.get(privacyList[1]))) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean checkDeletePrivacy(String privacy, String today, String term) {
        String[] privacyDate = privacy.split("\\.");
        String[] todayDate = today.split("\\.");

        int privacyInt = dateArrayToInt(privacyDate);
        int todayInt = dateArrayToInt(todayDate);

        int expiration = privacyInt + (Integer.parseInt(term) * 28);
        return expiration <= todayInt;
    }

    private static int dateArrayToInt(String[] date) {
        return Integer.parseInt(date[2])
                + (Integer.parseInt(date[1]) * 28)
                + (Integer.parseInt(date[0]) * 28 * 12);
    }
}