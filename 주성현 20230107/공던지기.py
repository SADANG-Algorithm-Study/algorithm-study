def solution(numbers, k):
    answer = numbers[0]
    n = len(numbers)
    for i in range(k - 1):
        answer = answer + 2
        if (answer > numbers[n - 1]):
            answer -= numbers[n - 1]

    return answer