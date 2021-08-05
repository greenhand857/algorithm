package ZuoShen.Class02;

import java.util.Stack;

public class _05_GetMinStack {
//    实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
//
//    1）pop、push、getMin操作的时间复杂度都是 O(1)。
//
//    2）设计的栈类型可以使用现成的栈结构。


    // 算法思路：准备两个栈 同进同出 min栈每次压入最小值
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int num){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(num);
            }
            this.stackData.push(num);
            int minVal = num < this.stackMin.peek() ? num : this.stackMin.peek();
            this.stackMin.push(minVal);
        }

        public int pop() {
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your Stack is Empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getmin() {
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your Stack is Empty");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        System.out.println(stack.getmin());
        stack.push(4);
        System.out.println(stack.getmin());
        stack.push(1);
        System.out.println(stack.getmin());
        System.out.println(stack.pop());
        System.out.println(stack.getmin());
    }
}
