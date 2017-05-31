package academia.com.br.academia;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<PracaParque> parqueList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //teste
        mMap = mapFragment.getMap();
        mapFragment.getMapAsync(this);
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //  Move a camera para recife
       // LatLng recife = new LatLng(-8.0969073, -35.0955176);
        LatLng recife = new LatLng(-8.0668435,-34.9128344);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recife, 12));

        PracaParqueHttp http = new PracaParqueHttp(new PracaParqueHttp.OnPracaListener() {
            @Override
            public void onPracaListener(List<PracaParque> parques) {

                if (parques != null && parques.size() > 0) {
                    parqueList = parques;

                    for (PracaParque parque : parques) {
                        mMap.addMarker(new MarkerOptions()
                                .position( new LatLng(Double.parseDouble(parque.getLatitude()),
                                 Double.parseDouble(parque.getLongitude())))
                                .title(parque.getNomeOficial()));
                    }
                }
            }
        });
        http.execute();

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                PracaParque parque = null;

                if (parqueList != null && parqueList.size() > 0) {
                    for (PracaParque p : parqueList) {
                        if (marker.getTitle().equals(p.getNomeOficial())) {
                            parque = p;
                            break;
                        }
                    }
                }

                if (parque != null) {
                    StringBuilder msg = new StringBuilder();
                    msg.append(parque.getEndereco()).append(", ").append(parque.getNomeBairro())
                            .append(", Recife - PE").append("\n");
                    msg.append(parque.getArea()).append("\n");
                    msg.append(parque.getTipo());


                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(MapsActivity.this)
                                    .setTitle(parque.getNomeOficial())
                                    .setMessage(msg.toString())
                                    .setCancelable(false)
                                    .setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                    return true;
                }

                return false;
            }
        });
    }
}