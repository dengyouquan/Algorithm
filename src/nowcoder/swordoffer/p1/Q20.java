package nowcoder.swordoffer.p1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q20 {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int node) {
        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("the stack is empty!");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("the stack is empty!");
        }
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("the stack is empty!");
        }
        return minStack.peek();
    }
}
