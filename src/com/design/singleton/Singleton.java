package com.design.singleton;

import java.io.Serializable;

public class Singleton implements Serializable{
	
	/*  Version 1 Eager
	 * private static Singleton obj = new Singleton();
	
	private Singleton(){
	}
	
	public static Singleton  getInstance()
	{
		return obj;
	}*/
	
/*	Version 2 Lazy instantiation
 * 
	private static Singleton instance = null;
	
	private Singleton(){
	}
	
	public static Singleton  getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	*/
	

	/* Version 3 : Method level synchronized
	 * 
	 * private static Singleton instance = null;
	
	private Singleton(){
	}
	
	public synchronized static Singleton  getInstance() {
		
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	*/
	
	
	// Version 4 : Double Checked locking
	//compiler optimization will be issue in this approach
	/*private static Singleton instance = null;
	
	private Singleton(){
	}
	
	public static Singleton  getInstance() {
		
		if(instance == null) {
			
			synchronized (Singleton.class) {
				
				if(instance == null) {
					instance = new Singleton();
				}
				
			}
		}
		return instance;
	}*/
	
	
	//Version 5 
	// volatile will be over head
	/*private static volatile Singleton instance = null;
	
	private Singleton(){
	}
	
	public static Singleton  getInstance() {
		
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}*/
	
	
	// Version 6 : static holder pattern
	private Singleton(){
	}
	
	static class SingletonHolder {
		static {
			System.out.println("test");
		}
		private static Singleton instance = new Singleton();
	}
	
	public static Singleton  getInstance() {
		return SingletonHolder.instance;
	}
	public Object readResolve(){
		return getInstance();
	}
	public static void main(String[] args) {
		Singleton obj = Singleton.getInstance();
	}
		

}
