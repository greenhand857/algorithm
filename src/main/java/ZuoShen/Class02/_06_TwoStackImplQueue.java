package ZuoShen.Class02;

import java.util.Stack;

public class _06_TwoStackImplQueue {
    // 算法思路：从pop()栈中弹出元素，只有当pop栈为空时，才可以将push栈中的元素倒入pop栈中
    // 且必须一次性导出所有元素
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
