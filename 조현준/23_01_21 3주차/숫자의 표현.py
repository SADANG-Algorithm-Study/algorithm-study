def solution(n):
    answer = 1
    for i in range(1, (n // 2) + 1):
        total = i # 숫자 토탈 값
        j = i + 1
        while n > total:
            total = total + j # 연속 된 숫자를 더한다.
            j = j + 1 # 다음 값

        if total == n:
            answer = answer + 1

    return answer

