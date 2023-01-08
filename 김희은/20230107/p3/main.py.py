def solution(today, terms, privacies):
    dct_term = {}
    answer = []
    ty,tm,td = [int(v) for v in today.split('.')]
    tt = ty*12*28+tm*28+td

    def check(p):
        y,m,d = [int(v) for v in p[:-2].split('.')]
        id = p[-1]
        st=y*12*28+m*28+d
        t = dct_term[id]
        ed = st+t*28
        # print(id,ed,tt)
        return ed<=tt
    
    # update terms dict.
    for t in terms:
        id, m = t.split(' ')
        dct_term[id]=int(m)
        # print(id, m)

    for i,p in enumerate(privacies):
        if check(p):
            answer+=[i+1]
    return answer
