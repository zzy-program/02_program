package com.ft2.testcase;

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

public class testcase {
	private final static String TAG = "ft2_testcase";

	public static void tc_stack_trace() {
		Log.e(TAG, "stack trace\n");
		Log.e(TAG, Log.getStackTraceString(new Throwable()));
	}
}
