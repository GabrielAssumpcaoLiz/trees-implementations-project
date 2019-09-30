package br.univille.estd.tree;

import java.util.Iterator;

/*
 *  arvore onde os nodos podem ter uma quantidade arbitraria de filhos.
 * */
public class Tree<E> {
	
	private int size;
	private Position<E> root;
	
	/** Retorna a raiz da arvore. */
	public Position<E> root() throws EmptyTreeException{
		return root;
	}
	
	/** Retorna o pai de um dado nodo. */
	public Position<E> parent(Position<E> position) throws  BoundaryViolationException{
		if(position.getParent() == null) {
			throw new InvalidPositionException("Position Null");
			}
		return position.getParent();
	}
	
	/** Retorna uma colection iteravel dos filhos de um dado nodo. */
	public Iterator<Position<E>> children(Position<E> position)  throws InvalidPositionException {
		if(position == null) {
			throw new InvalidPositionException("Position Null");			
		}
		return position.getChildren();
	}
	
	/** Retorna se um dado nodo é interno. */
	public boolean isInternal(Position<E> position) throws InvalidPositionException  {
		
		if(position == null) {
			throw new InvalidPositionException("Position null");			
		}
		return position.size() > 0;
	}
	
	/** Retorna se um dado nodo é externo. */
	public boolean isExternal(Position<E> position)  throws InvalidPositionException {
		
		return !isInternal(position);
	}
	
	/** Retorna se um dado nodo é a raiz da arvore. */
	public boolean isRoot(Position<E> position) throws InvalidPositionException   {
		
		if(position == null) {
			throw new InvalidPositionException("Position null");
		}
			return root.equals(position);		
	}

	/** Retorna a quantidade de nodos da arvore. */
	public int size() {				
		
		return size;
	}
	
	/** Retorna se a arvore esta vazia. */
	public boolean isEmpty() {
		
		return size == 0;		
		/*
		if( size == 0) {			
			return true;
		}else {
			return false;
		}		
		*/
	}

	/** Retorna uma colection iteravel dos nodos. */
	public Iterator<Position<E>> positions(){
		return root.getChildren();
	}
	
	/** Substitui o elemento armazenado em um dado nodo. */
	public E replace(Position<E> position, E element) throws InvalidPositionException {	
		
		if (position == null) {
			throw new InvalidPositionException("Position Null");
		}
		position.setElement(element);
		return element;
	}
	
	/**
	 * Adiciona a raiz em uma arvore vazia
	 * @param element
	 */
	public Position<E> addRoot(E element) throws NonEmptyTreeException {
		
		if(root != null) {
			throw new NonEmptyTreeException("Já existe um root");
		}
		size++;
		 root = new Position<E>(element);
		return root;
	}
	
	/** Adicione um filho no nodo */
	public Position<E> addChild(Position<E> parent, E element) throws InvalidPositionException{
		if(parent == null) {
			throw new InvalidPositionException("Position Null");
		}
		size++;
		return parent.addChild(element);
	}
	
}
