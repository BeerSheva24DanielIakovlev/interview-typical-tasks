package telran.interview;

import java.util.Stack;
import java.util.EmptyStackException;

public class MyStackInt {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int num) {
        mainStack.push(num);

        if (maxStack.isEmpty() || num >= maxStack.peek()) {
            maxStack.push(num);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = mainStack.pop();

        if (poppedValue == maxStack.peek()) {
            maxStack.pop();
        }
        return poppedValue;
    }

    public int peek() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int getMaxElement() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }
}
