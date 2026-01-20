package hashmapsandhashfunctions;

class MyHashMap {

    // Node class for Linked List
    static class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int SIZE = 10;              // Size of bucket array
    private Node[] table;

    // Constructor
    public MyHashMap() {
        table = new Node[SIZE];
    }

    // Hash Function
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or Update (Put)
    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        // Check if key already exists
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;   // Update value
                return;
            }
            current = current.next;
        }

        // Insert new node at beginning
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    // Retrieve (Get)
    public int get(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }
        return -1; // Key not found
    }

    // Delete (Remove)
    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null)
                    table[index] = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Display HashMap
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Node temp = table[i];
            while (temp != null) {
                System.out.print("[" + temp.key + "=" + temp.value + "] -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Main Method
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 100);
        map.put(11, 200); // Collision with key 1 (same bucket)
        map.put(2, 300);

        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 11: " + map.get(11));

        map.remove(1);
        System.out.println("After removing key 1:");

        map.display();
    }
}
