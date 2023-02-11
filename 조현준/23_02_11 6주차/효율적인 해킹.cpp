#include <iostream>
#include <vector>
#include <math.h>
using namespace std;
#define MAX 10005
bool visited[MAX];
int nodeValue[MAX];
vector<int> edge[MAX];
int N, M, A, B;

int dfs(int node)
{
    int result = 0;
    for (int i = 0; i < edge[node].size(); i++)
    {
        int nextNode = edge[node][i];
        if (visited[nextNode] == false)
        {
            visited[nextNode] = true;
            result += dfs(nextNode) + 1;
        }
    }
    return result;
}
void init(){
    for (int i = 1;i<=N;i++){
        visited[i] = false;
    }
}

int main()
{
    vector<int> answer;
    cin >> N >> M;
    // init
    for (int i = 1; i <= N; i++)
    {
        nodeValue[i] = 1;
    }
    for (int i = 0; i < M; i++)
    {
        cin >> A >> B;
        edge[B].push_back(A);
    }
    int maxValue = 0;

    for (int i = 1; i <= N; i++)
    {
        init();
        visited[i] = true;
        nodeValue[i] = dfs(i);
        maxValue = max(nodeValue[i], maxValue);
    }

    for (int i = 1;i<=N;i++){
        if(maxValue == nodeValue[i]){
            cout << i << ' ';
        }
    }

        return 0;
}