package com.yu.nested.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.yu.lib.common.ui.HostActivity;

/**
 * @author wupuquan
 * @since 2021/3/11
 */
public class Utils {

    public static float dp2px(Context context, Float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }

    public static void showToast(Context context, String info) {
        Toast.makeText(
                context,
                info,
                Toast.LENGTH_SHORT
        ).show();
    }

    public static void showToast(Context context, String info, int duration) {
        Toast toast = Toast.makeText(
                context,
                info,
                Toast.LENGTH_LONG
        );
        toast.setDuration(duration);
        toast.show();
    }

    public static void startFragment(Context context, Class<? extends Fragment> fragmentClass, Bundle bundle) {
        Intent intent = new Intent(context, HostActivity.class);
        if (bundle != null) {
            intent.putExtra("params", bundle);
        }
        intent.putExtra("fragment_class_name", fragmentClass.getName());
        context.startActivity(intent);
    }
}
