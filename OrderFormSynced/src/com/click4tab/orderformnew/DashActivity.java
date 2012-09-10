package com.click4tab.orderformnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DashActivity extends Activity implements OnClickListener {
	Button continueButton, syncButton, logoutButton;
	TextView welcomeText;
	MainActivity mainObj;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.welcome);
		initElements();

		TestAdapter mDbHelper = new TestAdapter(this);
		mDbHelper.createDatabase();
		mDbHelper.open();

		String nameOfSalesman = mDbHelper
				.getNameOfSalesman(Login.salesManPermanent);
		welcomeText.setText("Welcome " + nameOfSalesman + "!");

		mDbHelper.close();
	}

	private void initElements() {
		// TODO Auto-generated method stub
		continueButton = (Button) findViewById(R.id.button4);
		continueButton.setOnClickListener(this);
		welcomeText = (TextView) findViewById(R.id.textView1);
		syncButton = (Button) findViewById(R.id.button1);
		syncButton.setOnClickListener(this);
		mainObj = new MainActivity();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == continueButton) {
			// start MainActivity

			Intent intent = new Intent("mainActivity");
			startActivity(intent);
		}
		if (v == syncButton) {
			// read/write online data
			mainObj.performReadOperation();
			mainObj.performWriteOperation();

		}
	}

}
