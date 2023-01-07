def date_Convert(v):
    sum_Date = int(v[0]) * 12 * 28 + int(v[1]) * 28 + int(v[2])
    return sum_Date


def date_PlueMonth(v):
    month_Date = int(v) * 28
    return month_Date


def solution(today, terms, privacies):
    n = len(privacies)
    m = len(terms)
    today = today.split('.')
    to_Today = date_Convert(today)
    answer = []

    for i in range(n):
        v = privacies[i].split(" ")
        pri_Date = v[0].split('.')
        pri_Day = date_Convert(pri_Date)
        for j in range(m):
            terms_Split = terms[j].split(" ")
            if (v[1] == terms_Split[0]):
                co_Date = date_PlueMonth(terms_Split[1])
                cur_Date = co_Date + pri_Day
                if (to_Today >= cur_Date):
                    answer.append(i + 1)

    return answer