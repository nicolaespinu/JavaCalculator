package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    static int indexList = 1;
    static List<String> itemsList;

    public static double evaluateText(String expression) {
        if (!expression.contains("(")) {
            return getResult(expression);
        } else {
            while (expression.contains("(")) {
                var indexLast = expression.indexOf(")");
                var indexFirst = expression.lastIndexOf("(", indexLast);
                expression = expression.substring(0, indexFirst)
                        + getResult(expression.substring(indexFirst + 1, indexLast).trim())
                        + expression.substring(indexLast + 1);
            }
            return getResult(expression);
        }
    }


    private static double getResult(String text) {
        itemsList = Arrays.asList(text.split(" "));

        while (itemsList.size() - 2 >= indexList) {
            if (itemsList.get(indexList).equals("*") || itemsList.get(indexList).equals("/")) {
                calculate(indexList, itemsList.get(indexList - 1), itemsList.get(indexList), itemsList.get(indexList + 1));
            } else if ((itemsList.get(indexList).equals("+") || itemsList.get(indexList).equals("-"))
                    && !itemsList.contains("*") && !itemsList.contains("/")) {
                calculate(indexList, itemsList.get(indexList - 1), itemsList.get(indexList), itemsList.get(indexList + 1));
            }
            indexList++;
        }
        return Double.valueOf(itemsList.get(0));
    }

    private static void calculate(int index, String left, String operator, String right) {
        double result = 0;
        double x = Double.valueOf(left);
        double y = Double.valueOf(right);
        switch (operator) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
        }
        itemsList.set(index - 1, String.valueOf(result));
        for (int i = index; i < itemsList.size() - 2; i++) {
            itemsList.set(i, itemsList.get(i + 2));
        }
        itemsList = itemsList.subList(0, itemsList.size() - 2);
        indexList = 0;
    }
}
