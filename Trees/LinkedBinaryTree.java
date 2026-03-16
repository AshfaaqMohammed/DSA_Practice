package Trees;

import ListAndIteratorADT.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{
    protected static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above,Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parentNode) {
            this.parent = parentNode;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    }

    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext(){
            return posIterator.hasNext();
        }
        public E next(){
            return posIterator.next().getElement();
        }
        public void remove(){
            posIterator.remove();
        }
    }

    protected Node<E> createNode(E e,Node<E> parent,Node<E> left, Node<E> right){
        return new Node<>(e,parent,left,right);
    }
    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree(){}

    protected Node<E> validate(Position<E> p) throws IllegalStateException{
        if (!(p instanceof Node)){
            throw new IllegalStateException("Not valid poistion type");
        }
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node){
            throw new IllegalStateException("P is no longer in the tree");
        }
        return node;
    }

    public int size(){
        return size;
    }

    public Position<E> root(){
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        return node.getParent();
    }
    public Position<E> left(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        return node.getLeft();
    }
    public Position<E> right(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException{
        if (!isEmpty()){
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e,null,null,null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p,E e) throws IllegalStateException{
        Node<E> parent = validate(p);
        if (parent.getLeft() != null){
            throw new IllegalStateException("p already had a left child");
        }
        Node<E> child = createNode(e,parent,null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p,E e) throws IllegalStateException{
        Node<E> parent = validate(p);
        if (parent.getRight() != null){
            throw new IllegalStateException("p already had a right child");
        }
        Node<E> child = createNode(e,parent,null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p,E e) throws IllegalStateException{
        Node<E> node = validate(p);
        E ans = node.getElement();
        node.setElement(e);
        return ans;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> left, LinkedBinaryTree<E> right) throws IllegalStateException{
        Node<E> node = validate(p);

        if (isInternal(p)){
            throw new IllegalStateException("p must be a leaf");
        }
        size+= left.size() + right.size();
        if (!left.isEmpty()){
            left.root.setParent(node);
            node.setLeft(left.root);
            left.root = null;
            left.size = 0;
        }
        if (!right.isEmpty()){
            right.root.setParent(node);
            node.setRight(right.root);
            right.root = null;
            right.size = 0;
        }
    }

    public E remove(Position<E> p) throws IllegalStateException{
        Node<E> node = validate(p);
        if (numChildren(node) == 2){
            throw new IllegalStateException("P has 2 children");
        }
        Node<E> child = node.getLeft() == null ? node.getRight() : node.getLeft();
        if (child != null){
            child.setParent(node.getParent());
        }
        if (node == child){
            root = child;
        }else{
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()){
                parent.setLeft(child);
            }else{
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return preorder();
    }

}
