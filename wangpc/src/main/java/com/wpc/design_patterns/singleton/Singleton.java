package com.wpc.design_patterns.singleton;

/**
 * 单例模式
 * 单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 * @author admin
 *
 */
public class Singleton {

	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static Singleton instance = null;
	
	/* 私有构造方法，防止被实例化 */
	private Singleton(){
		
	}
	
	/* 静态工程方法，创建实例 */
	public static Singleton getInstance(){
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	
	/*
	 * 考虑到线程安全的问题，可以加入synchronized修饰，如下，刻放在方法上或创建对象时。
	 * 这样做会严重影响程序性能，每次获取或者实例时等进行等待。
	public static synchronized Singleton getInstance(){
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	public static Singleton getInstance() {
		if(instance == null){
			synchronized (instance) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}*/
	
	/*
	 * 考虑到上边性能问题，可以将实例化过程提出，加上synchronized修饰，如下
	 * 这样除非在第一次实例化时，之后获取实例不会有性能问题了
	private static synchronized void syncInit() {
		if(instance == null) {
			instance = new Singleton();
		}
	}
	public static Singleton getInstance(){
		if(instance == null)
			syncInit();
		return instance;
	}*/
	
}
