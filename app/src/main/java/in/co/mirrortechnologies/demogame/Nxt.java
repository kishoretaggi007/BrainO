package in.co.mirrortechnologies.demogame;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.graphics.Color.rgb;
import static java.security.AccessController.getContext;

public class Nxt extends AppCompatActivity{

	TextView tv1,tv2,tv3,tv4,detailstv;
	ImageButton imageButton;
	ImageView iv;

	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_next);
		 /*
		 iv = (ImageView) findViewById(R.id.imageInfo);
		 iv.setImageDrawable(getResources().getDrawable(R.drawable.info));*/

		 tv4= (TextView) findViewById(R.id.textViewD);
		 tv4.setMovementMethod(new ScrollingMovementMethod());
		 tv4.setTextColor(rgb(50,205,50));

		 detailstv= (TextView) findViewById(R.id.detailsText);
		 detailstv.setMovementMethod(new ScrollingMovementMethod());
		 detailstv.setTextColor(rgb(128,0,0));

		 imageButton = (ImageButton) findViewById(R.id.imageBack);
		 imageButton.setOnClickListener(new View.OnClickListener() {
			 @Override
			 public void onClick(View v) {
				 Intent icl = new Intent(Nxt.this, AppOnOpen.class);
				 startActivity(icl);
				 overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
			 }
		 });
	 }
}
