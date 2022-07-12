public class LinkedListDeque<T> {
    public class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;
        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque(T x) {
        sentinel = new IntNode(null, null, null);
        sentinel.next = new IntNode(x, sentinel, sentinel);
        sentinel.prev = new IntNode(x, sentinel, sentinel);
        size = 1;
    }

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        size = 0;
    }

    public void addFirst(T x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next, sentinel);
    }

    public void addLast(T x) {
        size += 1;
        sentinel.prev = new IntNode(x, sentinel, sentinel.prev);
        IntNode p = sentinel;
        int i=0;
        while (i<size-1) {
            p = p.next;
            i += 1;
        }
        p.next = sentinel.prev;
        sentinel.prev.prev = p;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }

        return false;
    }
    public int size(){
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel;
        int i = 0;
        while (i < size) {
            p = p.next;
            System.out.print(p.item);
            System.out.print(" ");
            i += 1;
        }
        System.out.println();

    }

    public T removeFirst() {
        IntNode p = sentinel;
        if (p.next != null){
            p.next = p.next.next;
            size -= 1;
            return p.item;
        }
        return null;
    }

    public T removeLast() {
         IntNode p = sentinel;
         if (p.prev != null){
             p.prev = p.prev.prev;
             size -= 1;
             return p.item;
         }

        return null;
    }

    public T get(int index) {
        if (index > (size - 1) || index < 0) {
            return null;
        }
        int i=0;
        IntNode p = sentinel;
        p = p.next;
        while (i<index){
            p = p.next;
            i += 1;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index > (size - 1) || index < 0) {
            return null;
        }
        IntNode p = getRecursiveNode(sentinel.next, index,0);
        return p.item;

    }

    private IntNode getRecursiveNode(IntNode n, int index, int pos) {
        if (index == pos) {
            return n;
        }
        return getRecursiveNode(n.next, index, pos+1);
    }


}
