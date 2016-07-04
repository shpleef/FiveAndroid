package com.boiled.five.ui.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.boiled.five.BoiledApplication;
import com.boiled.five.injection.component.ActivityComponent;
import com.boiled.five.injection.component.ApplicationComponent;
import com.boiled.five.injection.component.DaggerActivityComponent;
import com.boiled.five.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(BoiledApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected ApplicationComponent applicationComponent() {
        return BoiledApplication.get(this).getComponent();
    }

}
