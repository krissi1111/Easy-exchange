package com.axel.New.Money;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Gjaldmidlar extends Activity {
	
	private Button From;
	private Button Button1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.gjaldmidlar);
		
		this.From = (Button) this.findViewById(R.id.From);
		
	}
	

}
