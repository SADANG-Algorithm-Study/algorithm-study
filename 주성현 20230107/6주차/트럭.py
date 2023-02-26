from collections import deque

if __name__ == "__main__":
    n, w, l = map(int, input().split())
    a = deque(map(int, input().split()))
    time = 0
    bridge = deque([0] * w)
    while(a):
        bridge.popleft()
        if len(bridge) < w and sum(bridge) + a[0] <= l:
            bridge.append(a.popleft())
        else:
            bridge.append(0)
        time += 1
    time += w
    print(time)