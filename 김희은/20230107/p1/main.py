def solution(numbers, k):
    answer = 0
    N = len(numbers)
    idx = (2*(k-1))%N
    answer =numbers[idx]
    return answer
