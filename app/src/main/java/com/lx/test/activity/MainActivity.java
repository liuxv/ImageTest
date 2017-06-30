package com.lx.test.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lx.test.common.activity.BaseActivity;
import com.lx.test.common.fragment.BaseFragment;
import com.lx.test.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = (BaseFragment) Fragment.instantiate(this, MainFragment.class.getName(), null);
        replaceFragment(fragment);
    }
}
