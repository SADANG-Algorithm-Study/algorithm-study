
if __name__ == "__main__":
    r, c, n = map(int, input().split())
    arr = []
    for _ in range(r):
        a = input()
        a = list(a)
        # print(a)
        arr.append(a)
    # print(arr)
    r = 6
    c = 7
    n = 2
    arr = [['.','.','.','.','.','.','.'],
           ['.', '.', '.', '.', '.', '.', '.'],
           ['.', '.', 'O', '.', '.', '.', '.'],
           ['.', '.', '.', '.', '.', '.', '.'],
           ['.', '.', '.', '.', 'O', '.', '.'],
           ['.', '.', '.', '.', '.', 'O', '.']
           ]
    eal = [['0'] * c for _ in range(r)]

    bomb = []
    for i in range(r):
        for j in range(c):
            if (arr[i][j] == 'O'):
                bomb.append((j, i))

    if(n%2 == 1):
        for i in range(r):
            for j in range(c):
                print(eal[i][j], end ="")
            print()
    else:
        if(n%4 != 0):
            for i in range(r):
                for j in range(c):
                    # print((i, j))
                    # print(arr[i][j], end ="")
                    for x, y in bomb:
                        if(x==i and y==j):
                            print('.', end = "")
                            break
                        elif(x==i-1 and y==j):
                            print('.', end ="")
                            break
                        elif(x==i+1 and y==j):
                            print('.', end="")
                            break
                        elif(x==i and y==j-1):
                            print('.', end="")
                            break
                        elif(x==i and y==j+1):
                            print('.', end="")
                            break
                    else:
                        print('O', end ="")
                print()
        else:
            #4일경우
            for i in range(r):
                for j in range(c):
                    if((i, j) in bomb):
                        print('O', end="")
                    else:
                        print('.', end="")
                    # for x, y in bomb:
                    #     if(x==i and y==j):
                    #         print('O', end="")
                    #     else:
                    #         print('.', end="")
                print()
