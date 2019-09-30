package br.univille.estd.tree;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	
	private E[] array;
	private int cursorPosition;
	
	public ArrayIterator(E[] lista) {
		this.array = lista;
	}

	@Override
	public boolean hasNext() {
		
		if (cursorPosition < array.length) {
			return true;
		}else		
			return false;
		}	

	@Override
	public E next() {
		
		E element = array[cursorPosition];
		cursorPosition = cursorPosition + 1;
		return element;
	}
}
