package com.ymiaohuang.DrawingBoard;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/*
 * ����
 * �ڲ����ļ������һ���Զ������MyView�̳�surfaceView��
 * ͨ��Callback�ӿڿ��Բ���surfaceView��
 * MyView�У�Ҫ�����paint��path��canvas�������ú����ԡ�
 * �����setOnTouchListener()�����ô���������������MoTion�����¼���
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