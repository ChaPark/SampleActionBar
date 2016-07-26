package com.chapark.sampleactionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class OtherActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        if(savedInstanceState ==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ContentFragment.newInstance("content : "+ count))
                    .commit();
            count++;
        }
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("param1", "param1");
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showNext(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ContentFragment.newInstance("Content: " + count))
                .addToBackStack(null)
                .commit();
        count++;
    }
}
