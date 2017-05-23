package com.minicup.actionmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback {

    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActionMode(View view) {
        actionMode = startSupportActionMode(this);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        Toast.makeText(this, "onCreateActionMode", Toast.LENGTH_SHORT).show();
        mode.getMenuInflater().inflate(R.menu.action_mode, menu);
        mode.setTitle("Title");
        mode.setSubtitle("SubTitle");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        Toast.makeText(this, "onPrepareActionMode", Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Toast.makeText(this, "onActionItemClicked", Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){
            case R.id.first:
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
                break;

            case R.id.second:
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        Toast.makeText(this, "onDestroyActionMode", Toast.LENGTH_SHORT).show();
        actionMode = null;
    }

    public void destroyActionMode(View view) {
        if(actionMode!=null){
            actionMode.finish();
        }
    }
}
