#include<iostream>
#include<string.h>
using namespace std;
#define MAX 201
string board[MAX];
string answer[5][MAX];
int R, C, N;
int m_xy[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

bool rangeCheck(int cx,int cy){
    if((0<= cx && cx< C) &&( 0<=cy && cy<R)){
        return true;
    }
    return false;
}
void answerPrint(int index){
        for (int i = 0;i<R;i++){
            cout << answer[index][i] << '\n';
        }
}

void boomBoard(int index,int changeIndex){
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (answer[index][i][j] == 'O')
            {
                // 상하좌우가운데 빈값으로 변경
                int cx = j;
                int cy = i;
                answer[changeIndex][cy][cx] = '.';
                // 범위 체크
                for (int k = 0; k < 4; k++)
                {
                    int nx = cx + m_xy[k][0];
                    int ny = cy + m_xy[k][1];

                    if (rangeCheck(nx, ny) == true)
                    {
                        answer[changeIndex][ny][nx] = '.';
                    }
                }
            }
        }
    }
    return;
}

int main()
{
    cin >>R>>C>>N;
    for (int i = 0; i < R;i++){
        cin >> board[i];
        answer[0][i] = board[i];        //기존 모양
    }

    string tmp = "";
    for (int j = 0; j < C; j++)
    {
        tmp += "O";
    }
    // 1, 3 폭탄 가득
    for (int i = 0; i < R; i++)
    {
        answer[1][i] = tmp;     // 가득
        answer[2][i] = tmp;     //새로운 모양
        answer[3][i] = tmp;     //가득
        answer[4][i] = tmp;
    }

    boomBoard(0, 2);
    boomBoard(2, 4);
    if (N == 1)
    {
        answerPrint(0);
    }
    else if (N % 2 == 0)
    {
        answerPrint(1);
    }
    else if (N % 4 == 3)
    {
        answerPrint(2);
    }
    else if (N % 4 == 1)
    {
        answerPrint(4);
    }

    return 0;
}
