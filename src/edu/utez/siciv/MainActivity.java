package edu.utez.siciv;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import utilerias.soap.ConexionWS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.utez.siciv.RegistrarseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	EditText txtUsuario;
	EditText txtContrasena;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtUsuario=(EditText) findViewById(R.id.txtUser);
		txtContrasena=(EditText)findViewById(R.id.txtPass);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void registroNuevo(View v){
		Intent act = new Intent(this,RegistrarseActivity.class);
		startActivity(act);
	}
	
	public void iniciarSesion(View vw){
		ConexionWS conexion = new ConexionWS();
		List<String> parametros = new ArrayList<String>();
		String usuario = txtUsuario.getText().toString();
		String contrasena = txtContrasena.getText().toString();
		
        parametros.add("usuario");
        parametros.add("contrasena");
        
        List<String> valores = new ArrayList<String>();
        valores.add(usuario);
        valores.add(contrasena);
        
        Toast.makeText(this,""+conexion.consulta("iniciarSesion", parametros, valores), Toast.LENGTH_LONG).show();
	}
}
