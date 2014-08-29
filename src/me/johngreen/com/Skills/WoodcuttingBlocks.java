package me.johngreen.com.Skills;

import java.util.Random;

public enum WoodcuttingBlocks {
	Log(12,30,100,1,25),
	OakLog(13,40,120,15,37),
	Willow(14,60,160,30,67),
	Yew(15,60,200,60,175);
	
	WoodcuttingBlocks(int LogMeta,int minSecconds,int maxSecconds,int level,int xp){
		this.LogMeta = LogMeta;
		this.minSecconds = minSecconds;
		this.maxSecconds = maxSecconds;
		this.level = level;
		this.xp = xp;
	}
	private int LogMeta;
	private int minSecconds;
	private int maxSecconds;
	private int level;
	private int xp;
	public int getXp(){
		return xp;
	}
	public int getLevel(){
		return level;
	}
	public int getMaxSecconds(){
		return maxSecconds;
	}
	public int getMinSecconds(){
		return minSecconds;
	}
	public int getLogMeta(){
		return LogMeta;
	}
	public double getTimeToChop(){
		Random r = new Random();
		int i1 = r.nextInt(maxSecconds - minSecconds) + minSecconds;
		return (double)i1/10;
	}
	public static WoodcuttingBlocks getByMeta(int m){
		switch(m){
			case 12:
				return WoodcuttingBlocks.Log;
			case 13:
				return WoodcuttingBlocks.OakLog;
			case 14:
				return WoodcuttingBlocks.Willow;
			case 15:
				return WoodcuttingBlocks.Yew;
		}
		return null;
	}
}
