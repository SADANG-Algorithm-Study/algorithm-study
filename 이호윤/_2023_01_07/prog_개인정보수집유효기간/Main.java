package _2023_01_07.prog_개인정보수집유효기간;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Long> t = new HashMap<>();
        long todayAsDay = convertDayToLong(today);

        for(String term : terms) {
            String[] ts = term.split(" ");
            t.put(ts[0], Long.parseLong(ts[1]) * 28);
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] ps = privacies[i].split(" ");
            long end = convertDayToLong(ps[0]) + t.get(ps[1]);
            if(end <= todayAsDay) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    private Long convertDayToLong(String day) {
        String[] daySplit = day.split("\\.");
        return (Long.parseLong(daySplit[0]) * 28 * 12)
                + (Long.parseLong(daySplit[1]) * 28)
                + Long.parseLong(daySplit[2]);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
