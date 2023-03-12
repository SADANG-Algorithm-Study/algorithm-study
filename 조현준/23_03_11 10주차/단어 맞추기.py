from sys import stdin

for t in range(int(stdin.readline())):
    string = list(stdin.readline().rstrip())
    length = len(string)
    i, j = 0, 1
    # 바꿀 위치 찾는다.
    for idx in range(1, length):
        if string[idx] > string[idx - 1]:
            if i < idx:
                i = idx
    for idx in range(1, length):
        if string[idx] > string[i - 1]:
            if j < idx:
                j = idx

    if i != 0 and j != 0:
        string[i-1], string[j] = string[j], string[i-1]
        string[i:] = sorted(string[i:])
    print(''.join(string))