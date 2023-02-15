import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1325_효율적인해킹 {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] relation = new List[N];
        for (int i = 0; i < N; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (!relation[b].contains(a)) {
                relation[b].add(a);
            }
        }

        int maxCount = 0;
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int count = dfs(i, relation);
            if (maxCount < count) {
                maxCount = count;
                maxList.clear();
                maxList.add(i);
            } else if (maxCount == count) {
                maxList.add(i);
            }
        }

        Collections.sort(maxList);
        for (Integer maxNum : maxList) {
            System.out.print(maxNum + 1 + " ");
        }
    }

    private static int dfs(int num, List<Integer>[] relation) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];

        stack.push(num);
        visited[num] = true;

        int count = 1;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int r : relation[cur]) {
                if (!visited[r]) {
                    stack.push(r);
                    visited[r] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
