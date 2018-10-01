package com.example.gonzalo.gpsejemplo;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvLatitud,tvLongitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLatitud=findViewById(R.id.tvLatitud);
        tvLongitud=findViewById(R.id.tvLongitud);
    }

    public void obtenerUbicacion(View view){
        //Creo un objeto de la clase GPSTracker,le paso el contexto
        GpsTracker gt = new GpsTracker(this);

        //Llamo al metodo getLocation para obtener la localizacion actual
        Location localizacion = gt.getLocation();
        if( localizacion == null){
            Toast.makeText(getApplicationContext(),"No se pudo obtener ubicacion-Asegurese de tener el GPS activado",Toast.LENGTH_SHORT).show();
        }else {
            double lattitud = localizacion.getLatitude();
            double longitud = localizacion.getLongitude();
            tvLatitud.setText("Latitud: "+lattitud);
            tvLongitud.setText("Longitud: "+longitud);

        }
    }
}
