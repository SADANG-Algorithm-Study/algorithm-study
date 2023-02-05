#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <algorithm>
#include <math.h>
#include <stdlib.h>
using namespace std;
#define MAX 54
int N, L, R;
int newPopulation[2510];     // 해당 번호 인덱스에 새로운 인구수 값
int board[MAX][MAX];         // 좌표마다 값을 저장하는 변수
bool moveBoard[MAX][MAX][4]; // 상하좌우 이동가능한 방향을 체크하기 위한 변수
bool visited[MAX][MAX];      // 좌표에 방문을 했는지 확인하는 변수
int tmpBoard[MAX][MAX];      // 좌표마다 연합 번호를 저장한다.
typedef pair<int, int> pii;  // x,y
// 북 0 동 1 남 2 서 3
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};
bool rangeCheck(int x, int y)
{
        if (x >= 0 && x < N && y >= 0 && y < N)
        return true;
        else
        return false;
}
void init()
{
        memset(visited, false, sizeof(visited));
        memset(moveBoard, false, sizeof(moveBoard));
        memset(newPopulation, 0, sizeof(newPopulation));
        for (int i = 0; i < N; i++)
        {
        for (int j = 0; j < N; j++)
        {
            tmpBoard[i][j] = 0;
        }
        }
}
int bfs(int x, int y, int idx)
{
        queue<pii> q;
        int cnt = 1, totalSum = 0;
        q.push(make_pair(x, y));
        visited[y][x] = true;
        tmpBoard[y][x] = idx;
        totalSum += board[y][x];
        while (!q.empty())
        {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            // 범위안에 있고, 이동 가능한 방향이고, 방문을 안한 좌표인지 체크
            if (rangeCheck(nx, ny) && moveBoard[cy][cx][i] && !visited[ny][nx])
            {
                visited[ny][nx] = true;
                tmpBoard[ny][nx] = idx;
                totalSum += board[ny][nx];
                cnt++;
                q.push(make_pair(nx, ny));
            }
        }
        }
        return (totalSum / cnt);
}
int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        cin >> N >> L >> R;
        for (int i = 0; i < N; i++)
        {
        for (int j = 0; j < N; j++)
        {
            cin >> board[i][j];
        }
        }
        int ans = 0;
        bool move = false;
        do
        {
        init(); // 초기화 함수
        move = false;
        // 국경 허무는게 가능한 곳을 전부 연다
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < 4; k++)
                {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (rangeCheck(nx, ny))
                    {
                        int diff = abs(board[i][j] - board[ny][nx]);
                        if (diff >= L && diff <= R)
                        { // 국경을 허물었다면 인구 이동이 가능하므로
                            moveBoard[i][j][k] = true;
                            move = true;
                        }
                    }
                }
            }
        }
        if (move)
        {
            ans++;
            // bfs 를 통해서 같은 연합끼리 표시하고 총합을 구한다.
            int idx = 1;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (!visited[i][j])
                    {
                        int res = bfs(j, i, idx);
                        newPopulation[idx++] = res;
                    }
                }
            }
            // 해당되는 번호에 새롭게 구한 인구수를 좌표마다 저장한다.
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    board[i][j] = newPopulation[tmpBoard[i][j]];
                }
            }
        }
        } while (move);
        cout << ans << '\n';
        return 0;
}