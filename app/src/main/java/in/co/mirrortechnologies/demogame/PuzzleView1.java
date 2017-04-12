package in.co.mirrortechnologies.demogame;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PuzzleView1 extends View{
	int colorNum=0;
	private static final String VIEW_STATE = "viewState";
	int colours[]={Color.GREEN,Color.RED};	
	int selX;
	int selY;
	Canvas z;
	Rect rectangle,rect1;
	Paint paint;
	private float width; // width of one tile
	private float height; // height of one tile
	int x;
	int y;
	static int num=2;
	int scoreCount=0;
	private final Rect selRect = new Rect();
	 Rect selRect1 = new Rect();
	int gap,counter=0;
	MainActivity game;
	int x1,y1;
	int numRects=4;
	int params[];
	Rect selRects[];
	int rowNum[];
	int colNum[];
	int given[][];
	int count=0;
	int posx=5;
	int posy=20;
	MainActivity mA;
	int randm[];
	int previous=0;
	int value;
	List<Integer> selected;
	List<Integer> remaining;
	Boolean gameOver=false;
	public PuzzleView1(Context c, AttributeSet attrs) {
		super(c,attrs);
		float z;
		setFocusable(true);
		setFocusableInTouchMode(true);
		int sideLength=200;
		width=Resources.getSystem().getDisplayMetrics().widthPixels;
		height=Resources.getSystem().getDisplayMetrics().heightPixels;
		x=0;
		y=(int) (height-width)/3;
		rectangle=new Rect(x,y,(int)(width+x),(int)(width+y));
		paint=new Paint();
		mA=new MainActivity();
		given=new int[10][10];
			
	}
	
	
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		
		
		getRect(selX, selY, selRect);
		//Log.d(TAG, "onSizeChanged: width " + width + ", height " + height);
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	private void getRect(int a, int b, Rect rect) {
		//rect.set((int) (a * gap)+25+1, (int) (b * gap+y)+25+1,(int) (a * gap + gap)+25, (int) (b * gap + gap+y)+25);
		
		for(int g=0;g<count;g++){
			selRects[g].set((int) (rowNum[g] * gap)+25+1, (int) (colNum[g] * gap+y)+25+1,(int) (rowNum[g] * gap + gap)+25, (int) (colNum[g] * gap + gap+y)+25);
		}
	}
	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() != MotionEvent.ACTION_DOWN)
			return super.onTouchEvent(event); 
	
		if(event.getY()>y){
		select((int) (event.getX() / gap), (int) (event.getY()-y) / gap);
		posx=(int) event.getX();
		posy=(int) event.getY();
		
		}
		invalidate();
		return true;
	}

	
	private void select(int x1, int y1) {
		
		 selX = Math.min(Math.max(x1, 0), (num-1));
		 selY = Math.min(Math.max(y1, 0), (num-1));
		if(count<numRects){
			int decide=decide(given[selX][selY]);
		if(selected.size()==0){
			if(decide==1){
				selected.add(given[selX][selY]);
				rowNum[count]=selX;
				colNum[count]=selY;
				count++;
				scoreCount++;
				getRect(selX, selY, selRect);
				invalidate(selRect);
			}
			else if(decide==3){}
			else{
				//gameOver=true;
			}
			}
		else{
			if(decide==1){
				selected.add(given[selX][selY]);
				rowNum[count]=selX;
				colNum[count]=selY;
				count++;
				scoreCount++;
				getRect(selX, selY, selRect);
				invalidate(selRect);
			}
			else if(decide==3){}
			else{
				gameOver=true;
			}
		}
		}
	}
	
	private int decide(int i) {
		if(selected.contains(i))
			return 3;
		switch(colorNum){
		case 0:if(remaining.size()!=0){
				for(int x7:remaining){
					if(x7<i){return 2;}	
				}
					for(int huh=0;huh<remaining.size();huh++){
						if(remaining.get(huh).equals(i))
							remaining.remove(huh);
					}
				}return 1;
		
		case 1:if(remaining.size()!=0){
				for(int x7:remaining){
					if(x7>i){return 2;}	
				}
				for(int huh=0;huh<remaining.size();huh++){
					if(remaining.get(huh).equals(i))
						remaining.remove(huh);
				}
				}return 1;
		}
		return 2;
	}


	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.rgb(240,240,255));
		//outline
		if(counter==0){
		numRects=num*num;
		selRects=new Rect[numRects];
		rowNum=new int[numRects];
		colNum=new int[numRects];
		for(int l=0;l<numRects;l++){
			selRects[l]=new Rect();
		}
		selected=new ArrayList<Integer>();
		remaining=new ArrayList<Integer>();
		int lala1=0;
		randm=mA.getRandom(num);
		for (int i = 0; i < num; i++) {
			for (int j = 0; j <num; j++) {
				given[i][j]=randm[lala1];
				remaining.add(given[i][j]);
				lala1++;
			}
		}
		counter++;
		}
			paint.setColor(colours[colorNum]);
		Paint dark = new Paint();
		dark.setStrokeWidth(25);
		Paint dark1 = new Paint();
		dark1.setStrokeWidth(50);
		dark.setColor(getResources().getColor(R.color.light_yellow));
		dark1.setColor(getResources().getColor(R.color.light_yellow));
		canvas.drawRect(rectangle, paint);
		canvas.drawLine(0, y,width,y,dark);
		canvas.drawLine(0, y,0,y+width,dark1);
		canvas.drawLine(width, y,width,y+width,dark1);
		canvas.drawLine(0, y+width,width,y+width,dark);
		//matrix generation
		gap=(int)(width-50)/num;
		Paint dark2 = new Paint();
		dark2.setColor(getResources().getColor(R.color.light_yellow));
		for(int k=1;k<num;k++){
			canvas.drawLine(25+(k*gap),y,25+(k*gap),12+y+width,dark2);
			canvas.drawLine(25,25+(k*gap)+y,25+(k*gap)+width-50,25+(k*gap)+y,dark2);
		}
		
		Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
		foreground.setColor(getResources().getColor(R.color.puzzle_foreground));
		foreground.setStyle(Style.FILL);
		foreground.setTextSize(gap * 0.65f);
		foreground.setTextScaleX(1);
		foreground.setTextAlign(Paint.Align.CENTER);
		float y= (height-width)/3;
		
		
		int lala=0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j <num; j++) {
			canvas.drawText(Integer.toString(randm[lala]), gap*0.55f + i*gap+(num*10/4), y+(j*gap)+(gap*0.8f)+(num*10/4), foreground);
			lala++;
			}
		}
		
		
		z=canvas;
		// Draw the selection...
				Paint selected = new Paint();
					selected.setColor(colours[colorNum]);
				canvas.drawRect(selRect, selected);
				canvas.drawRect(selRect1, selected);
				for(int l=0;l<numRects;l++){
					canvas.drawRect(selRects[l], selected);
				}
		
				super.onDraw(canvas);
		value=num;
	}

	public void clear(int dot){
		switch(dot){
		case 3:num=3;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 4:num=4;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 5:num=5;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 6:num=6;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 7:num=7;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 8:num=8;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 9:num=9;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		case 10:num=10;for(int f=0;f<count;f++){selRects[f].setEmpty();}counter=0;count=0;colorNum=0;break;
		}
	}
	
	public void clearColor(int dot){
		switch(dot){
		case 1:colorNum=0;break;
		case 2:colorNum=1;break;
		}
	}
	
	@Override
	protected void onRestoreInstanceState(Parcelable state) {
		//Log.d(TAG, "onRestoreInstanceState");
		Bundle bundle = (Bundle) state;
		select(bundle.getInt("selX"), bundle.getInt("selY"));
		super.onRestoreInstanceState(bundle.getParcelable(VIEW_STATE));
	}

	@Override
	protected Parcelable onSaveInstanceState() {
		Parcelable p = super.onSaveInstanceState();
		//Log.d(TAG, "onSaveInstanceState");
		Bundle bundle = new Bundle();
		bundle.putInt("selX", selX);
		bundle.putInt("selY", selY);
		bundle.putParcelable(VIEW_STATE, p);
		return bundle;
	}
	
}
