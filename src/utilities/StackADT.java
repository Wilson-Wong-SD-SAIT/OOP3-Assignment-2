package utilities;

/**
 * @param <E> The type of elements this stack holds.
 */
public interface StackADT<E> 
{
	/**
	 * Accessor method to retrieve the current element count contained 
	 * in the stack.
	 * 
	 * Preconditions: A valid StackADT object exists.
	 * 
	 * Postconditions: StackADT's size is returned.
	 * 
	 * @return The current element count.
	 */
    public int size();

}
