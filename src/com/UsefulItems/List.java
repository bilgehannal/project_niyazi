package com.UsefulItems;

import com.Shape.Shape;

public class List {
	
	private Shape[] array; //Array is defined to keep all shapes.
	private int size;//size variable keeps the size of array.
	
	public List() {
		array = new Shape[10];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Shape get(int n){
		return array[n];
	}
	
	public void add(Shape n){
		if(size+1 < array.length){
			array[size++] = n;
		}else{
			increaseSize(); //if length of array is small. increase method is called.
			array[size++] = n;
		}
		
	}
	
	//in this method array is coppying and redefined. Then it takes its old values 
	private void increaseSize(){
		Shape[] backup = new Shape[array.length];
		
		for (int i=0; i<array.length; i++) {
			backup[i] = array[i];
		}
		
		array = new Shape[array.length+10];
		
		for(int i = 0; i<backup.length; i++){
			array[i]  = backup[i];
			backup[i] = null;
		}
	}
	
	//After n'th value of array attempt to null
	public void remove(int n){
		for(int i = (n+1); i<= size; i++){
			array[i-1] = array[i];
		}
		array[size--] = null;
	}
	public void remove(){
		array[size--] = null;
	}

}
