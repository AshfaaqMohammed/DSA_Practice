package Trees;

import ListAndIteratorADT.Position;

import java.util.ArrayList;
import java.util.List;
import Queue.LinkedQueue;
import Queue.Queue;

public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p){
        if (isRoot(p)){
            return 0;
        }else {
            return 1 + depth(parent(p));
        }
    }

    private int heightBad(){
        int h = 0;
        for(Position<E> p : positions()){
            if (isExternal(p)){
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    public int height(Position<E> p){
        int h = 0;
        for (Position<E> c : children(p)){
            h = Math.max(h,1 + height(c));
        }
        return h;
    }

    //code for preorder traversal
    private void preorderSubtree(Position<E>p, List<Position<E>> snapshot){
        snapshot.add(p);
        for (Position<E> c : children(p)){
            preorderSubtree(c,snapshot);
        }
    }
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()){
            preorderSubtree(root(),snapshot);
        }
        return snapshot;
    }

    //coe for postorder traversal
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for (Position<E> c : children(p)){
            postorderSubtree(c,snapshot);
        }
        snapshot.add(p);
    }
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()){
            postorderSubtree(root(),snapshot);
        }
        return snapshot;
    }

    //code for Breadth first search
    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()){
            Queue<Position<E>> fringe = new LinkedQueue<Position<E>>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()){
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c : children(p)){
                    fringe.enqueue(c);
                }
            }
        }
        return snapshot;
    }

}
