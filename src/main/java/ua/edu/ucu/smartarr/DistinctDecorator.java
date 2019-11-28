package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        decorate();
    }

    @Override
    protected void decorate(){
        super.decorate();
        int index = 0;
        Object[] array = this.getArray();
        for (int i = 0; i < array.length; i++) {
            boolean hasNoRepetitions = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    hasNoRepetitions = false;
                }
            }
            if (hasNoRepetitions) {
                array[index++] = array[i];
            }
        }
        this.setArray(Arrays.copyOf(array, index));
    }
}
