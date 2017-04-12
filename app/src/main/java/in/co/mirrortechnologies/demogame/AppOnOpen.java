package in.co.mirrortechnologies.demogame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class AppOnOpen extends AppCompatActivity {

	ImageView play,exit,instr;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onopen);
		View v = findViewById(R.id.relLayout);

		play = (ImageView) findViewById(R.id.imagePlay);
		exit = (ImageView) findViewById(R.id.imageExit);
		instr = (ImageView) findViewById(R.id.imageInstr);

		instr.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent icl = new Intent(AppOnOpen.this, Nxt.class);
				startActivity(icl);
				overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
			}

		});
		play.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent icl = new Intent(AppOnOpen.this, TabSlideActivity.class);
				startActivity(icl);
				overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
			}

		});
		exit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				moveTaskToBack(true);
				AppOnOpen.this.finish();
			}

		});
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}
}
