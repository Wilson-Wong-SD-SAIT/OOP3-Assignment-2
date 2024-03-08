package utilities;

import java.io.Serializable;

public class MyDLLNode<E> implements Serializable
{
	private static final long serialVersionUID = -3278755004553223701L;
	private E element;
	private MyDLLNode<E> prev, next;
	
	public MyDLLNode(E elem, MyDLLNode<E> prev, MyDLLNode<E> next) 
	{
		this.element = elem;
		this.prev = prev;
		this.next = next;
	}
	
	
}
