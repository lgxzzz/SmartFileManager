package memory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ime.cloud.R;



import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ClearOptionAdapter extends BaseAdapter{
	private Context mContext;
	private List<UsageInfo> mOptions;
	private Map<Integer, Boolean> mSelects = new LinkedHashMap<Integer, Boolean>();
	public ClearOptionAdapter(Context mContext,List<UsageInfo> mOptions){
		this.mContext = mContext;
		this.mOptions = mOptions;
		for (int i = 0; i < mOptions.size(); i++) {
			UsageInfo info = mOptions.get(i);
			mSelects.put(info.getmType(), false);
		}
	}
	
	public void refresh(List<UsageInfo> mOptions){
		mSelects.clear();
		this.mOptions = mOptions;
		for (int i = 0; i < mOptions.size(); i++) {
			UsageInfo info = mOptions.get(i);
			mSelects.put(info.getmType(), false);
		}
		notifyDataSetChanged();
	}
	
	public Map<Integer, Boolean> getSelect(){
		return mSelects;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mOptions.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mOptions.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final UsageInfo info = mOptions.get(position);
		final ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.clear_option_item, null);
			holder = new ViewHolder();
			holder.name = (TextView)convertView.findViewById(R.id.tv_option_name);
			holder.usage = (TextView)convertView.findViewById(R.id.tv_option_usage);
			holder.select = (CheckBox)convertView.findViewById(R.id.cb_option_state);
			holder.enter = (CheckBox)convertView.findViewById(R.id.cb_option_enter);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.name.setText(info.getmName());
		String size = SizeConverter.convertBytes(Float.parseFloat(info.getmUsage()),true);
		holder.usage.setText(size);
		if (info.getmName().contains("地图")) {
			holder.select.setVisibility(View.GONE);
			holder.enter.setVisibility(View.VISIBLE);
		}else if(info.getmName().contains("深度清理")){
			holder.select.setVisibility(View.GONE);
			holder.enter.setVisibility(View.VISIBLE);
			convertView.setBackgroundResource(R.drawable.special_bg);
			holder.usage.setVisibility(View.GONE);
		}else{
			holder.select.setVisibility(View.VISIBLE);
			holder.enter.setVisibility(View.GONE);
			holder.usage.setVisibility(View.VISIBLE);
		}
		holder.select.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (!buttonView.isPressed()) {
					return;
				}
				mSelects.put(info.getmType(),isChecked);
			}
		});
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (info.getmName().contains("地图")) {
					mContext.sendBroadcast(new Intent(ImeIntent.ACTION_OPEN_NAVIGATOR));		
				}else if(info.getmName().contains("深度清理")){
					Intent intent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
					mContext.startActivity(intent);
				}else{
					boolean isSelect = mSelects.get(info.getmType());
					holder.select.setChecked(!isSelect);
					mSelects.put(info.getmType(), !isSelect);
				}
			}
		});
		return convertView;
	}

	static class ViewHolder{
		TextView name;
		TextView usage;
		CheckBox select;
		CheckBox enter;
	}
	
}
