#include<iostream>
using namespace std;
int N, W, L;    //트럭 최대수 1000,다리 길이 최대 100, 최대 하중 1000
int arr[1002];  //현재 트럭 얼마나 거리 이동했는지 계산하는 변수
int truckArr[1002];
int main()
{
    cin >> N >> W >> L;
    for (int i = 0;i<N;i++){
        cin >> truckArr[i];
    }
    int curWeight = truckArr[0];  //현재 가중치
    int curTime = 1; //현재 시간
    int frontIndex = 0;   //제일 앞에 트럭 인덱스
    int nextIndex = 1;     // 다음 트럭 인덱스
    arr[0]++;
    while (nextIndex < N)
    {
        // 시간 경과
        curTime++;
        for (int i = frontIndex; i < nextIndex;i++){
            arr[i]++;
        }

            // 아웃 체크
            if (arr[frontIndex] > W)
            {
                curWeight -= truckArr[frontIndex];
                frontIndex++;
            }
        // 진입 체크
        // 현재 다리 가중치 계산
        int nextWeight = curWeight + truckArr[nextIndex];
        if (nextWeight <=L){
            //진입 가능
            arr[nextIndex] = 1;
            curWeight = nextWeight;
            nextIndex++;
        }

    }
    for (int i = arr[N - 1]; i <= W; i++)
    {
        curTime++;
    }

    cout << curTime << '\n';
    return 0;
}