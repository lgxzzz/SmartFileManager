package com.smart.filemanager.view;

import android.view.View;

public interface IOnMenuItemClickListener {
    public void onItemClick(View rootView, View view);
    public void onSelecteAll(View view, boolean selecteAll);
}
