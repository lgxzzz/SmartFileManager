package com.smart.filemanager.clean;

public class UsageInfo {
	public int mType = -1;
	public String mName;
	public String mUsage;
	public String mPath;
	public boolean mSelect = true;
	
	public String getmUsage() {
		return mUsage;
	}
	public void setmUsage(String mUsage) {
		this.mUsage = mUsage;
	}
	public boolean ismSelect() {
		return mSelect;
	}
	public void setmSelect(boolean mSelect) {
		this.mSelect = mSelect;
	}
	public String getmPath() {
		return mPath;
	}
	public void setmPath(String mPath) {
		this.mPath = mPath;
	}
	public int getmType() {
		return mType;
	}
	public void setmType(int mType) {
		this.mType = mType;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
}
