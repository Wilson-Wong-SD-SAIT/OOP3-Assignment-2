package utilities;

import java.io.Serializable;


public class MyDLLNode<E> implements Serializable
{
	private static final long serialVersionUID = -3278755004553223701L;
	private E element;
	private MyDLLNode<E> prev, next;
	
	public MyDLLNode(E elem)
	{
		this.element = elem;
		this.prev = null;
		this.next = null;
	}
	
	public MyDLLNode(E elem, MyDLLNode<E> prev, MyDLLNode<E> next)
	{
		this.element = elem;
		this.prev = prev;
		this.next = next;
	}
	
	/**
	 * Method to return the value of element.
	 * 
	 * @return element the element of the node.
	 */
	public E getElement()
	{
		return element;
	}

	/**
	 * Method to set the value of element.
	 * 
	 * @param element the new element of the node.
	 */
	public void setElement( E element )
	{
		this.element = element;
	}

	/**
	 * Method to return the value of next.
	 * 
	 * @return reference to the next node, null if there's no next node.
	 */
	public MyDLLNode<E> getNext()
	{
		return next;
	}

	/**
	 * Method to set the value of next.
	 * 
	 * @param next reference to the next node to set.
	 */
	public void setNext( MyDLLNode<E> next )
	{
		this.next = next;
	}
	
	/**
	 * Method to return the value of previous.
	 * 
	 * @return reference to the previous node, null if there's no previous node.
	 */
	public MyDLLNode<E> getPrev()
	{
		return prev;
	}

	/**
	 * Method to set the value of previous.
	 * 
	 * @param previous reference to the previous node to set.
	 */
	public void setPrev( MyDLLNode<E> prev )
	{
		this.prev = prev;
	}
}
