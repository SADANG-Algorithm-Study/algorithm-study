import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_9081_단어맞추기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < T; tc++) {
            String word = in.readLine();
            char[] wordArray = word.toCharArray();

            // 1. 교환 위치 찾기 (자신 뒤에 있는 문자보다 순서가 앞인 문자)
            int index = -1, index2 = 0;
            for (int i = wordArray.length - 1; i > 0 ; i--) {
                if (wordArray[i - 1] < wordArray[i]) {
                    index = i - 1;
                    break;
                }
            }

            if (index == -1) {  // 없다면 주어진 단어 출력
                sb.append(word).append("\n");
                continue;
            }

            // 2. 교환할 위치 찾기 (맨 뒤에서부터 교환할 문자보다 순서가 뒤인 문자)
            for (int i = wordArray.length - 1; i >= 0; i--) {
                if (wordArray[index] < wordArray[i]) {
                    index2 = i;
                    break;
                }
            }

            // 3. 교환
            swap(wordArray, index, index2);

            // 4. 교환 위치 이후 값 정렬
            Arrays.sort(wordArray, index + 1, wordArray.length);

            sb.append(String.valueOf(wordArray)).append("\n");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
