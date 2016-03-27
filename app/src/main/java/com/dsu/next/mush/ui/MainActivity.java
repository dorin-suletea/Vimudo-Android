package com.dsu.next.mush.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.dsu.next.mush.R;

import model.VimudoConstants;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity);

        //was launched upon share from other activities eg youtube?
        Intent intent = getIntent();
        if (intent.getExtras() != null && getIntent().getStringExtra(Intent.EXTRA_TEXT) != null) {
            //yes : pass the link to main fragment and start it
            String url = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            Log.d("!=", "Sending url to main fragment " + url);
            Bundle bundle = new Bundle();
            bundle.putString(VimudoConstants.INTENT_LINK_KEY, url);
            UiHelper.replaceCurrentFragment(this, bundle, new HomeFragment(), true, true);
        } else {
            //no : go via splash
            UiHelper.replaceCurrentFragment(this, new Bundle(), new SplashFragment(), false, false);
        }

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
}
