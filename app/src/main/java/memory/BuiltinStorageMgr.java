package memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

/**
 * 内置存储管理器
 * */
public class BuiltinStorageMgr {
	
	public static String TAG = "BuiltinStorageMgr";
	
	private Context mContext;
	
	private IBuiltinStrogeStateListener mListener;
	
	public static String mParentPath = Environment.getExternalStorageDirectory().getAbsolutePath();
	
	public static String mMapPath = "amapauto9/data/navi/compile_v2/";
	
	public static String mKuwoPath = "kwmusiccar/Song";
	
	public static String mTongtingPath = "txz/audio/song";

	public static String mTxzCachePath = "txz/cache";
	
	public static String mImeLogPath = "ime/log";
	
	public static String mImeMtklogPath = "mtklog/";
	
	public static String mAmapLog = "amapauto9/Log";
	
	
	public static final int TYPE_DEFAULT = 0;
	/*地图*/
	public static final int TYPE_MAP = 1;
	/*所有音频文件*/
	public static final int TYPE_MUSIC = 2;
	/*所有视频文件*/
	public static final int TYPE_VIDEO = 3;
	/*其他类型*/
	public static final int TYPE_OTHER = 4;
	/*剩余空间*/
	public static final int TYPE_RESIDUE = 5;
	/*酷我*/
	public static final int TYPE_KUWO = 6;
	/*同听*/
	public static final int TYPE_TONGTING = 7;
	/*其他路径音频*/
	public static final int TYPE_OTHER_MUSIC = 8;
	/*系统文件*/
	public static final int TYPE_SYSTEM = 9;
	/*深度清理*/
	public static final int TYPE_CLEAR = 10;
	/*地图log*/
	public static final int TYPE_MAP_LOG = 11;
	
	public static final String[] NAMES = new String[]
	{
		"默认",
		"离线地图",
		"所有音频",
		"视频文件",
		"日志文件",
		"剩余空间",
		"酷我",
		"同听",
		"其他音乐",
		"系统文件",
		"深度清理",
		"地图log"
	};
	
	//统计大小
	public  Map<Integer, Long> mUsageMap = new LinkedHashMap<Integer, Long>();
	//保存文件路径
	public  Map<Integer,Object> mUsagePaths= new LinkedHashMap<Integer, Object>();
	
	/*音乐文件格式*/
	private String[] mMusicFormat={
		"mp3","acc","arm","ogg","ape","flac","wav"
	}; 
	
	/*视频格式*/
	private String[] mVideoFormat={
		"mp4","mkv","rmvb","flv","avi","mpg","3gp"
	};
	
	/*其他文件类型 
	 *（1）文档
	 *（2）压缩包
	 *（3）apk
	 *（4）图片
	 * */
	private String[] mOtherFormat={
//		"doc","docx","xls","xlsx","ppt","pptx",
//		"zip","rar","tar","gz",
//		"apk",
//		"img","jpg","png"
		"log"
	};
	   
	
	public BuiltinStorageMgr(Context mContext,IBuiltinStrogeStateListener mListener){
		this.mContext = mContext;
		this.mListener = mListener;
		
		setDefaultValue();
	}
	
	private void setDefaultValue()
	{
		mUsageMap.put(TYPE_DEFAULT, 0l);
		mUsageMap.put(TYPE_MAP, 0l);
		mUsageMap.put(TYPE_MUSIC, 0l);
		mUsageMap.put(TYPE_VIDEO, 0l);
		mUsageMap.put(TYPE_KUWO, 0l);
		mUsageMap.put(TYPE_TONGTING, 0l);
		mUsageMap.put(TYPE_OTHER_MUSIC, 0l);
		mUsageMap.put(TYPE_OTHER, 0l);
		mUsageMap.put(TYPE_SYSTEM, 0l);
		mUsageMap.put(TYPE_RESIDUE, 0l);
		mUsageMap.put(TYPE_MAP_LOG, 0l);
		
		mUsagePaths.put(TYPE_DEFAULT, new ArrayList<String>());
		mUsagePaths.put(TYPE_MAP, new ArrayList<String>());
		mUsagePaths.put(TYPE_MUSIC, new ArrayList<String>());
		mUsagePaths.put(TYPE_VIDEO, new ArrayList<String>());
		mUsagePaths.put(TYPE_KUWO, new ArrayList<String>());
		mUsagePaths.put(TYPE_TONGTING, new ArrayList<String>());
		mUsagePaths.put(TYPE_OTHER_MUSIC, new ArrayList<String>());
		mUsagePaths.put(TYPE_OTHER, new ArrayList<String>());
		mUsagePaths.put(TYPE_SYSTEM, new ArrayList<String>());
		mUsagePaths.put(TYPE_RESIDUE, new ArrayList<String>());
		mUsagePaths.put(TYPE_MAP_LOG, new ArrayList<String>());
	}
    
    public void startCount(){
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				setDefaultValue();
				
				long totalSize = getTotalSize(mParentPath);
				long availSize = getAvailableSize(mParentPath);
				long usageSize = totalSize - availSize;
				List<UsageInfo> mUsageInfos = new ArrayList<UsageInfo>();

				scanFileList(new File(mParentPath));
				
				for (Entry<Integer, Long> entry : mUsageMap.entrySet())
				{
					UsageInfo info = new UsageInfo();
					
					Integer key = entry.getKey();
					Long value = entry.getValue();
					
					if (key == TYPE_MUSIC) 
					{
						//所有音乐内存统计
						value = mUsageMap.get(TYPE_KUWO)+mUsageMap.get(TYPE_TONGTING)+mUsageMap.get(TYPE_OTHER_MUSIC);
					}else if(key == TYPE_SYSTEM)
					{
						long other = 
								mUsageMap.get(TYPE_KUWO)+
								mUsageMap.get(TYPE_TONGTING)+
								mUsageMap.get(TYPE_OTHER_MUSIC)+
								mUsageMap.get(TYPE_VIDEO)+
								mUsageMap.get(TYPE_MAP)+
								mUsageMap.get(TYPE_OTHER)+
								mUsageMap.get(TYPE_MAP_LOG)
								;
						value = usageSize - other;
					}else if(key == TYPE_RESIDUE)
					{
						value = availSize;
					}
					
					info.mType = key;
					info.mUsage = value+"";
					info.mName = NAMES[key];
					mUsageInfos.add(info);
				}
				
				
				
				mListener.getOverallUsage(totalSize,usageSize, mUsageInfos);
			}
		}).start();
    }
    
    /**
     * 扫描内置存储所有文件
     * */
    private void scanFileList(File p){
    	 File[] listFile = p.listFiles();  
	        if (listFile==null) 
	        {
				return;
			}
	        int length = listFile.length;  
	        if (listFile != null) 
	        {  
	            for (int i = 0; i < length; i++) 
	            {  
	                File file = listFile[i];  
	                String path = file.getAbsolutePath();
	                Log.e(TAG,"path:"+ file.getAbsolutePath());
	                //文件夹继续遍历
	                if (file.isDirectory()) 
	                {  
	                    scanFileList(file);  
	                } 
	                else 
	                {  
	                   //校验文件名
	            	   String fileName = file.getName();  
                       int type = getType(file);
                       long size = getFileSize(file);
//                       Log.e("lgx", "name type:"+fileName +" "+type);
                       long total = mUsageMap.get(type) + size;
                       mUsageMap.put(type,total);
                       
                       List<String> usagePaths = (List<String>) mUsagePaths.get(type);
                       usagePaths.add(file.getAbsolutePath());
                       mUsagePaths.put(type, usagePaths);
//                       Log.e("lgx", "put path:"+type +" "+file.getAbsolutePath());
	                }  
	            }
	   		
	        }
    }
    
    /**
     * 是否音乐文件后缀
     * @param filepath 
     * */
    private boolean isMusicSuffix(String fileName){
    	for (String format : mMusicFormat) {
			if(fileName.toLowerCase().endsWith("."+format))return true;
		}
    	return false;
    }
	
    /**
     * 是否视频文件后缀
     * @param filepath
     * */
    private boolean isVideoSuffix(String fileName){
    	for (String format : mVideoFormat) {
			if(fileName.toLowerCase().endsWith("."+format))return true;
		}
    	return false;
    }
    
    /**
     * 是否其他格式文件后缀
     * @param filepath
     * */
    private boolean isOtherSuffix(String fileName){
    	for (String format : mOtherFormat) {
			if(fileName.toLowerCase().endsWith("."+format))return true;
		}
    	return false;
    }
    
    /**
     * 是否酷我缓存文件路径
     * @param filepath
     * */
    private boolean isKuwoSuffix(String filepath){
    	if (filepath.contains(mKuwoPath)) {
			return true;
		}
    	return false;
    }
    
    /**
     * 是否同听缓存文件路径
     * @param filepath
     * */
    private boolean isTongtingSuffix(String filePath){
    	if (filePath.contains(mTongtingPath) || filePath.contains(mTxzCachePath)) {
			return true;
		}
    	return false;
    }
    
    /**
     * 是否离线地图缓存路径
     * @param filepath
     * */
    private boolean isMapSuffix(String filepath){
    	if (filepath.contains("compile_v2")) {
			return true;
		}
    	return false;
    }
    
    /**
     * 是否日志文件
     * */
    private boolean isImeLog(String filepath){
    	if (filepath.contains(mImeMtklogPath) || filepath.contains(mImeLogPath)) {
			return true;
		}
    	return false;
    }
    
    /**
     * 是否地图log
     * */
    private boolean isMapLog(String filepath){
    	if(filepath.contains(mAmapLog)){
    		return true;
    	}	
    	return false;
    }
    
    /**
     * 根据文件名返回类型
     * @param filepath
     * */
    private int getType(File file){
    	String filePath = file.getAbsolutePath();
    	String fileName = file.getName();
    	int type = TYPE_DEFAULT;
    	if (isMapSuffix(filePath))
    	{
			type = TYPE_MAP;
		}else if(isKuwoSuffix(filePath))
		{
			type = TYPE_KUWO;
		}else if(isTongtingSuffix(filePath))
		{
			type = TYPE_TONGTING;
		}else if(isVideoSuffix(fileName))
		{
			type = TYPE_VIDEO;
		}else if(isMusicSuffix(fileName))
		{
			type = TYPE_OTHER_MUSIC;
		}else if(isImeLog(filePath) || isOtherSuffix(fileName))
		{
			type = TYPE_OTHER;
		}else if(isMapLog(filePath)){
			type = TYPE_MAP_LOG;
		}else{
			type = TYPE_SYSTEM;
		}
    	return type;
    }
    
	
	  /** 
	     * 计算剩余空间 
	     * @param path 
	     * @return 
	     */  
	    public static long getAvailableSize(String path)  
	    {  
	        StatFs fileStats = new StatFs(path);  
	        fileStats.restat(path);  
	        return (long) fileStats.getAvailableBlocks() * fileStats.getBlockSize(); // 注意与fileStats.getFreeBlocks()的区别  
	    }  
		
		/** 
	     * 计算总空间 
	     * @param path 
	     * @return 
	     */  
	    public static long getTotalSize(String path)  
	    {  
	        StatFs fileStats = new StatFs(path);  
	        fileStats.restat(path);  
	        return (long) fileStats.getBlockCount() * fileStats.getBlockSize();  
	    }  
	    
	    public static long getResidualSzie(String path){
	    	try {
	    		return getTotalSize(path)-getAvailableSize(path);
			} catch (Exception e) {
				// TODO: handle exception
				return 0l;
			}
	    }
	    
	    /**
	     * 获取文件大小
	     * */
	    public static long getFileSize(File file) {
			long size = 0;
			if (file.exists()) {
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					size = fis.available();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return size;
		}
 
	    /**
	     * 获取指定文件夹的大小
	     *
	     * @param f
	     * @return
	     * @throws Exception
	     */
	    public static long getFileSizes(File f) {
	        long size = 0;
	        File flist[] = f.listFiles();//文件夹目录下的所有文件
	        if (flist == null) {//4.2的模拟器空指针。
	            return 0;
	        }
	        if (flist != null) {
	            for (int i = 0; i < flist.length; i++) {
	                if (flist[i].isDirectory()) {//判断是否父目录下还有子目录
	                    size = size + getFileSizes(flist[i]);
	                } else {
	                    size = size + getFileSize(flist[i]);
	                }
	            }
	        }
	        return size;
	    }

	public void deleteFiles(List<String> paths){
		if (paths == null) {
			return;
		}
		for (int i = 0; i < paths.size(); i++) {
			String path = paths.get(i);
			deleteFile(path);
		}
	}    
	    
	    
	public void Delete(final Map<Integer,Boolean> delMap){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (Entry<Integer, Object> entry : mUsagePaths.entrySet()){
					int key = entry.getKey();
					List<String> paths = (List<String>) entry.getValue();

					Log.e("lgx","key:"+key+" size:"+paths.size());
				}
				
				for (Entry<Integer, Boolean> entry : delMap.entrySet()){
					int key = entry.getKey();
					boolean isSelect = entry.getValue();
					if (isSelect) 
					{
						List<String> paths = (List<String>) mUsagePaths.get(key);
						if (key !=TYPE_OTHER) 
						{
							//不是日志文件可只删除文件不删除文件目录
							deleteFiles(paths);
						}else
						{
							deleteDirectory(mImeLogPath);
							deleteDirectory(mImeMtklogPath);
							deleteFiles(paths);
						}
						
					}

				}
				mListener.onDelFinish();
			}
		}).start();
	}    
	    
	 /** 
     * 删除文件，可以是文件或文件夹 
     * 
     * @param fileName 
     *            要删除的文件名 
     * @return 删除成功返回true，否则返回false 
     */  
    public static boolean delete(String fileName) {  
        File file = new File(fileName);  
        if (!file.exists()) {  
            System.out.println("删除文件失败:" + fileName + "不存在！");  
            return false;  
        } else {  
            if (file.isFile())  
                return deleteFile(fileName);  
            else  
                return deleteDirectory(fileName);  
        }  
    }  

    /** 
     * 删除单个文件 
     * 
     * @param fileName 
     *            要删除的文件的文件名 
     * @return 单个文件删除成功返回true，否则返回false 
     */  
    public static boolean deleteFile(String fileName) {  
        File file = new File(fileName);  
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除  
        if (file.exists() && file.isFile()) {  
            if (file.delete()) {  
                System.out.println("删除单个文件" + fileName + "成功！");  
                return true;  
            } else {  
                System.out.println("删除单个文件" + fileName + "失败！");  
                return false;  
            }  
        } else {  
            System.out.println("删除单个文件失败：" + fileName + "不存在！");  
            return false;  
        }  
    }  

    /** 
     * 删除目录及目录下的文件 
     * 
     * @param dir 
     *            要删除的目录的文件路径 
     * @return 目录删除成功返回true，否则返回false 
     */  
    public static boolean deleteDirectory(String dir) {  

        File dirFile = new File(dir);  
        // 如果dir对应的文件不存在，或者不是一个目录，则退出  
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {  
            System.out.println("删除目录失败：" + dir + "不存在！");  
            return false;  
        }  
        boolean flag = true;  
        // 删除文件夹中的所有文件包括子目录  
        File[] files = dirFile.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            // 删除子文件  
            if (files[i].isFile()) {  
                flag = deleteFile(files[i].getAbsolutePath());  
                if (!flag)  
                    break;  
            }  
            // 删除子目录  
            else if (files[i].isDirectory()) {  
                flag = deleteDirectory(files[i]  
                        .getAbsolutePath());  
                if (!flag)  
                    break;  
            }  
        }  
        if (!flag) {  
            System.out.println("删除目录失败！");  
            return false;  
        }  
        // 删除当前目录  
        if (dirFile.delete()) {  
            System.out.println("删除目录" + dir + "成功！");  
            return true;  
        } else {  
            return false;  
        }  
    }  
	
	public interface IBuiltinStrogeStateListener{
		public void getOverallUsage(long total, long avail, List<UsageInfo> mUsageInfos);
		public void onDelFinish();
	}
	
}

