import java.util.Comparator;
import java.util.Arrays;
public class PriorityQueue<AnyType> {
    private int DEFAULT_CAPACITY = 11;
    private Comparator<? super AnyType> comparator;
    private Object[] queue;
    private int size = 0;
    
    public PriorityQueue(int initialCapacity, Comparator<? super AnyType> comparator) {
        if(initialCapacity <= 0) 
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    } 
    public PriorityQueue(int initialCapacity) {
        if(initialCapacity <= 0) 
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
    }
    public PriorityQueue() {
        this.queue = new Object[DEFAULT_CAPACITY];
    }
    public int size() {
        return size;
    }
    public boolean add(AnyType item) {
        return offer(item);
    }
    public AnyType poll() {
        if(queue.length == 0) return null;
        int i = --size;
        AnyType r = (AnyType) queue[0];
        AnyType s = (AnyType) queue[i];
        queue[i] = null;
        if(i != 0) {
            siftDown(0, s); 
        }
        return r;
    }
    
    private boolean offer(AnyType item) {
        if(item == null) 
            throw new NullPointerException();
        int i = size;
        if(size == queue.length) grow(i + 1);
        size = i + 1;
        
        if(i == 0) {
            queue[0] = item;
        } else {
            siftUp(i, item);
        }
        return true;
    }
    public Object[] getQueue() {
        return queue;
    }
    private final static int MAX_ARRAY_CAPACITY = Integer.MAX_VALUE;
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity;
        newCapacity += oldCapacity < 64? (oldCapacity*2) : (oldCapacity + oldCapacity >>> 1) ; 
        if(newCapacity > MAX_ARRAY_CAPACITY) {
            newCapacity = getProperCapacity(minCapacity);
        }
        queue = Arrays.copyOf(queue, newCapacity); 
    }
    private int getProperCapacity(int minCapacity) {
        if(minCapacity < 0) throw new OutOfMemoryError();
        return minCapacity > MAX_ARRAY_CAPACITY ? Integer.MAX_VALUE : MAX_ARRAY_CAPACITY;
    }
    
    private void siftDown(int k, AnyType item) {
        if(this.comparator != null) {
            siftDownUsingComparator(k, item);
        } else {
            siftDownComparable(k, item);
        }
    }

    private void siftUp(int k, AnyType item) {
        if(this.comparator != null) {
            siftUpUsingComparator(k, item);
        } else {
            siftUpComparable(k, item);
        }    
    }
    
    private void siftDownUsingComparator(int k, AnyType item) {
        int half = size >>> 1;
        while(k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if(right < size && comparator.compare((AnyType) c, (AnyType) queue[right]) > 0 ) c = queue[child = right];
            if(comparator.compare(item, (AnyType) c) <= 0) break;
            queue[k] = c;
            k = child;
        }
        queue[k] = item;
    }
    
    private void siftDownComparable(int k, AnyType item) {
        Comparable<? super AnyType> key = (Comparable<? super AnyType>) item;
        int half = size >>> 1;
        while(k < half) {
            int child =  (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if(right < size && ((Comparable<? super AnyType>)c).compareTo((AnyType) queue[right]) > 0) c = queue[child = right];
            if(key.compareTo((AnyType) c) <= 0) break;
            queue[k] = c;
            k = child; 
        }
        queue[k] = item;
    }

    private void siftUpUsingComparator(int k, AnyType item) {
        while(k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if(comparator.compare(item, (AnyType)e) >= 0) break; 
            queue[k] = e;
            k = parent;
        }
        queue[k] = item;
    }
    
    private void siftUpComparable(int k, AnyType item) {
        Comparable<? super AnyType> key = (Comparable<? super AnyType>) item;
        while(k > 0) {
            int parent = (k - 1) >>> 1; 
            Object e = queue[parent];
            if(key.compareTo((AnyType) e) >=  0) break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    } 
}
