import org.omg.CORBA.Object;

import java.util.Arrays;

public class StackADT<T extends Object> implements IStack<T>{
    private final int MAX_CAPACITY = 10000;
    private final int DEFAULT_CAPACITY = 100;

    private T[] stack ;
    private int numberOfElements;
    public StackADT(int initialCapacity){
        checkInitialCapacity();
        stack = (T[])new  Object[initialCapacity];
        numberOfElements = 0 ; //initially stack is empty
    }
    public StackADT()throws SecurityException{
        new StackADT(DEFAULT_CAPACITY); // create stack with empty constructor
    }
    private void checkInitialCapacity(){
        if (MAX_CAPACITY < numberOfElements){
            throw new SecurityException();
        }
    }

    @Override
    public void push(T element) {
        ensureCapacity();
        stack[numberOfElements] = element;
        numberOfElements++;
    }

    @Override
    public T pop() {
        T topElement = null;
        if (!isEmpty()) {
            topElement = stack[numberOfElements - 1];
            stack[numberOfElements - 1] = null;
            numberOfElements -- ;
        }
        return topElement;
    }

    @Override
    public T peek() {
        T topElement = null ;
        if (!isEmpty()){
            topElement = stack[numberOfElements - 1];
        }
        return topElement;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements <= 0;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
    private boolean isFull(){
        if (stack[stack.length - 1] != null){
            return true ;
        }
        return false ;
    }
    private void ensureCapacity(){
        if (isFull()){
            Arrays.copyOf(stack,stack.length * 2);
        }
    }
}
