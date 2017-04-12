package in.co.mirrortechnologies.demogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;
import static in.co.mirrortechnologies.demogame.PuzzleView1.num;

public class MainActivity extends AppCompatActivity implements OnClickListener {

	private PuzzleView1 customCanvas;
	MyCountDownTimer myCountDownTimer;
	ProgressBar b;
	TextView tv, tv2;
	int matrixSize;
	int test1, test2, stage;
	ImageView iv;
	Button b1, b2, b3;
	private SQLiteDatabase db;
	Cursor c, c1;
	AlertDialog ald;
	LinearLayout layout;
	EditText et1, et2;
	String n1, s1;
	private static final String SELECT_SQL = "SELECT * FROM leader order by score desc";
	ImageView onelock, twolock, threelock, fourlock, fivelock, sixlock, sevenlock, eightlock, ninelock, tenlock;
	ImageView imageOne, imageTwo, imageThree, imageFour, imageFive, imageSix, imageSeven, imageEight, imageNine, imageTen;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createDatabase();
		createnewDatabase();
		customCanvas = (PuzzleView1) findViewById(R.id.signature_canvas);
		b = (ProgressBar) findViewById(R.id.progressBar2);
		tv = (TextView) findViewById(R.id.textView1);
		tv.setTextColor(rgb(255, 255, 255));
		/*final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id
				.coordinatorLayout);*/
		iv = (ImageView) findViewById(R.id.timerImage);
		iv.setImageDrawable(getResources().getDrawable(R.drawable.timer));
		c = db.rawQuery(SELECT_SQL, null);
		c.moveToFirst();
		onelock = (ImageView) findViewById(R.id.onelock);
		twolock = (ImageView) findViewById(R.id.twolock);
		threelock = (ImageView) findViewById(R.id.threelock);
		imageOne = (ImageView) findViewById(R.id.oneImage);
		imageTwo = (ImageView) findViewById(R.id.twoImage);
		imageThree = (ImageView) findViewById(R.id.threeImage);

		matrixSize = num;
		myCountDownTimer = new MyCountDownTimer(20000, 1);
		myCountDownTimer.start();

	}

	public class MyCountDownTimer extends CountDownTimer {
		MyCountDownTimer2 myCountDownTimer2;
		int lalaCount = 0;
		int ColourChangeTime = 0;

		public MyCountDownTimer(long millisInFuture, long countDownInterval) {

			super(millisInFuture, countDownInterval);
			int m = (int) (millisInFuture / 1000);
			myCountDownTimer2 = new MyCountDownTimer2(20000, 1);
			myCountDownTimer2.start();

		}

		public int getRandm() {
			int randtime = 0;
			Random r = new Random();
			randtime = r.nextInt(5) + 1;
			return randtime;
		}

		@Override
		public void onTick(long millisUntilFinished) {
			int progress = (int) millisUntilFinished;

			if (customCanvas.numRects == customCanvas.count) {
				matrixSize++;
				customCanvas.clear(matrixSize);
				customCanvas.invalidate();
				myCountDownTimer2 = new MyCountDownTimer2(50000, 1);
				myCountDownTimer2.start();
			}

			int y = progress / 1000;
			tv.setText(Integer.toString(y));
			b.setProgress(progress / 500);


		}

		@Override
		public void onFinish() {

			MediaPlayer mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.music);
			if (mediaplayer == null) {
				Log.v("TAG", "Create() on MediaPlayer failed.");
			} else {
				mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

					@Override
					public void onCompletion(MediaPlayer mediaplayer) {
						mediaplayer.stop();
						mediaplayer.release();
					}
				});
				mediaplayer.start();

			}
			if (!isFinishing()) {
				alert();
			}
				/*final Dialog d1 = new Dialog(MainActivity.this);
				d1.setContentView(R.layout.cust);
				d1.setTitle("Your Score is "+(customCanvas.scoreCount)*10);

				Button b2 = (Button) d1.findViewById(R.id.button2);
				Button b3 = (Button) d1.findViewById(R.id.button3);
				b2.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Intent i=new Intent(MainActivity.this,Nxt.class);
						MainActivity.this.finish();
					}
				});
				b3.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						d1.cancel();
					}
				});
                //d1.show();
				if(!isFinishing()) {
					d1.show();
				}*/
			//stageChange(PuzzleView1.num);
		}
	}


	public class MyCountDownTimer2 extends CountDownTimer {
		Random r;
		int lost = 0;
		int random;
		int lalaCount = 0;
		int ColourChangeTime = 0;

		public MyCountDownTimer2(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			int m = (int) (millisInFuture / 1000);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			int progress1 = (int) millisUntilFinished / 1000;
			if (lalaCount == 0 || lalaCount == 2) {
				ColourChangeTime = progress1 - 4;
				lalaCount++;
			}
			if (progress1 == ColourChangeTime) {
				switch (lalaCount) {
					case 1:
						customCanvas.clearColor(2);
						customCanvas.invalidate();
						lalaCount++;
						break;
					case 3:
						customCanvas.clearColor(1);
						customCanvas.invalidate();
						lalaCount = 0;
						break;
				}
			}


			if (customCanvas.gameOver == true) {
				if (lost == 0) {
					MediaPlayer mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.music);
					if (mediaplayer == null) {
						Log.v("TAG", "Create() on MediaPlayer failed.");
					} else {
						mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

							@Override
							public void onCompletion(MediaPlayer mediaplayer) {
								mediaplayer.stop();
								mediaplayer.release();
							}
						});
						mediaplayer.start();

					}
					if (!isFinishing()) {
						alert();
					}

							/*final Dialog d1 = new Dialog(MainActivity.this);
							d1.setContentView(R.layout.cust);
							d1.setTitle("Your Score is "+(customCanvas.scoreCount)*10);

							Button b2 = (Button) d1.findViewById(R.id.button2);
							Button b3 = (Button) d1.findViewById(R.id.button3);
							b2.setOnClickListener(new OnClickListener() {
								public void onClick(View v) {
                                    Intent i=new Intent(MainActivity.this,Nxt.class);
									MainActivity.this.finish();
								}
							});
							b3.setOnClickListener(new OnClickListener() {
								public void onClick(View v) {
									d1.cancel();
								}
							});
                            //d1.show();
							if(!isFinishing()) {
								d1.show();
							}*/
					//stage= PuzzleView1.num;
					//stageChange(PuzzleView1.num);
					lost++;
					return;
				}
			}

		}


		@Override
		public void onFinish() {
		}

	}

	public int[] getRandom(int counter) {
		int l = counter * counter;
		int rand[] = new int[l];
		List<Integer> x = new ArrayList<Integer>();
		Random r = new Random();
		for (int y = 0; y < l; y++) {
			int g = r.nextInt(l) + 1;
			if (x.contains(g)) {
				y--;
				continue;
			}
			rand[y] = g;
			x.add(g);
		}
		return rand;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	/*public void stageChange(int stage){
        if(stage==2){
            onelock.setVisibility(View.INVISIBLE);
            imageOne.setVisibility(View.VISIBLE);
        }
        if(stage==3){
            onelock.setVisibility(View.INVISIBLE);
            imageOne.setVisibility(View.VISIBLE);
        }
        if(stage==4){
            onelock.setVisibility(View.INVISIBLE);
            imageOne.setVisibility(View.VISIBLE);
        }
    }*/
	protected void createDatabase() {
		db = openOrCreateDatabase("ScoreList", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS leader(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name varchar ,score INTEGER);");
	}

	protected void createnewDatabase() {
		db = openOrCreateDatabase("ScoreList", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS sample(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name text ,score INTEGER);");
	}

	protected void insertIntoDB() {
		String id = "";
		c.moveToFirst();
		n1 = et1.getText().toString().trim();
		s1 = et2.getText().toString().trim();
		if (n1.equals(" ") || n1.equals("")) {
			/*Snackbar snackbar = Snackbar
					.make(findViewById(R.id.coordinatorLayout), "You Must Enter Your Name!!!", Snackbar.LENGTH_LONG);
			View snackbarView = snackbar.getView();
			snackbarView.setBackgroundColor(rgb(255,215,0));
			TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
			textView.setTextColor(Color.GREEN);
			snackbar.show();*/
			Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();
			ald.show();
		}

	/*	if (!c.isLast()) {
			while (!c.isAfterLast()) {
				id=c.getString(0);
				String abc=c.getString(1);
				boolean equal=abc.equals(n1);
				if(equal==true)
				{    Toast.makeText(this, ""+equal, Toast.LENGTH_SHORT).show();
					counter=counter+1;
					Toast.makeText(this, "Already Exist So The content will be modified", Toast.LENGTH_SHORT).show();
					String q2="UPDATE leader SET score="+s1+" WHERE id="+id+";";
					db.execSQL(q2);
					Toast.makeText(this, "UPDATED", Toast.LENGTH_SHORT).show();
					c = db.rawQuery(SELECT_SQL, null);
					showPeople();
					return;
				}
				else
				{

				}
				c.moveToNext();


			}

		}*/
		else {
			String query1 = "INSERT INTO sample (name,score) VALUES('" + n1 + "', '" + s1 + "');";
			db.execSQL(query1);
		}
	}

	public void alert() {
		/*final Dialog d1 = new Dialog(MainActivity.this);
		d1.setContentView(R.layout.cust);
		d1.setTitle("Your Score is " + (customCanvas.scoreCount) * 10);

		Button b1 = (Button) d1.findViewById(R.id.cancelButton);
		Button b2 = (Button) d1.findViewById(R.id.retryButton);
		Button b3 = (Button) d1.findViewById(R.id.tickButton);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, AppOnOpen.class);
				startActivity(i);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, TabSlideActivity.class);
				startActivity(i);
			}
		});
		b3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int a = Integer.parseInt(et2.getText().toString());
				String same = "SELECT * FROM sample WHERE (score= " + a + " AND name = '" + et1.getText().toString() + "');";
				c1 = db.rawQuery(same, null);
				if (c1.getCount() == 1) {
					Intent i1 = new Intent(MainActivity.this, Overall.class);
					startActivity(i1);
				} else {
					insertIntoDB();
					Intent i1 = new Intent(MainActivity.this, Overall.class);
					startActivity(i1);
				}
			}
		});*/
		//ald = dilog.create();

		final AlertDialog.Builder dilog=new AlertDialog.Builder(MainActivity.this);
		dilog.setTitle("Braino");
		dilog.setMessage("Your Score is"+(customCanvas.scoreCount)*10);
		layout = new LinearLayout(this);
		LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setLayoutParams(parms);
		layout.setGravity(Gravity.CLIP_VERTICAL);
		layout.setPadding(2, 2, 2, 2);
		tv2 = new TextView(this);
		tv2.setText("Name");
		tv2.setPadding(40, 40, 40, 40);
		tv2.setGravity(Gravity.LEFT);
		tv2.setTextSize(20);
		layout.addView(tv2);
		et1 = new EditText(this);
		et1.setPadding(40, 40,0,0);
		et1.setGravity(Gravity.CENTER);
		et1.setTextSize(50);
		layout.addView(et1);
		et2 = new EditText(this);
		et2.setText("" + (customCanvas.scoreCount) * 10);
		dilog.setView(layout);
		dilog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent i1= new Intent(MainActivity.this,AppOnOpen.class);
				startActivity(i1);
			}
		});
		dilog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				int a=Integer.parseInt(et2.getText().toString());
				String same="SELECT * FROM sample WHERE (score= " + a + " AND name = '"+et1.getText().toString() +"');";
				c1=db.rawQuery(same,null);
				if (c1.getCount() == 1)
				{
					Intent i1 = new Intent(MainActivity.this, Overall.class);
					startActivity(i1);
				}
				else {
					insertIntoDB();
					Intent i1 = new Intent(MainActivity.this, Overall.class);
					startActivity(i1);
				}
			}
		});
		ald =dilog.create();
		ald.show();
		ald.setCancelable(false);

	}
}
