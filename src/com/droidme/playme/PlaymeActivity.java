package com.droidme.playme;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class PlaymeActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "AudioDemo";
	public Button pbutton;
	public MediaPlayer player;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG, "main activity created");
        
        player = MediaPlayer.create(this, R.raw.button_9);
        player.setLooping(false);

        pbutton = (Button) this.findViewById(R.id.button1);
        pbutton.setOnClickListener(this);
        
        //begin play
        demoPlay();
        
        //release instance to system
         player.release();
        
    }

	@Override
	protected void onPause() {
		player.pause();
	}

	@Override
	public void onClick(View v) {
		Log.d(TAG, "got a click" + v);
		if(v.getId() == R.id.button1)
			pausePlay();
	}
	
	public void demoPlay(){
		Log.d(TAG, "play");
		player.start();
	}
	
	public void pausePlay(){
		if(player.isPlaying()){
			demoPause();
		} else {
			demoPlay();
		}
	}
	
	public void demoPause(){
		Log.d(TAG,"PAUSE");
		player.pause();
	}
    
    
}