package me.johngreen.com.Skills;

public enum FiremakingBlocks {
	Log(2,8,40),
	OakLog(3,9,60),
	Willow(4,10,90),
	Yew(5,11,203);
	
	FiremakingBlocks(int min, int max,int xp){
		this.min = min;
		this.max = max;
		this.xp=xp;
	}
	private int min;
	private int max;
	private int xp;
	
	public int getMin(){
		return min;
	}
	
	public int getMax(){
		return max;
	}
	public int getXp(){
		return xp;
	}
}
