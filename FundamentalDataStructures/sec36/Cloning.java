package FundamentalDataStructures.sec36;

public class Cloning {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        int[] backup;
        backup = data; //------------> warning, this is not a copy. new variable is pointing to same address.(it does not create new array
        backup = data.clone(); //-------> this is assign to new array variable.

        /*
        it does not goes same with arrays of objects cause, when we do clone, two arrays will be created indeed but object reference will be the same.
        so we shall implement deepCopy()
         */
    }

    private int[] deepClone(int[] original){
        int[] backup = new int[original.length];
        for(int i=0;i<original.length;i++){
            backup[i] = original[i]; //(originally it should be (ClassName) original[i].clone();
        }
        return backup;
    }
}
