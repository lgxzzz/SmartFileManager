package com.smart.filemanager;
import com.smart.filemanager.IDeleteFilesCallback;
interface IDeleteFiles {
	void start(in List<String> files);
	void cancel();
	void pause();
	void resume();
	void registerCallback(IDeleteFilesCallback callback); 
	void unregisterCallback(IDeleteFilesCallback callback);
}