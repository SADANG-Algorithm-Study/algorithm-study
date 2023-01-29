from itertools import permutations

def solution(expression):
    answer = 0
    
    def calc(s1,s2,op):
        ret = 0
        if op=='+':
            ret = s1+s2
        elif op=='*':
            ret = s1*s2
        elif op=='-':
            ret = s1-s2
        else:
            pass
        return ret
    
    ## toknize
    toks1 = expression.split('+')
    toks2 = []
    for tk in toks1:
        toks2+=tk.split('-')
    toks3 = []
    for tk in toks2:
        toks3+=tk.split('*')
    toks3 = [int(v) for v in toks3]
    #print(toks3)
    
    ops = []
    for s in expression:
        if s in ['+','*','-']:
            ops+=[s]
    #print(ops)

    ## set routines
    ops_unit = list(set(ops))
    cases = list(permutations(ops_unit, len(ops_unit)))

    max_v = 0
    for case in cases:
        #print(case)
        ops_srt = sorted(ops, key=lambda x:case.index(x))
        ntoks = toks3.copy()
        nops = ops.copy()
        for op in ops_srt:
            i=0
            #print(op, ntoks, nops)
            while i < len(nops):
                o = nops[i]
                v1 = ntoks[i]
                v2 = ntoks[i+1]
                if o != op:
                    i+=1
                    continue
                v3 = calc(v1,v2, o)
                ntoks[i+1]=v3
                del ntoks[i]
                del nops[i]
            #print(op, ntoks, nops)
        #print(ntoks)
        max_v = max(abs(ntoks[0]), max_v)
        answer = max_v
    return answer