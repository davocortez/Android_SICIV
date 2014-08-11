package edu.utez.siciv;

import java.util.ArrayList;
import java.util.List;

import utilerias.soap.ConexionWS;
import edu.utez.siciv.RegistrarseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity extends Activity {
	
	EditText txtUsuario;
	EditText txtContrasena;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registrarse);
		txtUsuario=(EditText) findViewById(R.id.txtUsuario);
		txtContrasena=(EditText)findViewById(R.id.txtContrasena);
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
	
	public void registrar(View v){
		ConexionWS conexion = new ConexionWS();
		List<String> parametros = new ArrayList<String>();
		String usuario = txtUsuario.getText().toString();
		String contrasena = txtContrasena.getText().toString();
		String idTipoUsuario = "2";
		
        parametros.add("usuario");
        parametros.add("contrasena");
        parametros.add("idTipoUsuario");
        
        
        List<String> valores = new ArrayList<String>();
        valores.add(usuario);
        valores.add(contrasena);
        valores.add(idTipoUsuario);
        
        Toast.makeText(this,""+conexion.consulta("agregarUsuario", parametros, valores), Toast.LENGTH_LONG).show();
	}
}
