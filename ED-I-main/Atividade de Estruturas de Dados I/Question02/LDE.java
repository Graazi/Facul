class LDE {
    LDENode head;
    LDENode tail;
    int count;
    
    public LDE() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    
    public void insert(int value) {
        LDENode newNode = new LDENode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }
    
    public int remove(int value) {
        int removedCount = 0;
        LDENode current = head;
        LDENode prev = null;
        
        while (current != null) {
            if (current.value == value) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    prev.next = current.next;
                    current.next.prev = prev;
                }
                
                removedCount++;
                count--;
            } else {
                prev = current;
            }
            
            current = current.next;
        }
        
        return removedCount;
    }
    
    public void display() {
        LDENode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public int getCount() {
        return count;
    }
}
