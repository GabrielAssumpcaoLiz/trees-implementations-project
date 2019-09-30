package br.univille.estd.tree;

import java.util.Collection;
import java.util.Iterator;

public class Position<E> {

	private E element;
	private Position<E> parent;
	private Collection<Position<E>> children;

	public Position() {
		this(null,null);
	}

	public Position(E element) {
		this(element,null);
	}

	public Position(E element, Position<E> parent) {
		setElement(element);
		setParent(parent);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Position<E> getParent() {
		return parent;
	}

	public void setParent(Position<E> parent) {
		this.parent = parent;
	}

	public Position<E> addChild(Position<E> child) {
		child.setParent(this);
		children.add(child);
		return child;
	}
	
	public Position<E> addChild(E element) {
		Position<E> ele = new Position<E>(element, this);
		children.add(ele);
		return ele;
	}

	public Position<E> removeChild(Position<E> child){
		children.remove(child);
		return null;
	}

	public Iterator<Position<E>> getChildren(){
		return children.iterator();
	}

	public int size() {	
		return children.size();
	}	
}
