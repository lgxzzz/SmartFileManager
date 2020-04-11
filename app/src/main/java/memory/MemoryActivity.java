package memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ime.cloud.R;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MemoryActivity extends Activity{
	
	private BuiltinStorageMgr mBuiltinStorageMgr;
	private ListView mClearOptionListview;
	private ClearOptionAdapter mAdapter;
	private List<UsageInfo> mOptions = new ArrayList<UsageInfo>();
	private MemoryUsageView mUsageView;
	
	private ClearNoticeDialog mDialog;
	private TextView mUsageTv;
	private TextView mMapUsageTv;
	private TextView mMusicUsageTv;
	private TextView mVideoUsageTv;
	private TextView mOtherUsageTv;
	
	private Button mClearBtn;
	private Button mExitBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memory_layout);
		initDefaulData();
		initView();
	}
	
	public void initView(){
		
		mUsageTv = (TextView)findViewById(R.id.tv_usage);
		mMapUsageTv = (TextView)findViewById(R.id.map_usage);
		mMusicUsageTv = (TextView)findViewById(R.id.music_usage);
		mVideoUsageTv = (TextView)findViewById(R.id.video_usage);
		mOtherUsageTv = (TextView)findViewById(R.id.other_usage);
		mUsageView = (MemoryUsageView) findViewById(R.id.memo_usage);
		mClearBtn = (Button)findViewById(R.id.btn_clear);
		mExitBtn = (Button)findViewById(R.id.btn_exit);
		
		mDialog = new ClearNoticeDialog(this, R.style.MyDialog, new ClearNoticeDialog.IClearDialogListener() {
			
			@Override
			public void onDel() {
				// TODO Auto-generated method stub
				Map<Integer, Boolean> del = mAdapter.getSelect();
				mBuiltinStorageMgr.Delete(del);
			}
		});
		
		mClearBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDialog.show();

			}
		});
		
		mExitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent homeIntent = new Intent();
//				homeIntent.setAction(ImeIntent.ACTION_HOME_PRESSED);
//				sendBroadcast(homeIntent);
				finish();
			}
		});
		
		mBuiltinStorageMgr = new BuiltinStorageMgr(MemoryActivity.this, new BuiltinStorageMgr.IBuiltinStrogeStateListener() 
		{
			
			@Override
			public void getOverallUsage(final long total,final long avail, final List<UsageInfo> mUsageInfos) {
				// TODO Auto-generated method stub
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mOptions.clear();
						
						String totalsize = SizeConverter.convertBytes(Float.parseFloat(total+""),true);
						String availsize = SizeConverter.convertBytes(Float.parseFloat(avail+""),true);
						
						mUsageTv.setText("已使用"+(availsize+"/"+totalsize));
						mUsageView.refreshView(total,mUsageInfos);
						for (int i = 0; i < mUsageInfos.size(); i++) 
						{
							UsageInfo info = mUsageInfos.get(i);
							String size = SizeConverter.convertBytes(Float.parseFloat(info.getmUsage()),true);
							switch (info.getmType()) {
							case BuiltinStorageMgr.TYPE_MAP:
								mMapUsageTv.setText("地图"+size);
								mOptions.add(info);
								break;
							case BuiltinStorageMgr.TYPE_MUSIC:
								mMusicUsageTv.setText("音频"+size);
								break;
							case BuiltinStorageMgr.TYPE_VIDEO:
								mVideoUsageTv.setText("文件"+size);
								mOptions.add(info);
								break;
							case BuiltinStorageMgr.TYPE_SYSTEM:
								mOtherUsageTv.setText("系统"+size);
								break;
							case BuiltinStorageMgr.TYPE_KUWO:
							case BuiltinStorageMgr.TYPE_TONGTING:
							case BuiltinStorageMgr.TYPE_OTHER_MUSIC:
							case BuiltinStorageMgr.TYPE_OTHER:
							case BuiltinStorageMgr.TYPE_MAP_LOG:
								mOptions.add(info);
								break;
							default:
								break;
							}
						}
						
						UsageInfo info6 = new UsageInfo();
						info6.mName = "深度清理";
						info6.mUsage = "0";
						info6.mType = BuiltinStorageMgr.TYPE_CLEAR;
						mOptions.add(info6);
						 
						mAdapter.refresh(mOptions);
						
					}
				});
				
			}

			@Override
			public void onDelFinish() {
				// TODO Auto-generated method stub
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mDialog.dismiss();
						mBuiltinStorageMgr.startCount();
					}
				});
			}
		});
		mBuiltinStorageMgr.startCount();
		
		mClearOptionListview = (ListView) findViewById(R.id.clear_option_listview);
		mAdapter = new ClearOptionAdapter(this,mOptions);
		mClearOptionListview.setAdapter(mAdapter);
	}

	 public void initDefaulData(){
		 UsageInfo info = new UsageInfo();
		 info.mName = "离线地图";
		 info.mUsage = "0";
		 info.mType = BuiltinStorageMgr.TYPE_MAP;
		 mOptions.add(info);
		 
		 UsageInfo info2 = new UsageInfo();
		 info2.mName = "视频文件";
		 info2.mUsage = "0";
		 info2.mType = BuiltinStorageMgr.TYPE_VIDEO;
		 mOptions.add(info2);
		 
		 UsageInfo info3 = new UsageInfo();
		 info3.mName = "酷我";
		 info3.mUsage = "0";
		 info3.mType = BuiltinStorageMgr.TYPE_KUWO;
		 mOptions.add(info3);
		 
		 UsageInfo info4 = new UsageInfo();
		 info4.mName = "同听";
		 info4.mUsage = "0";
		 info4.mType = BuiltinStorageMgr.TYPE_TONGTING;
		 mOptions.add(info4);
		 
		 UsageInfo info1 = new UsageInfo();
		 info1.mName = "其他音乐";
		 info1.mUsage = "0";
		 info1.mType = BuiltinStorageMgr.TYPE_OTHER_MUSIC;
		 mOptions.add(info1);
		 
		 UsageInfo info5 = new UsageInfo();
		 info5.mName = "日志文件";
		 info5.mUsage = "0";
		 info5.mType = BuiltinStorageMgr.TYPE_OTHER;
		 mOptions.add(info5);
				
		 UsageInfo info7 = new UsageInfo();
		 info7.mName = "地图日志";
		 info7.mUsage = "0";
		 info7.mType = BuiltinStorageMgr.TYPE_MAP_LOG;
		 mOptions.add(info7);
		 
		 UsageInfo info6 = new UsageInfo();
		 info6.mName = "深度清理";
		 info6.mUsage = "0";
		 info6.mType = BuiltinStorageMgr.TYPE_CLEAR;
		 mOptions.add(info6);
		 
	 }
	
	 
	 private Handler mHandler = new Handler(new Handler.Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
			// TODO Auto-generated method stub
			return false;
		}
	});
}
