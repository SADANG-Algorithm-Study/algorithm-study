package _2023_02_18.트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int w = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        int[] trucksWeight = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] trucksOnBridge = new int[w];
        Arrays.fill(trucksOnBridge, -1);
        int totalWeightOnBridge = 0;
        int bridgeIdx = 0;
        int truckIdx = 0;
        int answer = 0;

        while (truckIdx < n) {
            if(trucksOnBridge[bridgeIdx] != -1) {
                totalWeightOnBridge -= trucksWeight[trucksOnBridge[bridgeIdx]];
                trucksOnBridge[bridgeIdx] = -1;
            }

            if(totalWeightOnBridge + trucksWeight[truckIdx] <= L) {
                trucksOnBridge[bridgeIdx] = truckIdx;
                totalWeightOnBridge += trucksWeight[truckIdx++];
            }

            bridgeIdx = (bridgeIdx + 1) % w;
            answer++;
        }

        while (totalWeightOnBridge > 0) {
            if(bridgeIdx >= 0 && trucksOnBridge[bridgeIdx] != -1) {
                totalWeightOnBridge -= trucksWeight[trucksOnBridge[bridgeIdx]];
                trucksOnBridge[bridgeIdx] = -1;
            }
            bridgeIdx = (bridgeIdx + 1) % w;
            answer++;
        }

        System.out.println(answer);

        br.close();
    }
}
