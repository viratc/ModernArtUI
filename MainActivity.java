package com.example.android.mymodernart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends ActionBarActivity {

    public DialogFragment mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view1= (View) findViewById(R.id.view1);
        final View view2= (View) findViewById(R.id.view2);
        final View view3= (View) findViewById(R.id.view3);
        final View view4= (View) findViewById(R.id.view4);
        final View view5= (View) findViewById(R.id.view5);
        final SeekBar seekBar= (SeekBar)findViewById(R.id.seekbar);

        view1.setBackgroundColor(Color.argb(0xFF,0,255,255));
        view2.setBackgroundColor(Color.argb(0xFF,255,0,255));
        view3.setBackgroundColor(Color.argb(0xFF,255,255,0));
        view4.setBackgroundColor(Color.argb(0xFF,0,0,255));
        view5.setBackgroundColor(Color.argb(0xFF,0,255,0));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view1.setBackgroundColor(Color.argb(0xFF, progress, 235, 255));
                view2.setBackgroundColor(Color.argb(0xFF,205,progress,185));
                view3.setBackgroundColor(Color.argb(0xFF,165,145,progress));
                view4.setBackgroundColor(Color.argb(0xFF,progress,progress,125));
                view5.setBackgroundColor(Color.argb(0xFF,progress,105,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
            ShowDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ShowDialog(){

        mDialog= AlertDialogFragment.newInstance();

        mDialog.show(getFragmentManager(),"Alert");

    }

    public static class AlertDialogFragment extends DialogFragment{

        public static AlertDialogFragment newInstance(){
            return new AlertDialogFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstance){
            return new AlertDialog.Builder(getActivity())
                    .setMessage("Inspired by the works of artists such as Piet Mondrain & Ben Nicholson."
                            + "\n" +"Click below to learn more!")
                    .setCancelable(false)
                    .setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Uri uri = Uri.parse("http://www.MOMA.org/");
                            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                            startActivity(intent);

                        }
                    }).create();
        }

    }
}
