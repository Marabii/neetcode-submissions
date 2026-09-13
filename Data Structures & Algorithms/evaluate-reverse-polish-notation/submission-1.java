class Solution {
    public int evalRPN(String[] tokens) {
        List<String> stack = new ArrayList<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                // Handle the calculation
                Integer operand1 = Integer.parseInt(stack.removeLast());
                Integer operand2 = Integer.parseInt(stack.removeLast());
                stack.add(String.valueOf(execute(operand2, operand1, token)));
            } else {
                stack.add(token);
            }
        }

        return Integer.parseInt(stack.removeLast());
    }

    private boolean isOperator(String token) {
        switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;

            default:
                return false;
        }
    }

    private Integer execute(Integer int1, Integer int2, String operator) {
        switch (operator) {
            case "+":
                return int1 + int2;

            case "-":
                return int1 - int2;

            case "*":
                return int1 * int2;

            case "/":
                return int1 / int2;

            default:
                throw new IllegalArgumentException();
        }
    }
}
