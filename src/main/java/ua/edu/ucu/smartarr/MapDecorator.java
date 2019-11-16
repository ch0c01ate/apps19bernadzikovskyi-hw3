package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);

        for (int i = 0; i < this.getArray().length; i++) {
            this.getArray()[i] = func.apply(this.getArray()[i]);
        }
    }
}
