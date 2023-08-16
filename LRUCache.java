// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
            LRUCache lruCache = new LRUCache(5);
            lruCache.add(1);
            lruCache.add(2);
            lruCache.add(3);
            lruCache.add(4);
            lruCache.add(5);
            int value = lruCache.get(1);
            lruCache.add(6);
            int value = lruCache.get(2);
            System.out.println(val);
    }
}

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Node{
	int val,
	Node next;
	Node prev;

	Node(int val){
	  this.val = val;
    }

    Node(int val, Node next, Node prev){
    	  this.val = val;
    	  this.next = next;
    	  this.prev = prev;
    }
}

class interface Cache{
	abstract void add(int val);
	abstract int get(int val);
}


public class LRUCache implements Cache{
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    int size;
    Node head;
    Node tail;
    
    LRUCache(int size){
        this.size = size;
    }
    
    public void add(int val){
        if(head == null){
            Node node = new Node(val);
            head = node;
            tail = node;
            map.put(val, node);
            return;
        }else{
            if(map.containsKey(val)){
                Node node = map.get(val);
                shiftAtEnd(node);
                return;
            }else{
                
                //1,2,3,4,5
                
                if(map.size() >= size){
                    deleteAtFirst();
                }
                
                Node node = new Node(val);
                addAtEnd(node);
                map.put(val, node);
                
            }
        }
    }
    
    public int get(int val){
        if(map.contains(val)){
            shiftAtEnd(map.get(val));
            return map.get(val);
        }else{
            throw Error("Not found");
        }
    }
    
    public void deleteNode(Node node){
        map.delete(node.val);
        if(node.prev == null){ //first node in the list
            head = head.next;
        }else if(node.next == null){ //last node
            Node pre = node.prev;
            pre.next = null;
            tail = pre;
        }else{
            Node pre = node.prev;
            Node next = node.next;
            pre.next = next;
            next.prev = prev;
        }
    }

    public void addAtEnd(Node node){
        tail.next = node;
        tail = node;
    }
    
    public void shiftAtEnd(Node node){
        
        Node prev = node.prev;
        Node next = node.next;
        
        if(next != null){
            prev.next = next;
        }
        
        if(prev != null){
            next.prev = prev;
        }
        
        tail.next = node;
        tail = node;
    }
    
    public void deleteAtFirst(){
        if(head.next == null){
            head = null;
            map.delete(head);
        }else{
            Node next = head.next
            head = next;
            head.prev = null;
        }
    }
}
