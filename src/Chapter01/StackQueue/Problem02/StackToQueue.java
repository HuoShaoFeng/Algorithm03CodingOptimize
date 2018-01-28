package Chapter01.StackQueue.Problem02;

import java.util.Stack;

/**
 * 两个栈 实现 一个队列
 */
public class StackToQueue {

    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    StackToQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(Integer value){
        stackPush.push(value);
    }

    public int poll() throws Exception {
        if(stackPush.isEmpty() && stackPop.isEmpty())
            throw new Exception("Queue is empty");

        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    public int peek() throws Exception {
        if(stackPush.isEmpty() && stackPop.isEmpty())
            throw new Exception("Queue is empty");

        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();

    }

}
