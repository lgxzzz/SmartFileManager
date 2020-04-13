package com.smart.filemanager;
import com.smart.filemanager.ICopyFilesCallback;
interface ICopyFiles {
	void start(in List<String> files, String des);
	void cancel();
	void pause();
	void resume();
	void registerCallback(ICopyFilesCallback callback);
	void unregisterCallback(ICopyFilesCallback callback);
}