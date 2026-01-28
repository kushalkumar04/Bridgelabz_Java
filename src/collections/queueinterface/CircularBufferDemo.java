package collections.queueinterface;

/*
 * This program simulates a Circular Buffer (fixed-size queue).
 * When the buffer is full, new elements overwrite the oldest ones.
 * It uses an array and circular indexing to manage insertions.
 */
class CircularBuffer {

    private int[] buffer;
    private int size;
    private int front = 0;
    private int count = 0;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Insert element into circular buffer
    public void insert(int value) {
        int index = (front + count) % size;

        if (count == size) {
            // Buffer full: overwrite oldest, move front
            front = (front + 1) % size;
        } else {
            count++;
        }

        buffer[index] = value;
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class CircularBufferDemo {

    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // [1, 2, 3]

        cb.insert(4); // Overwrites 1
        cb.display(); // [2, 3, 4]
    }
}
