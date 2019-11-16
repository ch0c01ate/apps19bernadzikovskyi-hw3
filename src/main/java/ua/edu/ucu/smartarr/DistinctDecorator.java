package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        int index = 0;
        for (int i = 0; i < this.getArray().length; i++) {
            boolean hasNoRepetitions = true;
            for (int j = i + 1; j < this.getArray().length; j++) {
                if (func.apply(this.getArray()[i]).equals(func.apply(this.getArray()[j]))) {
                    hasNoRepetitions = false;
                }
            }

            if (hasNoRepetitions) {
                this.getArray()[index++] = this.getArray()[i];
            }
        }
        this.setArray(Arrays.copyOf(this.getArray(), index));
    }
}
