package stacks;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
//        ArrayStack<Integer> array = new ArrayStack<>(5);
//        LinkedStack<Integer> array = new LinkedStack<>();
//
//        for (int i=0;i<5;i++){
//            array.push(i+1);
//            System.out.println(array);
//        }
//        System.out.println(array.size());
//        array.pop();
//        System.out.println(array.top());
//        System.out.println(array.size());
//        System.out.println(array);

        Integer[] array = {1,2,3,4,5};
        System.out.println(matchingDelimiters(")(()){([()])}"));

    }

    private static <E> void reverse(E[] a){
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i=0;i<a.length;i++){
            buffer.push(a[i]);
        }
        for (int i=0;i<a.length;i++){
            a[i] = buffer.pop();
        }
    }

    private static boolean matchingDelimiters(String string){
        String open = "([{";
        String close = ")]}";
        Stack<Character> buffer = new ArrayStack<>(string.length());

        for (char e : string.toCharArray()){
            if (open.indexOf(e) == -1){
                if (buffer.isEmpty()){
                    return false;
                }
                Character ele = buffer.pop();
                if (open.indexOf(ele) != close.indexOf(e)){
                    return false;
                }
            }else if (close.indexOf(e) == -1){
                buffer.push(e);
            }
        }
        return buffer.isEmpty();
    }


}
