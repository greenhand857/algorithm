package ZuoShen.Class02;

import java.util.Stack;

public class _06_TwoStackImplQueue {
    public static class TwoStackQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStackQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        // push栈向pop栈倒数据
        private void pushToPop() {
            if(stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int num){
            stackPush.push(num);
            pushToPop();
        }

        public int poll() {
            if(stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if(stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStackQueue test = new TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
