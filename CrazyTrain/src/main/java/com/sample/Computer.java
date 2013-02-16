package com.sample;


/**
 * 
 * @author Aditi Srinivas
 *
 */
public class Computer {
	private String model;
	private int memory;
	private int cpu;
	private double price;
	private char graphicsCardType;
	private boolean hot;
	private boolean cheap;
	
	/**
	 * 
	 * @return if machine is hot
	 */
	public boolean isHot() {
		return hot;
	}
	/**
	 * 
	 * @param hot
	 */
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	/**
	 * 
	 * @return if machine is cheap
	 */
	public boolean isCheap() {
		return cheap;
	}
	/**
	 * 
	 * @param cheap
	 */
	public void setCheap(boolean cheap) {
		this.cheap = cheap;
	}
	/**
	 * 
	 * @return model of the computer
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 
	 * @param model set model of the computer
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 
	 * @return memory capacity of the computer
	 */
	public int getMemory() {
		return memory;
	}
	
	/**
	 * 
	 * @param memory capacity for the computer
	 */
	public void setMemory(int memory) {
		this.memory = memory;
	}
	/**
	 * 
	 * @return cpu speed of the computer
	 */
	public int getCpu() {
		return cpu;
	}
	/**
	 * 
	 * @param cpu speed of the computer
	 */
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	/**
	 * 
	 * @return price of the computer
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price of the computer
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 
	 * @return graphics card type
	 */
	public char getGraphicsCardType() {
		return graphicsCardType;
	}
	/**
	 * 
	 * @param graphicsCardType
	 */
	public void setGraphicsCardType(char graphicsCardType) {
		this.graphicsCardType = graphicsCardType;
	}
	
}
