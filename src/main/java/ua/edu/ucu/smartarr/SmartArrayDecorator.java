package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected Object[] array;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.setArray(smartArray.toArray());
    }

    @Override
    public Object[] toArray() {
        return this.getArray();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return this.getArray().length;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public Object[] getArray() {
        return array;
    }
}
