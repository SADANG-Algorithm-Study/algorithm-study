if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        n = int(input())
        a = list(map(int, input().split()))
        a_sum = 0
        val = a.pop()
        while (a):
            cur = a.pop()
            if(val > cur):
                a_sum += (val - cur)
            elif(val < cur):
                val = cur
        print(a_sum)





