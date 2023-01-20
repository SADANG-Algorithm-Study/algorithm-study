package _2023_01_14.수식최대화;

import java.util.*;

class Solution {
    private final String[] OP = {"+", "-", "*"};

    private long[] numbers;
    private String[] operators;
    private boolean[] select = new boolean[OP.length];
    private Map<String, Integer> order = new HashMap<>();

    public long solution(String expression) {
        numbers = Arrays.stream(expression.split("[+\\-*]"))
                .mapToLong(Long::parseLong)
                .toArray();
        operators = expression.split("[0-9]+");

        return findMaxResult(OP.length);
    }

    private Long findMaxResult(int priority) {
        long result = 0L;

        if(priority <= 0) {
            return calculate();
        }

        for(int i = 0; i < OP.length; i++) {
            if(select[i]) continue;
            select[i] = true;
            order.put(OP[i], priority);
            result = Math.max(result, findMaxResult(priority - 1));
            select[i] = false;
        }
        return result;
    }

    private Long calculate() {
        Stack<Long> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();

        numStack.push(numbers[0]);
        for(int i = 1; i < numbers.length; i++) {
            Long num = numStack.pop();
            while (!opStack.isEmpty()
                    && order.get(operators[i]) <= order.get(opStack.peek())) {
                num = calculate(numStack.pop(), num, opStack.pop());
            }
            numStack.push(num);
            numStack.push(numbers[i]);
            opStack.push(operators[i]);
        }

        Long result = numStack.pop();
        while(!opStack.isEmpty()) {
            result = calculate(numStack.pop(), result, opStack.pop());
        }

        return Math.abs(result);
    }

    private Long calculate(Long n1, Long n2, String op) {
        switch(op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            default:
                return 0L;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
