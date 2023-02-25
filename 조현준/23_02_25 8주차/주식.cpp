#include<iostream>
#include<vector>
using namespace std;
int N, T;
int main()
{
    cin>>T;
    for (int t = 0; t < T;t++){
        cin>>N;
        long long answer = 0;
        vector<int> arr;
        for (int i = 0; i < N; i++)
        {
            int num;
            cin >> num;
            arr.push_back(num);
        }
        int maxValue = arr[N - 1];
        for (int i = N - 2; i >= 0;i--){
            if (maxValue < arr[i])
            {
                maxValue = arr[i];
            }
            else
            {
                int diff = (maxValue - arr[i]);
                answer += diff;
            }
        }

            cout << answer << '\n';
    }
        return 0;
}