dic = {}

# 알파벳 (A ~ Z) 딕셔너리 초기화 함수
def InitDic():
    global dic
    idx = 1
    for i in range(65, 65+26):
        dic[chr(i)] = idx
        idx = idx + 1

def IsExistedInDic(curStr):
    global dic
    if curStr in dic:
        return True
    else:
        return False

def solution(msg):
    global dic
    # 변수들 초기화
    answer = []
    InitDic()
    value = 27
    maxLen = len(msg)
    i = 0
    lastIndex = 1
    prevStr = msg[0] #사전에 등록된 문자를 저장한다.


    while maxLen > i:
        curStr = msg[i:lastIndex]

        #한 글자만 남아있는 상태라면
        if i == maxLen - 1:
            answer.append(dic[curStr])
            break

        # 사전안에 문자가 존재하고 lastIndex가 끝까지 도달하지 않았다면
        if IsExistedInDic(curStr) == True and lastIndex < maxLen + 1:
            prevStr = curStr
            lastIndex = lastIndex + 1
            # lastIndex가 더 이상 이동하지 못한다면
            if lastIndex == maxLen + 1:
                answer.append(dic[curStr])
                break
        # 사전안에 존재하지 않다면
        else:
            answer.append(dic[prevStr])
            dic[curStr] = value
            value = value + 1
            i = lastIndex - 1



    return answer
