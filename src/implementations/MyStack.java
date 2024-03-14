package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.MyArrayList;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E>, Iterator<E> 
{

	private static final long serialVersionUID = 2357999674110532529L;
	private MyArrayList<E> stack;
	private int iteratorI = -1;

	public MyStack() 
	{
		stack = new MyArrayList<E>();
	}

	@Override
	public int size() 
	{
		return stack.size();
	}

	@Override
	public void clear() 
	{
		stack.clear();
	}

	@Override
	public boolean push(E toAdd)throws NullPointerException
	{
		return stack.add(toAdd);
	}

	@Override
	public int search(E toFind) throws NullPointerException 
	{
		if(toFind == null)
			throw new NullPointerException();
		for(int i = 0; i < stack.size(); i++) 
		{
			if(stack.get(i) == toFind) return i;
		}
		return -1;
	}

	@Override
	public E peek() throws EmptyStackException 
	{
		return stack.get(stack.size()-1);
	}

	@Override
	public E pop() throws EmptyStackException 
	{
		if(stack.isEmpty())
			throw new EmptyStackException();
		return stack.remove(stack.size()-1);
	}

	@Override
	public boolean isEmpty() 
	{
		return stack.isEmpty();
	}

	@Override
	public Iterator<E> iterator() 
	{
		return (Iterator<E>)this;
	}
	
	@Override
	public boolean hasNext() {
		if (iteratorI < stack.size() - 1 & stack.size() != 0 ) return true;
		return false;
	}

	@Override
	public E next() throws NoSuchElementException 
	{
		if (iteratorI < stack.size() - 1 & stack.size() != 0 )
		{ return stack.get(++iteratorI); }
		throw new NoSuchElementException();
	}
}
