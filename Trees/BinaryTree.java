package Trees;

import ListAndIteratorADT.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface BinaryTree <E> extends Tree<E>{
    Position<E> left(Position<E> p)throws IllegalStateException;
    Position<E> right(Position<E> p)throws IllegalStateException;
    Position<E> sibling(Position<E> p)throws IllegalStateException;
}
