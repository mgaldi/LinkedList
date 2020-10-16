public class LinkedList<E> {
    Node<E> head;
    int size;
    public LinkedList () {
        head = null;
        size = 0;
    }
    private static class Node<E>{
       E data;
       Node<E> next;
        public Node(E value){
            data = value;
            next = null;
        }
    }

    public void add(E item){
        Node<E> node = new Node<E>(item);
        if(size == 0){
            head = node;
        }else {
            Node <E> curr = head;
            for(int i = 0; i < size - 1; i++){
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }
    public void add(E item, int position) throws Exception{
        if(position < 0 && position > size - 1)
            throw new Exception("Error");

        Node<E> node = new Node<E>(item);
        if(position == 0){
            node.next = head;
            head = node;
        }else {
            Node<E> curr = head;
            for (int i = 0; i < position - 1; i++) {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
        }
        size++;
    }
    public E get(int position) throws Exception{
        if(position < 0 && position >= size)
            throw new Exception("Error");

        Node<E> node = head;
        for(int i = 0; i < position; i ++){
            node = node.next;
        }
        return node.data;
    }
    public E remove(int position){
        if(position == 0){
            Node<E> node = head;
            head = head.next;
            --size;
            return node.data;
        }else {
            Node<E> prev = head;
            for (int i = 0; i < position - 1; i++) {
                prev = prev.next;
            }
            Node<E> node = prev.next;
            prev.next = node.next;
            --size;
            return node.data;
        }
    }

    public Node<E> reverse(Node<E> head){
        Node<E> curr = head;
        Node<E> prev = null;
        Node<E> next = null;
        for(int i = 0; i < size; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        try {
            for (int i = 0; i < list.size; i++) {
                Integer a = list.get(i);
                System.out.println("Element " + a);
            }
            System.out.println("BREAK");
            list.head = list.reverse(list.head);
            for (int i = 0; i < list.size; i++) {
                Integer a = list.get(i);
                System.out.println("Element " + a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
