package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

public class FilterDecorator extends SmartArrayDecorator {

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        int index = 0;
        for (int i = 0; i < this.getArray().length; i++) {
            if (pr.test(this.getArray()[i])) {
                this.getArray()[index++] = this.getArray()[i];
            }
        }
        this.setArray(Arrays.copyOf(this.getArray(), index));
    }
}
