package com.smart.filemanager.clean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart.filemanager.activity.R;

public class MemoryUsageView extends LinearLayout{
	private LinearLayout mStatusLayout;
	private long mTotalSize = 0;
	
	public MemoryUsageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.memory_usage, this);
		mStatusLayout = (LinearLayout)findViewById(R.id.tmc_status_layout);
		
		initDefaultStatus();
//		test();	
	}
	public MemoryUsageView(Context context, AttributeSet attrs,int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public void refreshView(long totalsize,List<UsageInfo> mUsageInfos){
		mTotalSize = totalsize;
		this.mStatusLayout.removeAllViews();
		for (int i = 0; i < mUsageInfos.size(); i++) {
			boolean isAdd = false;
			UsageInfo info = mUsageInfos.get(i);
			GradientDrawable drawable = new GradientDrawable();
			switch (info.mType) 
			{
				case BuiltinStorageMgr.TYPE_OTHER:
					isAdd = true;
					drawable.setCornerRadii(new float[]{20,20,0,0,0,0,20,20});
					break;
			case BuiltinStorageMgr.TYPE_RESIDUE:
				isAdd = true;
				drawable.setCornerRadii(new float[]{0,0,20,20,20,20,0,0});
				break;
			case BuiltinStorageMgr.TYPE_MUSIC:
			case BuiltinStorageMgr.TYPE_VIDEO:
			case BuiltinStorageMgr.TYPE_SYSTEM:
				isAdd = true;
				drawable.setCornerRadii(new float[]{0,0,0,0,0,0,0,0});
				break;

			default:
				break;
			}
			if (isAdd) {
				TextView view = new TextView(getContext());  
				int mType = info.getmType();
				int color = getColorByType(mType);
				drawable.setColor(color);
				view.setBackgroundDrawable(drawable);
				
				float mUsage = Float.parseFloat(info.getmUsage());
				if (mUsage/mTotalSize<0.05) 
				{
					LayoutParams localLayoutParams = new LayoutParams(20, -1);
					this.mStatusLayout.addView(view, localLayoutParams);	
				}else
				{
					LayoutParams localLayoutParams = new LayoutParams(0, -1);
					localLayoutParams.weight = mUsage;
					this.mStatusLayout.addView(view, localLayoutParams);	
				}
				
				
			}
			
		}
	}
	
	/**
	 * 计算权重   消耗内存小于总容量的5%的部分，显示默认权重
	 * 
	 * */
	public float computeWeight(int size){
		if ((size/mTotalSize)<0.05) 
		{
		}
		return 1;
	}
	
	private void initDefaultStatus(){
		 TextView view = new TextView(getContext());
		 view.setBackgroundResource(R.drawable.shape_corner_default);
		 LayoutParams localLayoutParams = new LayoutParams(0, -1);
		 localLayoutParams.weight = 1;
		 this.mStatusLayout.addView(view, localLayoutParams);
	}
	
	private int getColorByType(int mType){
		  int color = Color.parseColor("#FFFFFF");
		  if (mType == BuiltinStorageMgr.TYPE_OTHER) {
			  color = Color.parseColor("#ee243e");
		  }else if(mType == BuiltinStorageMgr.TYPE_MUSIC){
			  color= Color.parseColor("#e4b600");
		  }else if(mType == BuiltinStorageMgr.TYPE_VIDEO){
			  color= Color.parseColor("#34aadc");
		  }else if(mType == BuiltinStorageMgr.TYPE_SYSTEM){
			  color= Color.parseColor("#c7c7cb");
		  }
		  return color;
	 }
	  
	 public void test(){
		 List<UsageInfo> mUsageInfos = new ArrayList<UsageInfo>();

		 UsageInfo info1 = new UsageInfo();
		 info1.mType = BuiltinStorageMgr.TYPE_MUSIC;
		 info1.mUsage = "2";
		 mUsageInfos.add(info1);
		 
		 UsageInfo info2 = new UsageInfo();
		 info2.mType =  BuiltinStorageMgr.TYPE_VIDEO;
		 info2.mUsage = "2.5";
		 mUsageInfos.add(info2);
		 
		 UsageInfo info3 = new UsageInfo();
		 info3.mType = BuiltinStorageMgr.TYPE_OTHER;
		 info3.mUsage = "0.5";
		 mUsageInfos.add(info3);
				
		 UsageInfo info4 = new UsageInfo();
		 info4.mType =  BuiltinStorageMgr.TYPE_RESIDUE;
		 info4.mUsage = "0.5";
		 mUsageInfos.add(info4);
		 
		 refreshView(0,mUsageInfos);
	 }
}
