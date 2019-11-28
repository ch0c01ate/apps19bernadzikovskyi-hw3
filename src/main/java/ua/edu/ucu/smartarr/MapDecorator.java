package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

public class MapDecorator extends SmartArrayDecorator {

    MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
        decorate();
    }

    @Override
    protected void decorate(){
        super.decorate();
        Object[] array = this.getArray();

        for (int i = 0; i < array.length; i++) {
            array[i] = func.apply(array[i]);
        }
    }
}
