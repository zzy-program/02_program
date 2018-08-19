package com.android.server.am;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import android.os.SystemClock;
import android.os.Process;

import android.util.Slog;
import android.util.Log;

import com.ft2.testcase.testcase;

public class ft2_service extends Thread {
	private final static String TAG = "ft2_tag";

	public void run() {
		while (true) {
			// ft2 service running
			Log.e(TAG, "ft2 service running\n");

			// 
			SystemClock.sleep(50);
			testcase.tc_stack_trace();
			SystemClock.sleep(5);
		}
	}

	public static void ft2_run() {
		(new ft2_service()).start();
	}
}
