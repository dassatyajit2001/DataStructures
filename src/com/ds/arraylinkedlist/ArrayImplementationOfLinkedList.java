package com.ds.arraylinkedlist;

import java.util.Arrays;

/**
 * This class is an array implementation of Linkedlist It supports operation
 * such as add, add at a given position, remove and remove at a given position.
 * This data structure can self grow and reduce in size
 * 
 * @author satyajitdas
 *
 */
public class ArrayImplementationOfLinkedList {

	public static void main(String[] args) {
		ArrayLinkList arrayLinkList = new ArrayLinkList();
		arrayLinkList.addElement(1);
		arrayLinkList.addElement(1);
		arrayLinkList.addElement(3, 1);
		arrayLinkList.addElement(4, 1);
		arrayLinkList.addElement(4, 3);
		arrayLinkList.addElement(6, 3);
		arrayLinkList.addElement(6, 10);
		arrayLinkList.addElement(7, 6);
		arrayLinkList.removeElement();
		arrayLinkList.removeElement();
		arrayLinkList.removeElement(3);
		arrayLinkList.removeElement(0);
		arrayLinkList.removeElement(2);
		arrayLinkList.addElement(6, 10);
		arrayLinkList.addElement(6, 10);
		arrayLinkList.addElement(6, 3);
		arrayLinkList.removeElement(0);
	}

}

class ArrayLinkList {

	int arr[], defaultSize = 5, currentSize = -1;

	/**
	 * Create a linklist with given size
	 * 
	 * @param size
	 */
	public ArrayLinkList(int size) {
		this.arr = new int[size];
		this.defaultSize = size;
	}

	/**
	 * create a linklist with default size 5
	 * 
	 * @param size
	 */
	public ArrayLinkList() {
		this.arr = new int[defaultSize];
	}

	/**
	 * add an element to the linklist
	 * 
	 * @param x
	 * @return
	 */
	public void addElement(int x) {
		increaseArraySize();
		arr[++currentSize] = x;
		displayAll();
	}

	/**
	 * This method adds an element at a given position
	 * 
	 * @param val
	 * @param pos
	 */
	public void addElement(int val, int pos) {
		increaseArraySize();
		// the below logic is to avoid any gap in allocation
		if (pos > currentSize) {
			arr[++currentSize] = val;
		} else {
			addAndShiftElements(val, pos);
		}
		displayAll();
	}

	/**
	 * adds an element to a given position and shifts the elements to the right if
	 * required
	 * 
	 * @param val
	 * @param pos
	 */
	private void addAndShiftElements(int val, int pos) {
		// shift all the elements present by 1 to the right
		System.arraycopy(arr, pos, arr, pos + 1, currentSize - pos + 1);
		arr[pos] = val;
		++currentSize;
	}

	/**
	 * This evaluates the size of array if the size is full then it grows the array
	 * to double the size
	 */
	private void increaseArraySize() {
		if (currentSize + 1 == defaultSize) {
			defaultSize *= 2;
			arr = Arrays.copyOf(arr, defaultSize);
		}
//		decreaseArraySize();
	}

	/**
	 * This evaluates the size of array if the size is full then it decreases the
	 * array to double the size
	 */
	private void decreaseArraySize() {

		if (defaultSize > 5 && currentSize * 2 < defaultSize) {
			defaultSize /= 2;
			int[] arrTemp = arr;
			arr = new int[defaultSize];
			System.arraycopy(arrTemp, 0, arr, 0, defaultSize);
		}
	}

	/**
	 * Displays the elements in a linkedlist
	 */
	public void displayAll() {
		System.out.println();
		Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
		System.out.print(": defaultSize=" + defaultSize + ", " + "currentSize=" + currentSize);
	}

	/**
	 * Removes an element from the linklist. It removes the element from the tail
	 * 
	 * @param x
	 * @return
	 */
	public void removeElement() {
		increaseArraySize();
		arr[currentSize--] = 0;
		decreaseArraySize();
		convertToDefault();
		displayAll();
	}

	/**
	 * Removes the element at a given position and shifts the other elements back by 1 position
	 * @param pos
	 */
	public void removeElement(int pos) {
		arr[pos] = 0;
		int endElementPos = -1;
		endElementPos = findFinalPosition(pos);
		System.arraycopy(arr, pos + 1, arr, pos, endElementPos);
		--currentSize;
		convertToDefault();
		decreaseArraySize();
		displayAll();
	}

	private int findFinalPosition(int pos) {
		int endElementPos;
		if (currentSize - pos + 1 >= arr.length) {
			endElementPos = currentSize - 1;
		} else {
			endElementPos = currentSize - pos + 1;
		}
		return endElementPos;
	}

	/**
	 * This method converts to default value after the arraysize decreases.
	 */
	private void convertToDefault() {
		for (int i = 0; i < arr.length; i++) {
			if (i > currentSize) {
				arr[i] = 0;
			}
		}
	}
}
