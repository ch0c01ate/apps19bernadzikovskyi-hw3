package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator {
    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        Arrays.sort(this.getArray(), cmp);
    }
}
