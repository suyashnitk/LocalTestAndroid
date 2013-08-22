package com.example.gittestproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 * @author Suyash
 *
 */
public class SharedPrefUtils {

	private static SharedPreferences myPrefs;
	public static final String AUTH_TOKEN = "authToken";
	public static final String LOGIN_USERNAME = "loginUsername";
	public static final String LOGIN_PASSWORD = "loginPassword";
	public static final String DEVICE_DENSITY = "deviceDensity";
	public static final String DEVICE_WIDTH_PX = "deviceWidthPx";
	public static final String SERVER_URL = "serverURL";
	public static final String SERVER_IP = "serverIP";
	public static final String SERVER_PORT = "serverPort";
	public static final String SERVER_TYPE = "serverType";
	public static final String SESSION_EXPIRED = "sessionExpired";
	public static final String USER_ROLE = "userRole";
	public static final String USER_ID = "userId";
	public static final String USER_FNAME = "userFName";
	public static final String USER_LNAME = "userLName";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_TELEPHONE = "userTelephone";
	public static final String USER_MOBILE = "userMobile";
//	public static final String TODO_COUNT = "todoCount";
	public static final String REMEMBER_ME = "rememberMe";
//	public static final String PUSH_CALENDAR_EVENTS = "pushCalendarEvents";
//	public static final String DELETE_EXPIRED_EVENTS = "deleteExpiredEvents";
	public static final String USER_PERMISSIONS = "userPermissions";
	
	/**
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void writeToSharedPref(Context context, String key,
			String value) {

		if (myPrefs == null)
			myPrefs = context.getSharedPreferences(
					Constants.TALENTPOOL_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = myPrefs.edit();
		if (value.equalsIgnoreCase("")) value = null;
		prefsEditor.putString(key, value);
		prefsEditor.commit();
	}
	
	public static void writeToSharedPref(Context context, String key,
			int value) {

		if (myPrefs == null)
			myPrefs = context.getSharedPreferences(
					Constants.TALENTPOOL_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = myPrefs.edit();
		prefsEditor.putInt(key, value);
		prefsEditor.commit();
	}
	
	public static void writeToSharedPref(Context context, String key,
			Boolean value) {

		if (myPrefs == null)
			myPrefs = context.getSharedPreferences(
					Constants.TALENTPOOL_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = myPrefs.edit();
		prefsEditor.putBoolean(key, value);
		prefsEditor.commit();
	}

	/**
	 * 
	 * @param context
	 * @param key
	 * @return String corresponding to the input key
	 */
	public static String getFromSharedPreference(Context context, String key) {

		if (myPrefs == null)
			myPrefs = context.getSharedPreferences(
					Constants.TALENTPOOL_SHARED_PREF, Context.MODE_PRIVATE);
		return myPrefs.getString(key, null);
	}
	
	public static int getIntFromSharedPreference(Context context, String key) {

		if (myPrefs == null)
			myPrefs = context.getSharedPreferences(
					Constants.TALENTPOOL_SHARED_PREF, Context.MODE_PRIVATE);
		return myPrefs.getInt(key, 0);
	}
	
	public static boolean getBoolFromSharedPreference(Context context, String key) {

		if (myPrefs == null)
			myPrefs = context.getSharedPreferences(
					Constants.TALENTPOOL_SHARED_PREF, Context.MODE_PRIVATE);
		return myPrefs.getBoolean(key, false);
	}
}
