package Chapter01.StackQueue;

import java.util.Stack;

public class StackWithGetMin2 {

    private Stack<Integer> dataStack;   //存储数据的栈
    private Stack<Integer> minStack;    //存储最小值的栈

    public StackWithGetMin2(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public int getMin(){
        if (minStack.isEmpty())
            throw new RuntimeException("The Stack is empty....");
        else
            return minStack.peek(); //获取栈顶元素的值，并不出栈

    }

    public void push(int num){
        //对dataStack进行操作
        dataStack.push(num);

        //对minStack操作
        if (minStack.isEmpty())
            minStack.push(num);
        else if(num <= minStack.peek())
            minStack.push(num);
        else
            minStack.push(minStack.peek());

    }

    public int pop(){
        int value = dataStack.pop();//dataStack正常出栈

        if (minStack.isEmpty())
            throw new RuntimeException("The Stack is empty....");

        minStack.pop();

        return value;
    }

}
