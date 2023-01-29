import math

def solution(n):
    answer = 1
    def check_cond(st,ed,n):
        return (st+ed)*(ed-st+1)/2==n
    
    for st in range(1,n):
        ed_max = int(math.sqrt(st**2-st+2*n))
        #print(ed_max)
        for ed in range(st+1,ed_max+1):
            ret = check_cond(st,ed,n)
            if ret: print(st,ed,n)
            answer+=ret
            
    return answer