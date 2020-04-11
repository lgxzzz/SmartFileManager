package memory;



import java.util.List;

import com.ime.cloud.R;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ClearNoticeDialog extends AlertDialog implements OnClickListener{

	TextView tv_title;
	Button btn_sure;
	Button btn_cancel;
	Context mContext;
	LoadingBar mLoadingBar;
	
	boolean isDeleting = false;
	
	IClearDialogListener mListener;
	
	public ClearNoticeDialog(Context context, int theme,IClearDialogListener mListener) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		mContext = context;
		
		this.mListener = mListener;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clear_notice_dialog);
		mLoadingBar = (LoadingBar) findViewById(R.id.del_progressbar);
		mLoadingBar.loading();
		tv_title = (TextView)findViewById(R.id.tv_title);
//		
		btn_sure = (Button) findViewById(R.id.btn_sure);
		btn_cancel = (Button) findViewById(R.id.btn_cancel);
//		
		btn_sure.setOnClickListener(this);
		btn_cancel.setOnClickListener(this);
	}
	
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (isDeleting) {
			return;
		}
		switch (arg0.getId()) {
		case R.id.btn_sure:
			isDeleting = true;
			tv_title.setText("删除中...");
			mLoadingBar.setVisibility(View.VISIBLE);
			ClearNoticeDialog.this.setCanceledOnTouchOutside(false);
			mListener.onDel();
			break;
		case R.id.btn_cancel:
			dismiss();
			break;
		default:
			break;
		}
	} 

	public interface IClearDialogListener{
		public void onDel();
	}

	
	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		tv_title.setText("是否删除文件！");
		mLoadingBar.setVisibility(View.INVISIBLE);
		isDeleting = false;
		ClearNoticeDialog.this.setCanceledOnTouchOutside(true);
		super.dismiss();
	}
}
