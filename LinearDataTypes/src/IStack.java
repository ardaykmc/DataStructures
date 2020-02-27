public interface IStack <T>{
    /**
     * adds a new element top of the stack
     * @param element
     */
    public void push(T element);

    /**
     * remove the top element of stack
     * @return the top element of stack
     */
    public T pop();

    /**
     *
     * @return return top element
     */
    public T peek();

    /**
     *
     * @return stack empty or not
     */
    public boolean isEmpty();

    /**
     *
     * @return number of element in the stack
     */
    public int size();
}
