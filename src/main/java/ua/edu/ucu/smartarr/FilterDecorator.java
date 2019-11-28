package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

public class FilterDecorator extends SmartArrayDecorator {

    MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }

    @Override
    protected void decorate(){
        super.decorate();
        Object[] array = this.getArray();

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (pr.test(array[i])) {
                array[index++] = array[i];
            }
        }
        this.setArray(Arrays.copyOf(array, index));
    }
}
