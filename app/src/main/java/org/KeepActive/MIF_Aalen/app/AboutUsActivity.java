/**
 * Author: Djimgou Patrick Virgile
 * URL: http://virgiledjimgou.esy.es
 * Github https://github.com/chichikolon
 * */
package org.KeepActive.MIF_Aalen.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.KeepActive.MIF_Aalen.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            // continue to anthor activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
