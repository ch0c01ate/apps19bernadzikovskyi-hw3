package ua.edu.ucu.smartarr;

public class BaseArray implements SmartArray {
    protected Object[] array;

    public BaseArray(Object[] array) {
        this.setArray(array.clone());
    }

    @Override
    public Object[] toArray() {
        return this.getArray().clone();
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return this.getArray().length;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}
