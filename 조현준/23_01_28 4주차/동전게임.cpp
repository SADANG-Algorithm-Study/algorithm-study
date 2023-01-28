#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

/*
1
H T T
H T T
T H H
*/

int board[3][3];
int answer = -1;
int change_board[8][3][3] = {
    {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},  // 1행
    {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}},  // 2행
    {{0, 0, 0}, {0, 0, 0}, {1, 1, 1}},  // 3행
    {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}},  // 1열
    {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}},  // 2열
    {{0, 0, 1}, {0, 0, 1}, {0, 0, 1}},  // 3열
    {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},  // 대각선
    {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}},  // 대각션
};
bool visited[8];

// answer board check
bool checkBoard(int cur_board[3][3])
{
    int ch = cur_board[0][0];
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (ch != cur_board[i][j])
            {
                return false;
            }
        }
    }
    return true;
}
// a to b board copy
void copyAtoBBoard(int aBoard[3][3], int bBoard[3][3])
{
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            bBoard[i][j] = aBoard[i][j];
        }
    }
}
// action function
void changeBoard(int cur_board[3][3],int next_board[3][3], int cur_index){
    int tmp_board[3][3];
    for (int i = 0; i < 3;i++){
        for (int j = 0; j < 3;j++){
            tmp_board[i][j] = (cur_board[i][j] + change_board[cur_index][i][j]) % 2;
        }
    }
    copyAtoBBoard(tmp_board, next_board);
    return;
}

void dfs(int cur_board[3][3], int cur_count, int cur_index){
    // 종료 조건
    if (cur_count > 8){
        return;
    }
    //정답인지 체크
    if (checkBoard(cur_board) == true){
        if (answer == -1)
        {
            answer = cur_count;
        }
        else
        {
            answer = min(answer, cur_count);
        }
        return;
    }

    //인덱스에 맞는 맵을 변경시킨다.
    int next_board[3][3];
    changeBoard(cur_board,next_board, cur_index);

    for (int i = 0; i < 8; i++)
    {
        if (visited[i] == false){
            visited[i] = true;
            dfs(next_board, cur_count + 1, i);
            visited[i] = false;
        }
    }
    return;
}

int main()
{
        int testCase;
        cin >> testCase;
        for (int t = 0; t < testCase; t++)
        {
            for (int i = 0; i < 3; i ++)
            {
                for (int j = 0; j < 3; j++)
                {
                    char ch;
                    cin >> ch;
                    if(ch == 'H'){
                        board[i][j] = 0;
                    }else{
                        board[i][j] = 1;
                    }
                }
            }

            // init
            int tmp_board[3][3];
            copyAtoBBoard(board, tmp_board);
            answer = -1;
            for (int i = 0; i < 8;i++){
                visited[i] = false;
            }

                int count = 0;
            for (int i = 0; i < 8;i++){
                visited[i] = true;
                dfs(tmp_board, count, i);
                visited[i] = false;
            }
            cout << answer << '\n';
        }

        return 0;
}