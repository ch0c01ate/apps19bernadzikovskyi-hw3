package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator {
    MyComparator cmp;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
        decorate();
    }

    @Override
    protected void decorate(){
        super.decorate();
        Arrays.sort(this.getArray(), cmp);
    }
}
