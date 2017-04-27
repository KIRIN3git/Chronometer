package com.example.shinji.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

	long time = 0;
	Chronometer chrono;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// クロノメーター設定
		chrono = (Chronometer)findViewById(R.id.chronometer);


		// テキスト表示
		textView = (TextView) findViewById(R.id.textView);
		textView.setText("time " + String.valueOf(time) + "秒");

		// スタートボタン
		StartButton();
		// ストップボタン
		StopButton();
	}

	private void StartButton(){
		Button start_btn = (Button)findViewById(R.id.startButton);
		start_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chrono.setBase(SystemClock.elapsedRealtime()); //リセット
				chrono.start();
			}
		});
	}
	private void StopButton(){
		Button stop_btn = (Button) findViewById(R.id.stopButton);
		stop_btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Chronometer chrono = (Chronometer) findViewById(R.id.chronometer);
				chrono.stop();
				//システム時間からタイマー起動時間の差分(1/1000秒)
				time = SystemClock.elapsedRealtime() - chrono.getBase();
				textView.setText("time " + String.valueOf(time/1000) + "秒");
			}
		});
	}

}
