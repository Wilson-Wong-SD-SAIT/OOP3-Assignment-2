package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.MyArrayList;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E>, Iterator<E> 
{

	private static final long serialVersionUID = 2357999674110532529L;
	private MyArrayList<E> array;
	private int iteratorI = -1;

	public MyStack() 
	{
		array = new MyArrayList<E>();
	}

	@Override
	public void createStack() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() 
	{
		return array.size();
	}

	@Override
	public void clear() 
	{
		array.clear();
	}

	@Override
	public void push(E element)throws NullPointerException
	{
		if(element == null)
			throw new NullPointerException();
		array.add(element);
	}

	@Override
	public int search(E toFind) throws NullPointerException 
	{
		if(toFind == null)
			throw new NullPointerException();
		for(int i = 0; i < array.size(); i++) 
		{
			if(array.get(i) == toFind) return i;
		}
		return -1;
	}

	@Override
	public E peek() throws EmptyStackException 
	{
		return array.get(array.size()-1);
	}

	@Override
	public E pop() throws EmptyStackException 
	{
		E toPop = array.remove(array.size()-1);
		return toPop;
	}

	@Override
	public boolean isEmpty() 
	{
		return array.isEmpty();
	}

	@Override
	public Iterator<E> iterator() 
	{
		return (Iterator<E>)this;
	}
	
	@Override
	public boolean hasNext() {
		if (iteratorI < array.size() - 1 & array.size() != 0 ) return true;
		return false;
	}

	@Override
	public E next() throws NoSuchElementException 
	{
		if (iteratorI < array.size() - 1 & array.size() != 0 )
		{ return array.get(++iteratorI); }
		throw new NoSuchElementException();
	}
}
