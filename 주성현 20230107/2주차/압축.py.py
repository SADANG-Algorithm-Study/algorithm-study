def solution(msg):
    answer = []
    dic = {}
    for i in range(26):
        dic[chr(65 + i)] = i + 1
    w = 0
    c = 0
    while (True):
        c += 1
        if (c == len(msg)):
            answer.append(dic[msg[w:c]])
            break
        if (msg[w:c + 1] not in dic):
            dic[msg[w:c+1]] = len(dic) + 1
            answer.append(dic[msg[w:c]])
            w = c

    return answer