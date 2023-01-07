terms_dic = {}

def dateCalc(term_type, date):

    date_split = date.split('.')
    year = date_split[0]
    month = date_split[1]
    day = date_split[2]

    calc_month = int(month) + int(terms_dic[term_type])
    calc_year = int(year)

    while calc_month > 12:
        calc_month -= 12
        calc_year += 1

    result = str(calc_year) + '.' + str(calc_month) + '.' + day

    return result

def removeCheck(today, calc_date):
    today_tmp = today.split('.')
    calc_date_tmp = calc_date.split('.')

    today_year = int(today_tmp[0])
    today_month = int(today_tmp[1])
    today_day = int(today_tmp[2])

    calc_date_year = int(calc_date_tmp[0])
    calc_date_month = int(calc_date_tmp[1])
    calc_date_day = int(calc_date_tmp[2])

    if today_year < calc_date_year:
        return False
    elif today_year == calc_date_year:
        if today_month < calc_date_month:
            return False
        elif today_month == calc_date_month:
            if today_day < calc_date_day:
                return False
            else:
                return True
        else:
            return True

    else:
        return True


    return True


def solution(today, terms, privacies):
    global terms_dic
    answer = []

    terms_dic = {}
    for i in range(len(terms)):
        tmp = terms[i].split()
        terms_dic[tmp[0]] = tmp[1]

    for i in range(len(privacies)):
        tmp = privacies[i].split()
        calc_date = dateCalc(tmp[1],tmp[0])
        if removeCheck(today, calc_date) == True:
            answer.append(i + 1)


    return answer