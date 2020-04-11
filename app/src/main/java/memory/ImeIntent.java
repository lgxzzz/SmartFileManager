package memory;

public class ImeIntent {

	public static final String ACTION_ASSIST_VOL_ADD_VOICE = "ime.service.intent.action.ACTION_ASSIST_VOL_ADD_VOICE ";

	public static final String ACTION_ASSIST_VOL_REDUCE_VOICE = "ime.service.intent.action.ACTION_ASIST_VOL_REDUCE_VOICE ";

	public static final String ACTION_ASSIST_VOL_ADD = "ime.service.intent.action.ACTION_ASSIST_VOL_ADD";
	public static final String ACTION_ASSIST_VOL_REDUCE = "ime.service.intent.action.ACTION_ASIST_VOL_REDUCE";

	public static final String CLOSE_RECORDER_PREVIEW_CAMERA_ACTION = "ime.smart.driving.close.recorder.preview.camera_action";
	// 微信录音开启
	public static final String ACTION_RECORDWIN_SHOW = "wx.action.recordwin.show";
	// 微信录音结束
	public static final String ACTION_RECORDWIN_DISMISS = "wx.action.recordwin.dismiss";
	// 启动语音界面
	public static final String ACTION_VOICE_COMPLAIN = "ime.smart.driving.set.voice.command.SESSION";
	// 同行者
	public static final String ACTION_TXZ_MUSIC_SEND = "ime.service.intent.action.ACTION_TXZ_MUSIC_SEND ";
	// 同行者
	public static final String ACTION_TXZ_MUSIC_RECEIVER = "ime.service.intent.action.ACTION_TXZ_MUSIC_RECEIVER ";
	//发送同听歌曲信息
	public static final String ACTION_TXZ_MUSIC_INFO="ime.service.intent.action.ACTION_TXZ_MUSIC_INFO";
	// 集成控制收音命令
	public static String IME_ACTION_RADIO_CMD = "ime.intent.comcore.IME_ACTION_RADIO_CMD";
	public static final int RADIO_CMD_STOP = 0;// 收音暂停
	public static final int RADIO_CMD_PLAY = 1;// 收音播放
	public static final int RADIO_CMD_LAST = 2;// 上一台
	public static final int RADIO_CMD_NEXT = 3;// 下一台

	// 语音界面起来
	public static final String ACTION_TXZ_RECORD_SHOW = "com.txznet.txz.record.show";
	// 语音界面关闭
	public static final String ACTION_TXZ_RECORD_DISMISS = "com.txznet.txz.record.dismiss";
	// 打开后视
	public static final String ACTION_VOICE_OPEN_RECORDER_BACKVIEW = "ime.service.intent.action.voice.open.recorder.backview";
	//
	public static final String ACTION_RELOAD_POLICY_VOLUME = "com.ime.intent.ACTION_RELOAD_POLICY_VOLUME";
	// 倒车
	public static final String ACTION_REVERSE_STATE = "ime.service.intent.action.ACTION_REVERSE_STATE";
	// public static final String ACTION_REVERSE_STATE =
	// "ime.service.intent.action.ACTION_REVERSE_STATE"; // 双路倒车
	// TXZCore监听广播
	public static final String ACTION_ONWAKEUP = "com.txznet.txz.onWakeup";

	// wxx--
	public static final String UNDERSTANDER_MAP = "ime.intent.action.nlu.UNDERSTANDER_MAP";
	// MAP :地图定位，导航
	// operation:<locate><route>
	// param[0]=start //address string
	// param[1]=end //address string
	// param[2]=routine_tyupe

	public static final String UNDERSTANDER_MOTOR_VIOLATION = "ime.intent.action.nlu.UNDERSTANDER_MOTOR_VIOLATION";
	// DRIVER_POINT:机动车违章
	// param[0]=plate_number
	// param[1]=engine_number

	public static final String UNDERSTANDER_MOTOR_RADIO = "ime.intent.action.nlu.UNDERSTANDER_MOTOR_RADIO";
	// RADIO：收音机
	// operation:<launch>
	// param[0]=name 电台名称
	// param[1]=code 电台频点
	// param[2]=category FM/AM
	// param[3]=modifer 节目类别

	public static final String MACHINE_SETTING = "ime.intent.action.nlu.MACHINE_SETTING";
	// key 0：operation，设置相关的操作,up(增大)、down（减小）、on（打开）、off（关闭）、停止（stop）
	// key 1：name，
	// 操作对象edog（电子狗）、radar（雷达）、complaint（投诉）、burglar（防盗）、city（城市）、mute（静音）、suburbs（郊区）
	// navi(导航)、playbackVideo（回放录像）、latchVideo（锁存录像）、shareLocation(分享位置)、collectLocation(收藏位置)、
	// homeLocation(设置为家里)、schoolLocation(设置为学校)、
	// companyLocation(设置为公司)、takePhoto（拍照）

	/****************************
	 * 命令说明（operation，name） ***********************************
	 * 录像相关：回放录像（on，playbackVideo），锁存录像（on，latchVideo）
	 * 拍照（on，takePhoto）--拍照后回传照片文件名 导航相关：停止导航（
	 * stop，navi），分享位置（on，shareLocation），收藏当前位置（on，collectLocation）
	 * 当前位置设置为家里（on，homeLocation）， 当前位置设置为学校（on，schoolLocation），
	 * 当前位置设置为公司（on，companyLocation），
	 * 电子狗相关：打开雷达（on，radar），关闭雷达（off，radar），打开电子狗（
	 * on，edog），关闭电子狗（off，edog），投诉（on，complaint） 设置为城市模式（on，city），
	 * 设置为安静模式（on，mute
	 * ），设置为郊区模式（on，suburbs），提高防盗等级（up，burglar），降低防盗等级（down，burglar）
	 * 
	 ***************************************************************************/

	// added by max

	public static final String ACTION_START_COUNTDOWN_ACTIVITY = "ime.service.intent.action.ACTION_START_COUNTDOWN_ACTIVITY";
	public static final String ACTION_CANCEL_COUNTDOWN_ACTIVITY = "ime.service.intent.action.ACTION_CANCEL_COUNTDOWN_ACTIVITY";
	public static final String ACTION_ENTER_SAFEGUARD_MODE = "ime.service.intent.action.ACTION_ENTER_SAFEGUARD_MODE";
	public static final String ACTION_EXIT_SAFEGUARD_MODE = "ime.service.intent.action.ACTION_EXIT_SAFEGUARD_MODE";
	// countdown activity send action to ime service to entern safeguard mode
	public static final String ACTION_SHUTDOWN_SYSTEM = "ime.service.intent.action.ACTION_SHUTDOWN_SYSTEM";
	public static final String ACTION_UPDATER_INFO = "ime.service.intent.action.ACTION_UPDATER_INFO";

	// new message coming
	public static final String ACTION_NEW_IME_MESSAGE_COMMING = "ime.service.intent.action.ACTION_NEW_IME_MESSAGE_COMMING";
	// when some new message coming

	public static final String ACTION_DISPLAY_GUIDE = "ime.service.intent.action.ACTION_DISPLAY_GUIDE";
	// 获取二维码
	public static final String ACTION_IDQCODE_REQ = "ime.service.intent.action.ACTION_IDQCODE_REQ";
	public static final String ACTION_IDQCODE = "ime.service.intent.action.ACTION_IDQCODE";
	// param=String[] ; param[0]=path QCODE file path

	public static final String ACTION_UNDERSTANDER_START_WORK = "ime.service.intent.action.UNDERSTANDER_START_WORK";
	public static final String ACTION_UNDERSTANDER_STOP_WORK = "ime.service.intent.action.UNDERSTANDER_STOP_WORK";

	public static final String ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
	public static final String ACTION_START_NAVI_SELECT_INDEX_MODE = "ime.service.intent.action.ACTION_START_NAVI_SELECT_INDEX_MODE";
	public static final String ACTION_EXIT_NAVI_SELECT_INDEX_MODE = "ime.service.intent.action.ACTION_EXIT_NAVI_SELECT_INDEX_MODE";
	public static final String ACTION_RECIVE_NAVI_SELECT_INDEX_MODE = "ime.service.intent.action.ACTION_RECIVE_NAVI_SELECT_INDEX_MODE";
	public static final String ACTION_VOICE_WHIRL_SHOW = "ime.service.intent.action.ACTION_VOICE_WHIRL_SHOW";
	public static final String ACTION_START_RECORD_REPORT = "ime.service.intent.action.ACTION_START_RECORD_REPORT";
	public static final String ACTION_COLLECT_LINE = "ime.intent.action.nlu.COLLECT_LINE";
	public static final String ACTION_LOCK_VIDEO = "ime.intent.action.nlu.LOCK_VIDEO";

	public static final String ACTION_NAVI_TTS_START = "ime.service.intent.action.NAVI_TTS_START";
	public static final String ACTION_NAVI_TTS_COMPELETE = "ime.service.intent.action.NAVI_TTS_COMPELETE";
	public static final String ACTION_TTS_SPEACK = "ime.service.intent.action.TTS_SPEACK";

	public static final String ACTION_VOICE_HELPER_EXIST = "ime.service.intent.action.ACTION_VOICE_HELPER_EXIST";// 语音助手关闭
	public static final String ACTION_VOICE_HELPER_SHOW = "ime.service.intent.action.ACTION_VOICE_HELPER_SHOW";// 语音助手显示

	public static final String ACTION_WECHAT_HELPER_EXIST = "ime.service.intent.action.ACTION_WECHAT_HELPER_EXIST";// 微信助手关闭
	public static final String ACTION_WECHAT_HELPER_SHOW = "ime.service.intent.action.ACTION_WECHAT_HELPER_SHOW";// 微信助手显示

	public static final String ACTION_NAVIGATE_TO = "com.ime.intent.action.ACTION_NAVIGATE_TO";// 选择地址后发出的广播
	public static final String ACTION_POI_SEARCH_RESULT = "ime.intent.action.ACTION_POI_SEARCH_RESULT";
	public static final String ACTION_BT_MAKECALL = "ime.intent.action.bt.ACTION_BT_MAKECALL";// 打电话
	public static final String ACTION_SELECT_ITEM = "ime.intent.action.ACTION_SELECT_ITEM";
	public static final String ACTION_SELECT_ADDR = "ime.intent.action.ACTION_SELECT_ADDR";

	public static final String MusicBrowserActivity = "com.android.music.MusicBrowserActivity";
	// for bluetooth: when call is established,release all wakeup,recognizer
	// without any condition
	public static final String ACTION_EXIT_SPEECH_SYSTEM = "com.ime.service.intent.ACTION_EXIT_SPEECH_SYSTEM";

	public static final String ACTION_START_BY_WAKEUP = "com.ime.service.intent.ACTION_START_BY_WAKEUP";
	public static final String ACTION_START_WAKEUP_LISTENER = "com.ime.service.intent.ACTION_START_WAKEUP_LISTENER";
	public static final String ACTION_SHOW_PROMPT_INFO = "com.ime.service.intent.ACTION_SHOW_PROMPT_INFO";

	public static final String ACTION_IMPORT_FINISHED = "ime.service.intent.action.bt.onImportFinished";// 电话本导入完成

	public static final String ACTION_DIAL_SELECT = "ime.service.intent.action.intent.ACTION_DIAL_SELECT";// 电话号码选择
	public static final String ACTION_DIAL_CANCEL = "ime.service.intent.action.intent.ACTION_DIAL_CANCEL";// 取消拨号

	public static final String ACTION_FLOAT_MAIN_UI_STATE_CHANGE = "ime.service.intent.ACTION_FLOAT_TOOLBAR_STATE_CHANGE";// toolbar状态
	public static final String ACTION_BT_MAKE_BT_CALL = "ime.intent.action.bt.ACTION_BT_MAKE_BT_CALL";

	public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.headsetclient.profile.action.CONNECTION_STATE_CHANGED";

	public static final String ACTION_CALL_CHANGED = "android.bluetooth.headsetclient.profile.action.AG_CALL_CHANGED";

	public static final String ACTION_BT_ACCEPT = "ime.intent.action.bt.ACTION_BT_ACCEPT"; // 接听来电
	public static final String ACTION_BT_REJECT = "ime.intent.action.bt.ACTION_BT_REJECT"; // 拒绝来电
	public static final String ACTION_NOTIFICATION_CALL_REJECT = "com.autochips.bluetooth.BluetoothReceiver.ACTION.ACTION_NOTIFICATION_CALL_REJECT";
	public static final String ACTION_NOTIFICATION_CALL_ACCEPT = "com.autochips.bluetooth.BluetoothReceiver.ACTION.ACTION_NOTIFICATION_CALL_ACCEPT";

	public static final String ACTION_INCOMING_CALL_INFO = "ime.service.intent.action.ACTION_INCOMING_CALL_INFO";// 来电名字等

	public static final String ACTION_TV_CAMERA_ON = "ime.service.intent.action.ACTION_TV_CAMERA_ON"; // 打开倒车后视
	public static final String ACTION_TV_CAMERA_OFF = "ime.service.intent.action.ACTION_TV_CAMERA_OFF"; // 关闭倒车后视
	public static final String ACTION_TV_CAMERA_STATE = "ime.service.intent.action.ACTION_TV_CAMERA_STATE";

	public static final String ACTION_SETTING_CHANGED = "ime.service.intent.action.ACTION_SETTING_CHANGED";// 设置更改
	public static final String ACTION_TURN_ON_REAL_NAVIGATION = "ime.service.intent.action.ACTION_TURN_ON_REAL_NAVIGATION";// 实景导航
	public static final String ACTION_TURN_ON_SIMPLE_NAVIGATION = "ime.service.intent.action.ACTION_TURN_ON_SIMPLE_NAVIGATION";// 简易导航
	public static final String ACTION_SET_NAVI_DUAL_SCREEN_MODE = "ime.intent.action.ACTION_SET_NAVI_DUAL_SCREEN_MODE";

	public static final String ACTION_VOICE_CMD_REGISTER = "ime.service.intent.action.ACTION_VOICE_CMD_REGISTER";//
	public static final String ACTION_VOICE_CMD_FILTER_REGISTER = "ime.service.intent.action.ACTION_VOICE_CMD_FILTER_REGISTER";//

	public static final String ACTION_VOICE_UNDERSTAND_NOTIFY = "ime.service.intent.action.ACTION_VOICE_UNDERSTAND_NOTIFY";//
	public static final String ACTION_VOICE_UNDERSTAND_CONFIRM = "ime.service.intent.action.ACTION_VOICE_UNDERSTAND_CONFIRM";//

	public static final String ACTION_EXIT_IME_MUSIC = "ime.service.intent.action.ACTION_EXIT_IME_MUSIC";
	public static final String ACTION_VOICE_STATISTIC = "ime.service.intent.action.ACTION_VOICE_STATISTIC";

	public static final String ACTION_START_TALK_APP = "ime.service.intent.action.ACTION_START_TALK_APP";// open
	// wei
	// mi
	public static final String ACTION_EXIT_TALK_APP = "ime.service.intent.action.ACTION_EXIT_TALK_APP";// close
	// wei
	// mi

	public static final String ACTION_SPEECH_ENTER = "ime.service.intent.action.ACTION_SPEECH_ENTER";
	public static final String ACTION_SPEECH_EXIT = "ime.service.intent.action.ACTION_SPEECH_EXIT";

	public static final String ACTION_VOICE_EVENT = "ime.service.intent.action.VOICE_EVENT";// 点击事件
	public static final String ACTION_LAST_PAGE = "ime.service.intent.action.ACTION_LAST_PAGE";
	public static final String ACTION_NEXT_PAGE = "ime.service.intent.action.ACTION_NEXT_PAGE";
	public static final String ACTION_LBS_INFO_CURRENTCITY = "ime.service.intent.action.ACTION_LBS_INFO_CURRENTCITY";
	public static final String ACTION_VOICE_OPEN_APP = "ime.smartdriving.ACTION_VOICE_OPEN_APP";
	public static final String ACTION_COMPLAINT_OVER = "ime.service.intent.action.ACTION_COMPLAINT_OVER";
	public static final String ACTION_NIGHT_VISION = "ime.service.intent.action.ACTION_NIGHT_VISION";
	public static final String ACTION_RECORDER_OPERATE = "ime.service.intent.action.ACTION_RECORDER_OPERATE";
	public static final String ACTION_TXZ_SHUTDOWN_REQ = "android.intent.action.ACTION_TXZ_SHUTDOWN_REQ";

	public static final String ACTION_IME_MUSIC_START = "com.ime.intent.action.ACTION_EXIT_IME_MUSIC_START";
	public static final String ACTION_IME_MUSIC_END = "com.ime.intent.action.ACTION_EXIT_IME_MUSIC_END";
	public static final String ACTION_IME_NOTICE_DIALOG_STATE = "com.ime.intent.action.ACTION_IME_NOTICE_DIALOG_STATE";
	public static final String ACTION_IME_PLAY_VIDEO = "com.ime.intent.action.ACTION_IME_PLAY_VIDEO";
	public static final String ACTION_BT_NAME = "com.ime.imebt.action.bt.ACTION_BT_NAME";
	public static final String ACTION_SET_FM_TX = "ime.service.intent.action.ACTION_SET_FM_TX";
	public static final String ACTION_IME_FORCE_STOP_PACKAGES = "com.ime.service.intent.ACTION_IME_FORCE_STOP_PACKAGES";
	public static final String ACTION_INTERRUPT_TTS = "ime.service.intent.action.ACTION_INTERRUPT_TTS";
	public static final String ACTION_IME_REQUEST_OPEN_ECAR_APP = "ime.intent.action.ACTION_IME_REQUEST_OPEN_ECAR_APP";
	public static final String ACTION_OPEN_NAVIGATOR = "com.ime.service.intent.ACTION_OPEN_NAVIGATOR";

	public static final String ACTION_WIFI_HOTSPOT = "ime.service.intent.action.ACTION_WIFI_HOTSPOT"; // WIFI热点
	public static final String ACTION_PROCESS_PRIORITY = "ime.service.intent.action.ACTION_PROCESS_PRIORITY";
	public static final String ACTION_BACKLIGHT_REQ = "com.ime.intent.action.ACTION_BACKLIGHT_REQ";// 新定义的发给你的开关屏命令
	public static final String ACTION_VNOTE_ADD_REMIND = "ime.service.intent.action.ACTION_VNOTE_ADD_REMIND";
	public static final String ACTION_VOICE_TO_WECHAT = "ime.service.intent.action.ACTION_VOICE_TO_WECHAT";
	public static final String ACTION_WECHAT_TO_VOICE = "ime.service.intent.action.ACTION_WECHAT_TO_VOICE";
	public static final String ACTION_UI_TO_WECHAT = "ime.service.intent.action.ACTION_UI_TO_WECHAT";
	public static final String ACTION_WEICHAT_CONTACTS = "ime.service.intent.action.ACTION_WEICHAT_CONTACTS";
	public static final String ACTION_BACK_HOME_SCREEN = "ime.service.intent.action.ACTION_BACK_HOME_SCREEN";
	public static final String ACTION_OPEN_MUSIC_PLAYER = "ime.service.intent.action.ACTION_OPEN_MUSIC_PLAYER";

	public static final String ACTION_NOTIFICATION_TV_START = "ime.service.intent.ACTION_NOTIFICATION_TV_START";// tv
	// start
	public static final String ACTION_NOTIFICATION_TV_CLOSE = "ime.service.intent.ACTION_NOTIFICATION_TV_CLOSE";
	public static final String ACTION_VOICE_CONTROL_FATIGUE_DETECTOR = "ime.service.intent.action.ACTION_VOICE_CONTROL_FATIGUE_DETECTOR"; // 语音控制疲劳驾驶检测
	public static final String ACTION_SHARE_MEDIA = "ime.service.intent.action.ACTION_SHARE_MEDIA";// 分享视频
	public static final String ACTION_UPLOAD_MEDIA = "ime.service.intent.action.ACTION_UPLOAD_MEDIA";// 上传视频

	public static final String ACTION_OPERATE_AIRCONDITION = "ime.service.intent.action.ACTION_OPERATE_AIRCONDITION";// 空调操作

	public static final String ACTION_SWITCH_AUDIO_MODE = "ime.service.intent.action.ACTION_SWITCH_AUDIO_MODE";// 切换音效模式

	public static final String ACTION_LOCALFM_CMD = "ime.service.intent.action.ACTION_LOCALFM_CMD";// 车机
	// FM
	// 指令
	public static final String ACTION_BACKLIGHT_CONTROL = "com.ime.intent.action.ACTION_BACKLIGHT_CONTROL";// 开关屏
	public static final String ACTION_VOICE_OPERATE_REQUSET = "ime.intent.action.ACTION_VOICE_OPERATE_REQUSET"; /* 语音操作请求 */
	public static final String ACTION_VOICE_OPERATE_RESPONSE = "ime.intent.action.ACTION_VOICE_OPERATE_RESPONSE";/* 语音操作回复 */
	public static final String ACTION_FM_CRB_TTS = "com.szcx.ecamera.tts";// 车悦宝TTS

	public static final String ACTION_ORDER_SELECT = "ime.intent.action.ACTION_ORDER_SELECT";
	public static final String ACTION_EXIT_SPEECH_DIALOG = "ime.service.intent.action.ACTION_EXIT_SPEECH_DIALOG";
	public static final String ACTION_TTS_PROGRESS = "ime.voice.intent.action.ACTION_TTS_PROGRESS";
	public static final String ACTION_NOTITY_VOICE_MUTE = "ime.service.intent.action.ACTION_NOTITY_VOICE_MUTE";
	public static final String ACTION_REQUEST_VOICE_MUTE = "ime.service.intent.action.ACTION_REQUEST_VOICE_MUTE";
	public static final String ACTION_VOICE_COMMAND = "ime.service.intent.action.ACTION_VOICE_COMMAND";

	public static final String ACTION_IME_OBD_COMMAND = "ime.service.intent.action.ACTION_IME_OBD_COMMAND";// ime
	// obd
	// cmd
	public static final String ACTION_NAVIGATOR_CMD_DISPATCHER = "ime.intent.action.ACTION_NAVIGATOR_CMD_DISPATCHER"; /* 地图操作命令调度 */
	public static final String ACTION_SET_IME_VOLUME = "ime.intent.action.setvolume";

	public static final String ACTION_MUSIC_COMMAND = "ime.service.intent.action.ACTION_MUSIC_COMMAND";
	public static final String ACTION_MUSIC_COMMAND_RESPONSE = "ime.service.intent.action.ACTION_MUSIC_COMMAND_RESPONSE";

	// 来电时蓝牙断开连接通知
	public static final String ACTION_INCOMING_CALL_DISCONNECTED = "ime.service.intent.action.ACTION_INCOMING_CALL_DISCONNECTED";
	public static final String ACTION_HOME_PRESSED = "ime.service.intent.action.ACTION_HOME_PRESSED";// OK
	public static final String ACTION_UPDATE_NEARBY_INFORMATION = "ime.intent.action.ACTION_UPDATE_NEARBY_INFORMATION";
	public static final String ACTION_UPDATE_NEARBY_INFORMATION_RESPONSE = "ime.intent.action.ACTION_UPDATE_NEARBY_INFORMATION_RESPONSE";
	//ACC状态广播
	public static final String ACTION_IME_ACC_STATE = "com.intent.action.ACTION_IME_ACC_STATE";
	
	public static final String ACTION_AUTO_NAVI_REPORT_TASK = "ime.service.intent.action.ACTION_AUTO_NAVI_REPORT_TASK";
	public static final String ACTION_TAKE_PICTURE = "ime.service.intent.action.ACTION_TAKE_PICTURE";
	public static final String SET_RECORDER_PREVIEW_CAMERA_ACTION = "ime.smart.driving.set.recorder.preview.camera_action";
	public static final String ACTION_START_ONE_KEY_SAVE_RECORD = "ime.intent.action.ACTION_START_ONE_KEY_SAVE_RECORD";

}
