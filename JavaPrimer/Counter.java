package JavaPrimer;

public class Counter {
    private int count;                                         // a simple integer instance variable
    public Counter(){                                          // default constructor

    }
    public Counter(int initial){                               // an alternate constructor
        count = initial;
    }
    public int getCount(){                                     // an accessor method
        return count;
    }
    public void increment(){                                   // an update method
        count++;
    }
    public void increment(int delta){                          // an update method
        count+=delta;
    }
    public void reset(){                                       // an update method
        count=0;
    }
}
