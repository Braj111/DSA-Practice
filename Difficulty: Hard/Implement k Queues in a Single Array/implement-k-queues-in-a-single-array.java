class kQueues {
    int[] arr;
    int n, k;
    int[] front;
    int[] rear;
    int[] next;
    int freeIndex;

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        for (int i = 0; i < k; i++)
            front[i] = rear[i] = -1;

        freeIndex = 0;
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;

        next[n - 1] = -1;
    }

    boolean isEmpty(int qn) {
        return (front[qn] == -1);
    }

    boolean isFull() {
        return (freeIndex == -1);
    }

    boolean enqueue(int x, int qn) {
        if (isFull())
            return false;

        int i = freeIndex;
        freeIndex = next[i];

        if (isEmpty(qn))
            front[qn] = i;
        else
            next[rear[qn]] = i;

        rear[qn] = i;
        arr[i] = x;
        next[i] = -1;

        return true;
    }

    int dequeue(int qn) {
        if (isEmpty(qn))
            return -1;

        int i = front[qn];
        front[qn] = next[i];

        if (front[qn] == -1)
            rear[qn] = -1;

        next[i] = freeIndex;
        freeIndex = i;

        return arr[i];
    }
}
