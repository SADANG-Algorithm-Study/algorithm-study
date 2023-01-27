import re

def isDigit(str):
    try:
        tmp = float(str)
        return True
    except ValueError:
        return False

def expressionStringToList(expression):
    result = []
    numbers = re.findall(r'\d+', expression)
    opers = re.findall(r'[^0-9]+', expression)
    result.append(numbers[0])
    for i in range(len(opers)):
        result.append(opers[i])
        result.append(numbers[i + 1])
    return result

def calculate(oper, expression):
    expressionList = expressionStringToList(expression)
    for i in range(len(oper)):
        stk = []
        j = 0
        while j < len(expressionList):
            if isDigit(expressionList[j]) == True:
                leftNumber = expressionList[j]

            elif oper[i] == expressionList[j]:
                rightNumber = expressionList[j + 1]
                leftNumber = str(eval(leftNumber + oper[i] + rightNumber))
                j += 1
            else:
                stk.append(leftNumber)
                stk.append(expressionList[j])
            j += 1
        stk.append(leftNumber)
        expressionList = stk
    return int(expressionList[0])

def solution(expression):
    answer = 0
    oper = [
        ['+','-','*'],
        ['+', '*', '-'],
        ['-', '+', '*'],
        ['-', '*', '+'],
        ['*', '-', '+'],
        ['*', '+', '-'],
    ]
    for i in range(len(oper)):
        result = calculate(oper[i], expression)
        answer = max(answer, abs(result))
    return answer



print(solution("100-200*300-500+20"))
