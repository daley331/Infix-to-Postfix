public class InfixToPostfix {

    // Method to assign priorities to operators
    public static int stackPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
        }
        return -1;
    }


    // Method to convert characters to corresponding integers
    public static int convertToInteger(char c) {
        switch (c) {
            case 'A':
                return 5;
            case 'B':
                return 2;
            case 'C':
                return 6;
            case 'D':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {

        //Creating queues and stacks
        LinkedListQueue infixFormQueue = new LinkedListQueue();
        LinkedListQueue postfixFormQueue = new LinkedListQueue();
        LinkedListStackChar operatorStack = new LinkedListStackChar();
        LinkedListStackInt valueStack = new LinkedListStackInt();


        //Defining the infix expression
        String infixExpression = "(A+B-C)*(D)";
        System.out.println("Arithmetic expression in infix form: " + infixExpression);
        System.out.println();

        operatorStack.push('#'); //placeholder for the operator stack

        //putting infix expressions charcters into infix queue
        for (int i = 0; i < infixExpression.length(); i++) {
            infixFormQueue.enqueue(infixExpression.charAt(i));
        }

        //Converting infix expresion into a postfix expression
        while (!infixFormQueue.empty()) {
            char e = infixFormQueue.dequeue();
            if (stackPriority(e) > 0) {
                int priority1 = stackPriority(e);
                int priority2 = stackPriority(operatorStack.ontop());
                while (priority1 <= priority2) {
                    postfixFormQueue.enqueue(operatorStack.pop());
                    priority2 = stackPriority(operatorStack.ontop());
                }
                operatorStack.push(e);
            } else if (e == ')') {
                char temp = operatorStack.pop();
                while (temp != '(') {
                    postfixFormQueue.enqueue(temp);
                    temp = operatorStack.pop();
                }
            } else if (e == '(') {
                operatorStack.push(e);
            } else {
                postfixFormQueue.enqueue(e);
            }
        }


        //puts the the remaining elements from the operator stack in the postfix queue
        while (!operatorStack.empty()) {
            postfixFormQueue.enqueue(operatorStack.pop());
        }

        //Converting postfix expression into integers
        String postfixExpression = postfixFormQueue.toString();
        System.out.println("Arithmetic expression in postfix form: " + postfixExpression);
        System.out.println();


        //Evaluating the postfix expression using value stack
        String postfixExpressionConverted = "";
        for (int i = 0; i < postfixExpression.length() - 1; i++) {
            char tempV = postfixExpression.charAt(i);
            if (convertToInteger(tempV) > 0) {
                postfixExpressionConverted = postfixExpressionConverted + convertToInteger(tempV);
            } else {
                postfixExpressionConverted = postfixExpressionConverted + tempV;
            }
        }
        System.out.println("Numbers plugged into postfix form: " + postfixExpressionConverted);
        System.out.println();
        System.out.println("Evaulating expression...");
        System.out.println();

        for (int i = 0; i < postfixExpressionConverted.length(); i++) {
            char c = postfixExpressionConverted.charAt(i);
            if (Character.isDigit(c)) {
                valueStack.push(c - '0');
            } else {
                int v1 = valueStack.pop();
                int v2 = valueStack.pop();
                switch (c) {
                    case '+':
                        valueStack.push(v2 + v1);
                        break;
                    case '-':
                        valueStack.push(v2 - v1);
                        break;
                    case '/':
                        valueStack.push(v2 / v1);
                        break;
                    case '*':
                        valueStack.push(v2 * v1);
                        break;
                }
            }
        }
        int result = valueStack.pop();
        System.out.println("Result: " + result);
    }
}
