import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_16918_봄버맨 {

    private static int R;
    private static int C;
    private static int N;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] bombTime = new int[R][C];  // 폭탄이 터질 시간

        for (int i = 0; i < R; i++) {
            String tempMap = in.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tempMap.charAt(j);
                if (map[i][j] == 'O') {
                   bombTime[i][j] = 3;
                }
            }
        }

        for (int time = 1; time <= N; time++) {

            if (time % 2 == 0) {  // 폭탄 설치
                plantBombs(time, map, bombTime);
            } else if (time % 2 == 1) {  // 폭발
                explode(time, map, bombTime);
            }
        }
        print(map);
    }

    private static void plantBombs(int time, char[][] map, int[][] bombTime) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bombTime[i][j] = time + 3;
                }
            }
        }
    }

    private static void explode(int time, char[][] map, int[][] bombTime) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombTime[i][j] == time) {
                    map[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                            continue;
                        }

                        if (map[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                            map[nx][ny] = '.';
                            bombTime[nx][ny] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}