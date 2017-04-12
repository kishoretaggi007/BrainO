package in.co.mirrortechnologies.demogame;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Launching extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoview);

        //specify the location of media file
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/raw/video1");

        //Setting MediaController and URI, then starting the videoView
        videoview.setMediaController(mediaController);
        videoview.setVideoURI(uri);
        videoview.requestFocus();
        videoview.start();

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(Launching.this, AppOnOpen.class));
                Launching.this.finish();
            }
        }, 3000);
    }
}
