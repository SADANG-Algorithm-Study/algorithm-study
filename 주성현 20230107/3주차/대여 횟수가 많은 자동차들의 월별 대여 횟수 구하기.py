if __name__ == "__main__":
    n = 15
    dx = [0] * (n+1)
    cnt = 0
    for i in range(1, n+1):
        a_sum = 0
        for j in range(i, n+1):
            a_sum += j
            if(a_sum == n):
                cnt += 1
                break
            elif(a_sum > n):
                break
    print(cnt)