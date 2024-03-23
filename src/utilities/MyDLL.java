package utilities;

public class MyDLL<E> implements ListADT<E>
{

	private static final long serialVersionUID = -1080782129422688520L;
	private MyDLLNode<E> head, tail;
	private int size;
	
	public MyDLL()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public MyDLLNode<E> getHead() 
	{
		return head;
	}

	public MyDLLNode<E> getTail() 
	{
		return tail;
	}
	
	public void addFirst(E item) throws NullPointerException 
	{
		if (item == null) throw new NullPointerException("Cannot add null element to the list.");
	    
		MyDLLNode<E> newNode = new MyDLLNode<>(item);
        
        if (isEmpty()) 
        {
            head = newNode;
            tail = newNode;
        } 
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
	}

	public void addLast(E item) throws NullPointerException 
	{
		if (item == null) throw new NullPointerException("Cannot add null element to the list.");
	    
		MyDLLNode<E> newNode = new MyDLLNode<>(item);
        
        if (isEmpty()) 
        {
            head = newNode;
            tail = newNode;
        } 
        else 
        {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
	}
	
	public E removeFirst() throws IndexOutOfBoundsException 
	{
		if (isEmpty()) throw new IndexOutOfBoundsException();
	    
		size--;
		
        E element = head.getElement();
        head = head.getNext();
        return element;
	}
	
	public E removeLast() throws IndexOutOfBoundsException 
	{
		if (isEmpty()) throw new IndexOutOfBoundsException();
	    
		size--;
		
        E element = tail.getElement();
        tail = tail.getPrev();
        return element;
	}

	public int size() 
	{
		return size;
	}

	public boolean isEmpty() 
	{
		return size < 1;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
