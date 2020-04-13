package com.smart.filemanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.smart.filemanager.activity.R;
import com.smart.filemanager.clean.BuiltinStorageMgr;
import com.smart.filemanager.clean.ClearNoticeDialog;
import com.smart.filemanager.clean.ClearOptionAdapter;
import com.smart.filemanager.clean.MemoryUsageView;
import com.smart.filemanager.clean.SizeConverter;
import com.smart.filemanager.clean.UsageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrangeFragment extends Fragment{
    private View mView = null;

    private BuiltinStorageMgr mBuiltinStorageMgr;
    private ListView mClearOptionListview;
    private ClearOptionAdapter mAdapter;
    private List<UsageInfo> mOptions = new ArrayList<UsageInfo>();
    private MemoryUsageView mUsageView;

    private ClearNoticeDialog mDialog;
    private TextView mUsageTv;
    private TextView mOtherUsageTv;
    private TextView mMusicUsageTv;
    private TextView mVideoUsageTv;
    private TextView mSystemUsageTv;

    private Button mClearBtn;
    private Button mExitBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.memory_layout, null);

        initDefaulData();
        initView();
        return mView;
    }

    public void initView(){

        mUsageTv = (TextView)mView.findViewById(R.id.tv_usage);
        mSystemUsageTv = (TextView)mView.findViewById(R.id.system_usage);
        mMusicUsageTv = (TextView)mView.findViewById(R.id.music_usage);
        mVideoUsageTv = (TextView)mView.findViewById(R.id.video_usage);
        mOtherUsageTv = (TextView)mView.findViewById(R.id.other_usage);
        mUsageView = (MemoryUsageView) mView.findViewById(R.id.memo_usage);
        mClearBtn = (Button)mView.findViewById(R.id.btn_clear);
        mExitBtn = (Button)mView.findViewById(R.id.btn_exit);

        mDialog = new ClearNoticeDialog(getContext(), R.style.MyDialog, new ClearNoticeDialog.IClearDialogListener() {

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
            }
        });

        mBuiltinStorageMgr = new BuiltinStorageMgr(getContext(), new BuiltinStorageMgr.IBuiltinStrogeStateListener()
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
                                case BuiltinStorageMgr.TYPE_MUSIC:
                                    mMusicUsageTv.setText("音频"+size);
                                    mOptions.add(info);
                                    break;
                                case BuiltinStorageMgr.TYPE_VIDEO:
                                    mVideoUsageTv.setText("文件"+size);
                                    mOptions.add(info);
                                    break;
                                case BuiltinStorageMgr.TYPE_SYSTEM:
                                    mSystemUsageTv.setText("系统"+size);
                                    break;
                                case BuiltinStorageMgr.TYPE_OTHER:
                                    mOtherUsageTv.setText("其他"+size);
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

        mClearOptionListview = (ListView) mView.findViewById(R.id.clear_option_listview);
        mAdapter = new ClearOptionAdapter(getContext(),mOptions);
        mClearOptionListview.setAdapter(mAdapter);
    }

    public void initDefaulData(){
        UsageInfo info1 = new UsageInfo();
        info1.mName = "音乐文件";
        info1.mUsage = "0";
        info1.mType = BuiltinStorageMgr.TYPE_MUSIC;
        mOptions.add(info1);

        UsageInfo info2 = new UsageInfo();
        info2.mName = "视频文件";
        info2.mUsage = "0";
        info2.mType = BuiltinStorageMgr.TYPE_VIDEO;
        mOptions.add(info2);

        UsageInfo info5 = new UsageInfo();
        info5.mName = "日志文件";
        info5.mUsage = "0";
        info5.mType = BuiltinStorageMgr.TYPE_OTHER;
        mOptions.add(info5);

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
