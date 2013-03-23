package designpatterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * The Interpreter specifies how to evaluate Sentences in a language.
 * 
 * Problem: 
 * Given a language, define a representation for its grammar along with an interpreter that uses the 
 * representation to interpret sentences in the language    
 * 
 * Solution: 
 * The Interpreter design pattern maps a domain to a language, the language to a grammar, and the grammar 
 * to a hierarchical object-oriented design. In other words, it allows to implement semantics for a simple 
 * language.The Client builds a tree of Terminal and Nonterminal Expressions which represents the syntax 
 * of the language, used during parsing a sentence in that language. The Client is expected to parse the 
 * input sentence (for example to split the input to particular words of the language) and subsequently 
 * to submit them for interpretation (means processing) by concrete Expressions. Usually, the Expressions 
 * call recursively Expression on lower level.
 */
public class InterpreterExample {
    /**
     * 
     *
     * @param args 
     */
    public static void main(final String[] args) {
        String expression = "ABC+-";
        Map<String, Integer> context = new HashMap<String, Integer>();
        context.put("A", 20);
        context.put("B", 12);
        context.put("C", 3);
        Evaluator evaluator = new Evaluator(expression);
        evaluator.evaluate(context);
    }
}


interface Expression {
    int interpret(final Map<String, Integer> context);
}


class Add implements Expression {
    Expression left;
    Expression right;

    Add(final Expression left, final Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 
     *
     * @param context 
     *
     * @return 
     */
    public int interpret(final Map<String, Integer> context) {
        return right.interpret(context) + left.interpret(context);
    }
}


class Subtract implements Expression {
    Expression left;
    Expression right;

    Subtract(final Expression left, final Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 
     *
     * @param context 
     *
     * @return 
     */
    public int interpret(final Map<String, Integer> context) {
        return right.interpret(context) - left.interpret(context);
    }
}


class Variable implements Expression {
    char name;

    Variable(final char name) {
        this.name = name;
    }

    /**
     * 
     *
     * @param context 
     *
     * @return 
     */
    public int interpret(final Map<String, Integer> context) {
        return context.get(new String("" + name));
    }
}


class Evaluator {
    Expression syntaxTree;

    Evaluator(final String template) {
        char[] tokens = template.toCharArray();
        ExpressionStack stack = new ExpressionStack(tokens.length);
        for (final char token : tokens) {
            switch (token) {
            case '+':
                Expression expressionAdd = new Add(stack.pop(), stack.pop());
                stack.push(expressionAdd);
                break;
            case '-':
                Expression expressionSub = new Subtract(stack.pop(), stack.pop());
                stack.push(expressionSub);
                break;
            default:
                Expression expressionVar = new Variable(token);
                stack.push(expressionVar);
            }
        }
        syntaxTree = stack.pop();
    }

    void evaluate(final Map<String, Integer> context) {
        System.out.println(syntaxTree.interpret(context));
    }
}


class ExpressionStack {
    Expression[] array = null;
    int stackSize = 0;
    int pointer = -1;

    /**
     * Creates a new ExpressionStack object.
     *
     * @param size 
     */
    public ExpressionStack(final int size) {
        array = new Expression[size];
        stackSize = size;
    }

    /**
     * 
     *
     * @param expression 
     */
    protected void push(final Expression expression) {
        if (pointer == (stackSize - 1)) {
            System.out.println("Stack Overflow. Can't Push.");
        } else {
            array[++pointer] = expression;
        }
    }
    /**
     * 
     *
     * @return 
     */
    protected Expression pop() {
        return array[pointer--];
    }
    /**
     * 
     *
     * @return 
     */
    protected Expression peek() {
        return array[pointer];
    }
    /**
     * 
     *
     * @return 
     */
    protected boolean isNotEmpty() {
        return pointer > -1;
    }
}
