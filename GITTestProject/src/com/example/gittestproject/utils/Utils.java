package com.example.gittestproject.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.BitSet;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

public class Utils {

	public static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;

	/**
	 * Checks if the device is connected to the Internet.
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isConnectedToInternet(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo() != null ? cm.getActiveNetworkInfo()
				.isConnectedOrConnecting() : false;
	}

	public static void updateHeader(final View relativeLayout) {
		LayerDrawable ld = (LayerDrawable) relativeLayout.getBackground();
		int topInset = relativeLayout.getHeight() / 2; // does not work!
		ld.setLayerInset(1, 0, topInset, 0, 0);
		setBackgroundOfView(ld, relativeLayout);
		ViewTreeObserver vto = relativeLayout.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				LayerDrawable ld = (LayerDrawable) relativeLayout
						.getBackground();
				ld.setLayerInset(1, 0, relativeLayout.getHeight() / 2, 0, 0);
			}
		});
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public static void setBackgroundOfView(Drawable drawable, View v) {
		if (CURRENT_SDK_VERSION >= Build.VERSION_CODES.JELLY_BEAN) {
			v.setBackground(drawable);
		} else {
			v.setBackgroundDrawable(drawable);
		}
	}

	public static Integer getPxInDpUnits(Context ctxt, Integer px) {
		float scale = ctxt.getResources().getDisplayMetrics().density;
		Integer dps = (int) ((px - 0.5) / scale);
		return dps;
	}

	public static Integer getDpInPxUnits(Context ctxt, Integer dps) {
		float scale = ctxt.getResources().getDisplayMetrics().density;
		Integer px = (int) (dps * scale + 0.5f);
		return px;
	}
	
	public static float getAccurateDpInPxUnits(Context ctxt, float dps) {
		float scale = ctxt.getResources().getDisplayMetrics().density;
		float dff = dps * scale + 0.5f;
		// Integer px = (int) Math.round(dff);
		return dff;
	}
	
	public static StateListDrawable getStateListDrawable(Context context, int selected, int normal) {
		Drawable btnPressed = context.getResources().getDrawable(selected);
		Drawable btnNormal = context.getResources().getDrawable(normal);
		StateListDrawable customTextButtonState = new StateListDrawable();
		customTextButtonState.addState(
				new int[] { android.R.attr.state_pressed }, btnPressed);
		customTextButtonState.addState(
				new int[] { -android.R.attr.state_selected }, btnNormal);
		customTextButtonState.addState(
				new int[] { android.R.attr.state_selected }, btnPressed);
		return customTextButtonState;
	}
	
	public static AlertDialog.Builder showAlert(Context ctxt, String title,
			String message, OnClickListener onOkButtonClickListener) {
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ctxt);

		if (message != null)
			alertBuilder.setMessage(message);
		if (title != null)
			alertBuilder.setTitle(title);

		alertBuilder.setNegativeButton(android.R.string.ok,
				onOkButtonClickListener);
		alertBuilder.setCancelable(false);
		alertBuilder.show();
		return alertBuilder;
	}
	
	public static AlertDialog.Builder showConfirmAlert(Context ctxt,
			String title, String message,
			OnClickListener onYesButtonClickListener,
			OnClickListener onNoButtonClickListener) {
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ctxt);

		if (message != null)
			alertBuilder.setMessage(message);
		if (title != null)
			alertBuilder.setTitle(title);

		alertBuilder.setPositiveButton("Yes", onYesButtonClickListener);
		alertBuilder.setNegativeButton("No", onNoButtonClickListener);
		alertBuilder.setCancelable(false);
		alertBuilder.show();
		return alertBuilder;
	}
	
	public static boolean isNullOrEmpty(String text) {
		return text == null || text.trim().length() == 0;
	}
	
	public static void setTXValue(TextView textView, String value) {
		if(!isNullOrEmpty(value)) {
			textView.setText(value);
		}
	}
	
	public static PermissionSet getPermissionBitSet(Context ctxt) {
		String perms = SharedPrefUtils
				.getFromSharedPreference(ctxt,
						SharedPrefUtils.USER_PERMISSIONS);
		String[] split = perms.split(Constants.VALUE_COMMA);
		final int length = split.length;
		BitSet bs = new BitSet(length);
		for (int i = 0; i < length; i++) {
			bs.set(Integer.parseInt(split[i].trim()), true);
		}
		return new PermissionSet(bs);
	}
	
	public static void appendLog(String text, Context context) {
		try {
			File dir = new File (context.getFilesDir()+"/response");
			dir.mkdirs();
			File myFile = new File(dir,"TalentpoolCatche.txt");
//			System.out.println("context.getFilesDir()="+myFile.getAbsolutePath());
			boolean createNewFile = myFile.createNewFile();
//			System.out.println("createNewFile="+createNewFile);	
//			FileOutputStream fOut = new FileOutputStream(myFile);
//			OutputStreamWriter myOutWriter = 
//									new OutputStreamWriter(fOut);
//			myOutWriter.append(text);
//			myOutWriter.close();
//			fOut.close();
//			FileOutputStream fos1 =	context.openFileOutput("golg786.txt", Context.MODE_PRIVATE);
//			fos1.write(text.getBytes());
//			fos1.close();
			
			
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(text.getBytes());
			fos.close();
			
			
//			System.out.println("Done writing SD 'mysdfile.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Find all views by common tags
	public static ArrayList<View> getViewsByTag(ViewGroup root, String tag){
        ArrayList<View> views = new ArrayList<View>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tag));
            }

            final Object tagObj = child.getTag();
            if (tagObj != null && tagObj.equals(tag)) {
                views.add(child);
            }
        }
        return views;
    }
    
	//Find all views by common ids
//	public static ArrayList<View> getViewsById(ViewGroup root, int id){
//        ArrayList<View> views = new ArrayList<View>();
//        final int childCount = root.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            final View child = root.getChildAt(i);
//            if (child instanceof ViewGroup) {
//                views.addAll(getViewsById((ViewGroup) child, id));
//            }
//
//            final int viewId = child.getId();
//            if (viewId != 0 && viewId == id) {
//                views.add(child);
//            }
//        }
//        return views;
//    }
}