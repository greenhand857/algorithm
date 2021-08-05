package ZuoShen.Class02;

import java.util.LinkedList;
import java.util.Queue;

public class _07_TwoQueueImplStack {

    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T val) {
            queue.offer(val);
        }

        public T poll() {
            while (queue.size() > 1){
                help.offer(queue.poll());
            }
            T res = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return res;
        }

        public T peek(){
            while (queue.size()>1){
                help.offer(queue.poll());
            }
            T res = queue.peek();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            help.offer(res);
            return res;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }


    }
}
