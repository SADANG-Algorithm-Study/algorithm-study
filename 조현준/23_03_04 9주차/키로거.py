testCase = int(input())
for t in range(testCase):
    tmp = list(input())
    answer = []
    stk = []
    for i in range(len(tmp)):
        if tmp[i] == "<":
            if len(answer) > 0:
               stk.append(answer.pop())
        elif tmp[i] == ">":
            if len(stk) > 0:
                answer.append(stk.pop())
        elif tmp[i] == "-":
            if len(answer) > 0:
                answer.pop()
        else:
            answer.append(tmp[i])
    # 시간초과 해결 코드
    answer.extend(reversed(stk))
    print(''.join(answer))

    '''
    시간 초과 코드
    for i in range(len(answer)):
        result += answer[i]
    while len(stk) > 0:
        result += stk.pop()
    print(result)
    '''