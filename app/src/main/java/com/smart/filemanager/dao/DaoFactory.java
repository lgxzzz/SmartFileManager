package com.smart.filemanager.dao;

import android.content.Context;

import com.smart.filemanager.dao.impl.FavoriteDao;
import com.smart.filemanager.dao.impl.FileAppNameDao;
import com.smart.filemanager.dao.impl.FileTypeDao;

public class DaoFactory {
    private static FileTypeDao   mFileTypeDao = null;
    public static FavoriteDao    mFavoriteDao = null;
    public static FileAppNameDao mAppNameDao  = null;

    private DaoFactory() {
        super();
    }

    public static FileTypeDao getFileTypeDao(Context context) {
        if (mFileTypeDao == null) {
            mFileTypeDao = new FileTypeDao();
        }
        return mFileTypeDao;
    }

    public static FavoriteDao getFavoriteDao(Context context) {
        if (mFavoriteDao == null) {
            mFavoriteDao = new FavoriteDao();
        }
        return mFavoriteDao;
    }

    public static FileAppNameDao getFileAppNameDao(Context context) {
        if (mAppNameDao == null) {
            mAppNameDao = new FileAppNameDao();
        }
        return mAppNameDao;
    }

}
