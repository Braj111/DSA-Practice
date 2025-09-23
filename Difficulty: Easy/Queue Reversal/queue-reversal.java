class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        if (q.isEmpty()) return;
        int front = q.peek();
        q.poll();
        reverseQueue(q);
        q.add(front);
    }
}