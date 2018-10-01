
//package android.os;
package com.htc.testshmem;

import android.os.Bundle;
import android.os.MemoryFile;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import android.os.Build;
//import android.os.SystemProperties;
//import java.util.Scanner;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mBtnWrite = null;
    private Button mBtnClose = null;
    private Button mBtnRefresh = null;
    private TextView mTxthmem = null;
    private EditText mEditText =null;
    private MemoryFile mMemoryFile = null;
    private Properties mProperties = null;
    public static final int MAX_INT_VALUE = 2147483647;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnWrite = (Button)findViewById(R.id.button_write);
        mBtnClose = (Button)findViewById(R.id.button_close);
        mBtnRefresh = (Button)findViewById(R.id.button_refresh);
        mTxthmem = (TextView)findViewById(R.id.shmem);
        mEditText = (EditText)findViewById(R.id.EditTxtShmem);
        mEditText.setSelection(mEditText.length());
        mBtnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mBtnWrite.onClick");
                WriteShmem();
                ShowShmemView();
            }
        });

        mBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mBtnClose.onClick");
                ResetShmem();
                ShowShmemView();
            }
        });

        mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowShmemView();
            }
        });
        ShowShmemView();
    }

    private void WriteShmem(){
        if(mMemoryFile == null)
        {
            try{
                String mStrFileBytesLength = mEditText.getText().toString();
                int mFileBytesLength = Integer.valueOf(mStrFileBytesLength).intValue();
                Log.d(TAG, "WriteShmem  mFileBytesLength=  "+mFileBytesLength);
                mMemoryFile = new MemoryFile("Test Shmem File", mFileBytesLength);
            }catch (IOException e){
                e.printStackTrace();
            }catch (NumberFormatException e)
            {
                Toast.makeText(this, "NumberFormatException exception", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }

        ///no need write
    }

    private void ResetShmem(){
        if(mMemoryFile != null)
        {
            Log.d(TAG, "ResetShmem");
            mMemoryFile.close();
            mMemoryFile = null;
        }
        mEditText.setText("");
    }

    private void ShowShmemView(){
            String brand_prop = "brand_init";
            String mStrShmemSize = Build.BRAND;
            String bootloader = "bootloader_init";

            brand_prop = get("ro.product.brand", "brand_zzytest");
            bootloader = get("ro.bootloader", "bootloader_default");
            // brand_prop += "abc";
            Log.d(TAG, "ShowShmemView  mStrShmemSize=  " + mStrShmemSize + brand_prop);
            if (mStrShmemSize != null)
                mTxthmem.setText("Shmem: "+mStrShmemSize + " " + brand_prop + " " + bootloader);
    }

    private String getStrShmemSize()throws IOException{
        String mShmemStr = null;

        if(mProperties == null)
        {
            mProperties = new Properties();
        }

        try{
            mProperties.load(new FileInputStream("/proc/meminfo"));
            mShmemStr = mProperties.getProperty("Shmem");
        }catch (IOException e){
            e.printStackTrace();
        }

        return mShmemStr;
    }

    @Override
    protected void onDestroy() {

        Log.d(TAG, "onDestroy");
        if(mMemoryFile != null)
        {
            mMemoryFile.close();
            mMemoryFile = null;
        }
        super.onDestroy();
    }

    private static volatile Method set = null;
    private static volatile Method get = null;

    public static void set(String prop, String value) {

        try {
            if (null == set) {
                synchronized (MainActivity.class) {
                    if (null == set) {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        set = cls.getDeclaredMethod("set", new Class<?>[]{String.class, String.class});
                    }
                }
            }
            set.invoke(null, new Object[]{prop, value});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public static String get(String prop, String defaultvalue) {
        String value = defaultvalue;
        try {
            if (null == get) {
                synchronized (MainActivity.class) {
                    if (null == get) {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        get = cls.getDeclaredMethod("get", new Class<?>[]{String.class, String.class});
                    }
                }
            }
            value = (String) (get.invoke(null, new Object[]{prop, defaultvalue}));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return value;
    }

}
