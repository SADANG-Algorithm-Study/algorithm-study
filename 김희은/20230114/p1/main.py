def solution(msg):
    answer = []
    dic = {}
    
    def init():
        v0 = ord('A')
        for i in range(1,27):
            dic[chr(v0+i-1)] = i
        return
    
    ## start
    n = len(msg)
    init()

    num_st = 27
    pos_st = 0
    while pos_st!=n:
        for pos_ed in range(pos_st, n+1)[::-1]:
            w = msg[pos_st:pos_ed]
            if w not in dic:
                continue
            #print(pos_st, pos_ed, w, dic[w])
            answer.append(dic[w])
            if pos_ed+1<n:
                wc = msg[pos_st:pos_ed+1]
                if wc not in dic:
                    dic[wc]=num_st
                num_st+=1
            pos_st = pos_ed            
            break
    
    return answer