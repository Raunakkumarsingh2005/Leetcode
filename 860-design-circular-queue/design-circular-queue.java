class MyCircularQueue {
    int[] arr;
    int rear, front,size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        rear = front = -1;
        size = arr.length;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        else if (rear == -1) {
            front = front + 1;
        }

        else if (rear == size - 1) {
            rear = 0;
            arr[rear] = value;
            return true;
        }

        rear = rear + 1;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        else if (front == rear && front != -1) {
            front = rear = -1;
            return true;
        }

        else if (front == size -1) {
            front = 0;
            return true;
        }

        front = front + 1;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if (rear == -1 && front == -1) {
            return true;
        }

        return false;
    }
    
    public boolean isFull() {
        if (((rear - front == size - 1 && rear != -1)) || (rear == front - 1)) {
            return true;
        }

        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */