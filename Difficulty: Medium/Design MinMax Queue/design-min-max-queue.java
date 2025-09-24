import java.util.*;

class SpecialQueue {

    private LinkedList<Integer> queue;
    private LinkedList<Integer> minQueue;
    private LinkedList<Integer> maxQueue;

    public SpecialQueue() {
        queue = new LinkedList<>();
        minQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public void enqueue(int x) {
        queue.offer(x);

        while (!minQueue.isEmpty() && minQueue.peekLast() > x) {
            minQueue.pollLast();
        }
        minQueue.offer(x);

        while (!maxQueue.isEmpty() && maxQueue.peekLast() < x) {
            maxQueue.pollLast();
        }
        maxQueue.offer(x);
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            int val = queue.poll();

            if (val == minQueue.peek()) {
                minQueue.poll();
            }
            if (val == maxQueue.peek()) {
                maxQueue.poll();
            }
        }
    }

    public int getFront() {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public int getMin() {
        return minQueue.isEmpty() ? -1 : minQueue.peek();
    }

    public int getMax() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peek();
    }
}
