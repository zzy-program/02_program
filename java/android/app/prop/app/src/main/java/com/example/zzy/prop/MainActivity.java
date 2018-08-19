package com.example.zzy.prop;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;
import java.lang.reflect.Method;
import android.os.Build;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_property();
    }

    private void show_property(){

        String text;
        String brand_prop = "Build.BOARD=";
        // Build.BRAND;
        String bootloader = "Build.BOOTLOADER=";

        TextView textElement = (TextView) findViewById(R.id.this_is_id_name);

        brand_prop += get("ro.product.brand", "brand_zzytest") + "\n";
        bootloader += get("ro.bootloader", "bootloader_default") + "\n";
        text = brand_prop + bootloader;

        Log.d(TAG, "zzytest log: " + text);
        textElement.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
