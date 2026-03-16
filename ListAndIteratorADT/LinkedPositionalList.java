package ListAndIteratorADT;

public class LinkedPositionalList<E>{

    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement()throws IllegalStateException{
            if (next == null){
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size=0;

    public LinkedPositionalList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalStateException{
        if (!(p instanceof Node)){
            throw new IllegalStateException("Invalid p");
        }
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null){
            throw new IllegalStateException("p is no longer in the list");
        }
        return node;
    }

    private Position<E> position(Node<E> node){
        if (node == header || node == trailer){
            return null;
        }
        return node;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Position<E> first(){
        return position(header.getNext());
    }
    public Position<E> last(){
        return position(trailer.getPrev());
    }
    public Position<E> before(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        return node.getPrev();
    }
    public Position<E> after(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        return node.getNext();
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
        Node<E> newest = new Node<>(e,pred,succ);
        pred.setNext(newest);;
        succ.setPrev(newest);
        size++;
        return newest;
    }

    public Position<E> addFirst(E e){
        return addBetween(e,header,header.getNext());
    }

    public Position<E> addLast(E e){
        return addBetween(e,trailer.getPrev(),trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalStateException{
        Node<E> node = validate(p);
        return addBetween(e,node.getPrev(),node);
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalStateException{
        Node<E> node = validate(p);
        return addBetween(e,node,node.getNext());
    }

    public E set(Position<E> p, E e) throws IllegalStateException{
        Node<E> node = validate(p);
        E ele = node.getElement();
        node.setElement(e);
        return ele;
    }

    public E remove(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        Node<E> pre = node.getPrev();
        Node<E> succ = node.getNext();

        pre.setNext(succ);
        succ.setPrev(pre);
        size--;
        E anser = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return anser;
    }
}
