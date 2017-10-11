package com.PropertiesOfObjects;

public class Behaviour {
	
	private boolean solid, solidDefault;
	private boolean stable;
	private boolean wrap;
	private boolean elastic;
	private boolean stableInScreen;
	private boolean invisible;
	private double coEfficientFriction;
	
	public Behaviour() {
		//Default values.
		solid = false;
		solidDefault = false;
		stable = false;
		wrap = false;
		elastic = false;
		stableInScreen = false;
		invisible = false;
		coEfficientFriction = 1;
	}

	public boolean isSolid() {
		return solid;
	}

	
	public void solid(boolean solid) {
		this.solid = solid;
		solidDefault = solid;
	}

	public void solidVisible(boolean solid) {
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
	
	public void getDfaultSolid() {
		solid = solidDefault;
	}
	
	
	
	public double getCoEfficientFriction() {
		return coEfficientFriction;
	}
	
	public void setCoEfficientFriction(double coEfficientFriction) {
		this.coEfficientFriction = coEfficientFriction;
	}
	
	public void setStableInScreen(boolean stableInScreen) {
		this.stableInScreen = stableInScreen;
	}
	
	public boolean isStableInScreen() {
		return stableInScreen;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}
	
	public boolean isInvisible() {
		return invisible;
	}
	
	
	

}
