import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_5397_키로거 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(in.readLine());

        for (int t = 0; t < tc; t++) {
            String str = in.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                switch (key) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default:
                        left.push(key);
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while(!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
