package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>
{
	private static final long serialVersionUID = -7686414727616546634L;
	private E[] array;
	private final int CAPACITY = 10;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() 
	{
		array = (E[]) new Object[CAPACITY];
		size = 0;
	}
	
	@Override
	public int size() 
	{
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		array = (E[]) new Object[CAPACITY];
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		if( toAdd == null) throw new NullPointerException();
		if( index < 0 || index > size) throw new IndexOutOfBoundsException();
		checkCapacity();
		for(int i = size ; i > index; i--) 
		{
			array[i] = array[i - 1];
		}
		array[index] = toAdd;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void checkCapacity() 
	{
		if (size == array.length) 
		{
			E[] newArray = (E[]) new Object[size * 2];
			for(int i = 0; i < array.length; i++) 
			{
				newArray[i] = array[i];
			}
			array = newArray;
		}
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		if(toAdd == null)
			throw new NullPointerException();
		checkCapacity();
		array[size++] = toAdd;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException 
	{
		if( toAdd == null || toAdd.size() == 0 ) throw new NullPointerException();
		for(int i = 0; i < toAdd.size(); i++) 
		{
			this.add(toAdd.get(i));
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException 
	{
		if( index < 0 || index > size) throw new IndexOutOfBoundsException();
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		if( index < 0 || index > size) throw new IndexOutOfBoundsException();
		
		E toRemove = array[index];
		for(int i = index ; i < size - 1; i++) 
		{
			array[i] = array[i + 1];
		}
		array[size - 1] = null;
		size--;
		return toRemove;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException 
	{
		if( toRemove == null ) throw new NullPointerException();
		int removeI = -1;
		for(int i = 0; i < size; i++) 
		{
			if(array[i] == toRemove) removeI = i;
		}
		if(removeI == -1)return null;
		return this.remove(removeI);
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException 
	{
		if( toChange == null) throw new NullPointerException();
		if( index < 0 || index > size) throw new IndexOutOfBoundsException();
		E changed= array[index];
		array[index] = toChange;
		return changed;
	}

	@Override
	public boolean isEmpty() 
	{
		if( size < 1 ) return true;
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException 
	{
		if( toFind == null) throw new NullPointerException();
		for(int i = 0; i < size; i++) 
		{
			if(array[i] == toFind) return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E[] toArray(E[] toHold) throws NullPointerException 
	{
		if( toHold == null) throw new NullPointerException();
		if (toHold.length < size) 
		{
			toHold = (E[]) (Array.newInstance(toHold.getClass().getComponentType(), size));
		}
		for(int i = 0; i < size; i++) 
		{
			toHold[i] = array[i];
		}
		if(toHold.length > size)
		{
			toHold[size] = null;
		}
		return toHold;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object[] toArray() 
	{
		E[] toReturn = (E[])(Array.newInstance(Object.class, size));
		System.arraycopy(array, 0, toReturn, 0, size());
		return toReturn;
	}


	@Override
	public Iterator<E> iterator() 
	{
		return (Iterator<E>)this;
	}
	
	private class ArrayBasedIterator implements Iterator<E>
	{
 
		private E[] copyOfElements;
		private int pos;
		
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = (E[]) new Object[size];
			System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
		}
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}
 
		@Override
		public E next() throws NoSuchElementException
		{
			if(pos == copyOfElements.length)
				throw new NoSuchElementException();
			return copyOfElements[pos++];
		}
		
	}

}
