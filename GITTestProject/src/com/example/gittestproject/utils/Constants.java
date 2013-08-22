package com.example.gittestproject.utils;


public class Constants {

	// URL's and DOMAIN's
	// public static final String SERVER_URL =
	// "http://172.19.129.107:9090/talentpool-api/rest/mobile/";
	// public static final String SERVER_URL_OLD =
	// "http://172.19.129.107:9090/talentpool-api/rest/";

	// Shared prefs file name
	public static final String TALENTPOOL_SHARED_PREF = "talentpoolPrefs";
	
	public static final String TALENTPOOL_SERVER_URL_PART = "/talentpool-api/rest/mobile/";

    public final static String BUG_SENSE_API_KEY = "174bf1dd";
		
	// Port details
	public static final int PORT_NUMBER_HTTP = 9090;
	public static final int PORT_NUMBER_HTTPS = 443;

	// Splash Screen Time limit
	public static final int SPLASH_TIME_OUT = 2000;// in msec

	// Connection Variables
	public static final int TIMEOUT_SOCKET = 30000;
	public static final int TIMEOUT_CONNECTION = 30000;

	// Utility variables
	public static final String VALUE_NONE = "";
	public static final String VALUE_NA = "NA";
	public static final String VALUE_COMMA = ",";
	public static final String VALUE_SPACE = " ";
	public static final String VALUE_EMPTY_ARRAY = "[]";
	public static final String VALUE_HTML_TAG = "<html>";

	// Utility variables
	public static final int CURVE_RADIUS_HOME = 5;
	public static final int CURVE_RADIUS_POSITION = 3;

	// layout id which repeats over one another
//	public final static int M_LAYOUT_ID = R.id.flyt_replace_item;

	public final static String SERVER_DATE_FORMAT = "dd/MM/yyyy";
	public final static String SERVER_DATE_FORMAT_MESSAGES = "yyyy-MM-dd HH:mm:ss.SSS";
	public final static String SERVER_DATE_FORMAT_MESSAGES2 = "dd MMM yy";
	//Web Portal constants
	public static final String FEEDBACK_ACTION_REJECT = "0";
	public static final String FEEDBACK_ACTION_APPROVE = "1";
	public static final String FEEDBACK_ACTION_HOLD = "2";
	
	public static final int FEEDBACK_ACTION_REJECT_VALUE = 0;//Integer.parseInt(FEEDBACK_ACTION_REJECT);
	public static final int FEEDBACK_ACTION_APPROVE_VALUE = 1;//Integer.parseInt(FEEDBACK_ACTION_APPROVE);
	public static final int FEEDBACK_ACTION_HOLD_VALUE = 2;//Integer.parseInt(FEEDBACK_ACTION_HOLD);
	
	public static final int FEEDBACK_FIELD_TYPE_HEADING = 0;
	public static final int FEEDBACK_FIELD_TYPE_QUESTION = 1;

	public static final int ACTION_REQUIRED_REQUISITION_APPROVAL = 1;
	public static final int ACTION_CLEAR_DRAFT = 2;
	public static final int ACTION_ON_CONDUCT = 3;
	public static final int ACTION_REQUIRED_CONFIRM_ATTENDANCE = 4;
	public static final int ACTION_REQUIRED_FEEDBACK = 5;
	public static final int ACTION_ON_HOLD = 6;
	public static final int ACTION_REQUIRED_SCHEDULE = 7;
	public static final int ACTION_REQUIRED_BUDGET_APPROVAL = 8;

	public final static int MESSAGES_PAGE_SIZE = 50;
	
	//Feedback Form 'move to other position' id should be constant always on both sides
	public final static int FEEDBACK_MOVE_POSITION_ID = -11;
	
//	public static final String MSG_NO_INTERNET_ACCESS = "Application requires active internet connection. Transaction cannot proceed without it.";

	public static final String[] suffixes =
	// 0 1 2 3 4 5 6 7 8 9
	{ "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
			// 10 11 12 13 14 15 16 17 18 19
			"th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
			// 20 21 22 23 24 25 26 27 28 29
			"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
			// 30 31
			"th", "st" };

}
