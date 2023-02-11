from collections import deque
import math

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(x, y):
    dq = deque()
    dq.append((x, y))
    uni = [(x, y)]
    ch[x][y] = True
    val = arr[x][y]

    while(dq):
        x, y = dq.popleft()
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if(0<=xx<n and 0<=yy<n and ch[xx][yy] == True):
                if(l<= arr[xx][yy] <= r):
                    uni.append((xx, yy))
                    ch[xx][yy] = True
                    dq.append((xx, yy))
                    val += arr[xx][yy]
    for x, y in uni:
        arr[x][y] = math.floor(val / len(uni))
    return len(uni)

if __name__ == "__main__":
    n, l, r = map(int, input().split())
    arr = []
    for _ in range(n):
        a, b = map(int, input().split())
        # arr.append(list(map(int, input().split())))
        arr.append([a, b])
        print(a, b)
    res = 0
    while(True):
        ch = [[False] * n for _ in range(n)]
        flag = False
        for i in range(n):
            for j in range(n):
                if(bfs(i, j) > 1):
                    flag = True
        if(flag == False):
            break
        res += 1
    print(res)
