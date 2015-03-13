package com.ymiaohuang.DrawingBoard;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/*
 * 画布
 * 在布局文件中添加一个自定义组件MyView继承surfaceView。
 * 通过Callback接口可以操作surfaceView。
 * MyView中，要定义好paint，path，canvas，并设置好属性。
 * 定义好setOnTouchListener()：设置触摸监听器，监听MoTion手势事件。
 * path.lineTo(event.getX(), event.getY());
 * canvas.drawPath(path, paint);
 * 
 * 
 * */
public class DrawingBoardActivity extends Activity {

    private Button btn;
    private Myview view;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        view = (Myview)findViewById(R.id.draw);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				view.clear();
				
			}
		});
    }
    public boolean OnCreateOptionsMenu(Menu menu){
    	getMenuInflater().inflate(R.menu.main, menu);
    	return true;
    }
}