package com.PropertiesOfObjects;

public class Behaviour {
	
	private boolean solid;
	private boolean stable;
	private boolean wrap;
	private boolean elastic;
	
	public Behaviour() {
		solid = false;
		stable = false;
		wrap = false;
		elastic = false;
	}

	public boolean isSolid() {
		return solid;
	}

	public void solid(boolean solid) {
		this.solid = solid;
	}

	public boolean isStable() {
		return stable;
	}

	public void stable(boolean stable) {
		this.stable = stable;
	}

	public boolean isWrap() {
		return wrap;
	}

	public void wrap(boolean wrap) {
		this.wrap = wrap;
	}
	
	public void elastic(boolean elastic) {
		this.elastic = elastic;
	}
	public boolean isElastic() {
		return elastic;
	}
	
	

}
