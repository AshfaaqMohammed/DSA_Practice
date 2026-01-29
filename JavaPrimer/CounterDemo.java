package JavaPrimer;

public class CounterDemo {
    public static void main(String[] args) {
        Counter c;                          // declares a variable; no counter yet constructed
        c = new Counter();
        c.increment();
        c.increment(3);
        int temp = c.getCount();
        c.reset();
        Counter d = new Counter(5);
        d.increment();
        Counter e = d;                      // assigns e to reference the same object as d
        temp = e.getCount();                // will be 6 (as e and d reference the same counter)
        e.increment(2);               // value of e (also known as d) becomes 8

        System.out.println(c.getCount());
        System.out.println(d.getCount());
        System.out.println(e.getCount());
    }
}

/*
    ^ - line number 5 - c is a variable of type counter, but it does not create a Counter instance
    ^ - Class are known as reference types, c - is a reference variable.
    ^ - new operator returns a reference to newly created instance
    Three events occur as part of creation of new instance of class
         - A newobject is dynamically allocated in memory, and all instance variables
           are initialized to standard default values. The default values are null for
           reference variables and 0 for all base types except boolean variables (which
           are false by default).
        - The constructor for the new object is called with the parameters specified.
          The constructor may assign more meaningful values to any of the instance
          variables, and perform any additional computations that must be done due to
          the creation of this object.
        - After the constructor returns, the new operator returns a reference (that is, a
          memory address) to the newly created object. If the expression is in the form
          of an assignment statement, then this address is stored in the object variable,
          so the object variable refers to this newly created object
 */
