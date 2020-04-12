package com.smart.filemanager.core.engine.service.copy;

import android.os.RemoteException;

import com.smart.filemanager.ICopyFilesCallback;

public class SimpleCopyFileCallback extends ICopyFilesCallback.Stub{

    @Override
    public void onStart() throws RemoteException {
        
    }

    @Override
    public void onPause() throws RemoteException {
        
    }

    @Override
    public void postUpdate(String fileName, long allSize, long hasDelete, int progress) throws RemoteException {
        
    }

    @Override
    public void onCancel(long hasDeletedSize) throws RemoteException {
        
    }

    @Override
    public void onFinish(long hasDeletedSize) throws RemoteException {
        
    }

    @Override
    public void onResume() throws RemoteException {
        
    }

}
