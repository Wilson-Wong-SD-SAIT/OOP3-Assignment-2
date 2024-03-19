/**
 * 
 */
package implementations;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;


/**
 * 
 */
class MyStackTests 
{
	private MyStack<String> obj1;
	private MyStack<String> obj2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception 
	{
		obj1 = new MyStack<String>();
		obj2 = new MyStack<String>();
	}

	/**
	 * Test method for {@link implementations.MyStack#size()}.
	 */
	@Test
	void testSize() 
	{
		assertEquals(0, obj1.size());
	}

	/**
	 * Test method for {@link implementations.MyStack#clear()}.
	 */
	@Test
	void testClear() 
	{
		obj1.push("A");
		obj1.clear();
		assertEquals(0, obj1.size());
	}

	/**
	 * Test method for {@link implementations.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() 
	{
		obj1.push("A");
		assertEquals("A", obj1.peek());
	}

	/**
	 * Test method for {@link implementations.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() 
	{
		obj1.push("B");
		obj1.push("A");
		assertEquals(1, obj1.search("B"));
		assertEquals(0, obj1.search("A"));
	}

	/**
	 * Test method for {@link implementations.MyStack#peek()}.
	 */
	@Test
	void testPeek() 
	{
		obj1.push("B");
		assertTrue(obj1.push("A"));
		assertEquals(2, obj1.size());
		assertEquals("A", obj1.peek());
	}

	/**
	 * Test method for {@link implementations.MyStack#pop()}.
	 */
	@Test
	void testPop() 
	{
		obj1.push("A");
		obj1.push("B");
		obj1.pop();
		assertEquals(1, obj1.size());
		assertEquals("A", obj1.peek());
	}

	/**
	 * Test method for {@link implementations.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() 
	{
		obj1.push("A");
		obj1.pop();
		assertTrue(obj1.isEmpty());
	}

	/**
	 * Test method for {@link implementations.MyStack#iterator()}.
	 */
	@Test
	void testIteratorEmpty() 
	{
		Iterator<String> it = obj1.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> it.next());
	}
	
	/**
	 * Test method for {@link implementations.MyStack#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() 
	{
		obj1.push("A");
		obj1.push("B");
		Iterator<String> it = obj1.iterator();
		assertTrue(it.hasNext());
		assertEquals("A", it.next());
		assertEquals("B", it.next());
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> it.next());
	}

}
