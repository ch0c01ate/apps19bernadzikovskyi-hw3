package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected Object[] array;
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        decorate();
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

    protected void decorate() {
        this.setArray(smartArray.toArray().clone());
    }
}
