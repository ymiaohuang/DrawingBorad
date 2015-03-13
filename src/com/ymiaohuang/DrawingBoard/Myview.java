package com.ymiaohuang.DrawingBoard;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

/*
 * 继承surfaceView,实现surfaceholder包下的callback接口（回调函数）
 * */
public class Myview extends SurfaceView implements Callback,OnTouchListener {

	private Paint paint = new Paint();
	private Path path = new Path();
	
	public Myview(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);//获取回调函数
		paint.setColor(Color.BLUE);
		paint.setTextSize(30);
		paint.setStyle(Style.STROKE);//空心
		paint.setAntiAlias(true);
		setOnTouchListener(this);
	}
	public void draw(){
		Canvas canvas = getHolder().lockCanvas();//锁定画布，返回同一个画布。
		canvas.drawColor(Color.WHITE);
		canvas.drawPath(path, paint);
		getHolder().unlockCanvasAndPost(canvas);
	}
	public void clear(){
		path.reset();//重置画布。
		draw();
	}
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	public void surfaceCreated(SurfaceHolder holder) {
		draw();

	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}
	public boolean onTouch(View v, MotionEvent event) {
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(),event.getY());
			draw();
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(event.getX(), event.getY());
			draw();
			break;
		}
		return true;
	}

}
