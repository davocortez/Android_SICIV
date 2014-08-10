package edu.utez.siciv;

import edu.utez.siciv.RegistrarseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class RegistrarseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registrarse);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registrarse, menu);
		return true;
	}
	public void login(View v){
		Intent act = new Intent(this,MainActivity.class);
		startActivity(act);
		
		
	}

}
