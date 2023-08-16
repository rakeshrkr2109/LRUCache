// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class Main {
  public static void main(String[] args) {
      System.out.println("Hello, World!");
            LRUCache lruCache = new LRUCache(5);
            lruCache.add(1);
            lruCache.add(2);
            lruCache.add(3);
            lruCache.add(4);
            int val1 = lruCache.get(1);
            System.out.println(val1);
            lruCache.add(5);
            lruCache.add(6);
            int val = lruCache.get(1);
            System.out.println(val);
  }

  static class Node{
    int val;
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

  interface Cache{
    void add(int val);
    int get(int val);
  }

  public static class LRUCache implements Cache{
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
        }else{
            if(map.containsKey(val)){
                Node node = map.get(val);
                shiftAtEnd(node);
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
        System.out.println("Adding " + val );
    }
    
    public int get(int val){
        if(map.containsKey(val)){
            shiftAtEnd(map.get(val));
            return map.get(val).val;
        }else{
            System.out.println("Not found " + val);
            return -1; //-1 mean doesn't exists
        }
    }

    public void deleteNode(Node node){
        map.remove(node.val);
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
            next.prev = pre;
        }
    }

    public void addAtEnd(Node node){
        tail.next = node;
        tail = node;
    }
    
    public void shiftAtEnd(Node node){
        
        Node prev = node.prev;
        Node next = node.next;
        
        if(next != null && prev != null){
            prev.next = next;
            next.prev = prev;
        }
        
        tail.next = node;
        node.prev = tail;
        
        tail = node;
    }
    
    public void deleteAtFirst(){
        map.remove(head.val);
        if(head.next == null){
            head = null;
        }else{
            Node next = head.next;
            head = next;
            head.prev = null;
        }
    }

  }
}
