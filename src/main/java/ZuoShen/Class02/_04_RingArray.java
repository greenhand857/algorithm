package ZuoShen.Class02;

public class _04_RingArray {
    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;    // 记录当前容量
        private final int limit;

        public MyQueue(int l){
            arr = new int[l];
            pushi = 0;
            polli = 0;
            size = 0;
            limit = l;
        }

        public void push(int val){
            if(size == limit){
                throw new RuntimeException("栈满了，不能再加了");
            }
            size++;
            arr[pushi] = val;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0) {
                throw new RuntimeException("栈空了，不能再弹了");
            }
            size--;
            int res = arr[polli];
            polli = nextIndex(polli);
            return res;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int i){
            return i<limit - 1 ? i+1 : 0;
        }
    }
}
