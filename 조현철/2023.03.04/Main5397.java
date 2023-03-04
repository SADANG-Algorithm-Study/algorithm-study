package Alog;


import java.util.Scanner;
import java.util.Stack;

public class Main5397 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			String str;
			N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
                str = sc.next();
				String result = sol(str);
                System.out.println(result);
			}
	}

	private static String sol(String str) {
        StringBuffer res = new StringBuffer("");
        Stack<Character> A = new Stack<>();
        Stack<Character> B = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<'){
                if(!A.isEmpty()){
                    B.push(A.pop());
                }
            }else if(str.charAt(i) == '>'){
                if(!B.isEmpty()){
                    A.push(B.pop());
                }
            }else if(str.charAt(i) == '-'){
                A.pop();
            }else{
               A.push(str.charAt(i)); 
            }
        }


        while (true) {
            if (!A.isEmpty()) {
        			B.push(A.pop());
    		}
            else {
				break;
			}
		}

        while (true) {
            if (!B.isEmpty()) {
        			res.append(B.pop());
    		}
            else {
				break;
			}
		}
		return res.toString();
	}
}
