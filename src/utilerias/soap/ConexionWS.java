package utilerias.soap;

import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.annotation.SuppressLint;
import android.os.StrictMode;

@SuppressLint("NewApi")
public class ConexionWS {

	private static final String URL = "http://192.168.1.78:8080/SICIV/Service?WSDL";
    private static final String NAMESPACE = "http://SERVICE/";
    private static final String SOAP_ACTION = "Service";

    @SuppressLint("NewApi")
	public String consulta(String METHOD_NAME, List<String> parametros, List<String> valores) {
        String respuesta = "";
        try {
        	
        	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        	StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        	
            SoapObject solicitud = new SoapObject(NAMESPACE, METHOD_NAME);

            for (int i = 0; i <= parametros.size() - 1; i++) {
                solicitud.addProperty(parametros.get(i), valores.get(i));
            }
            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.bodyOut = solicitud;

            HttpTransportSE transporte = new HttpTransportSE(URL);
            transporte.debug = true;
            transporte.call(SOAP_ACTION, sobre);

            respuesta = sobre.getResponse().toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }
}
