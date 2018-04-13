package rue25.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.dap.whenwash.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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
        mMap = googleMap;
        LatLng [] mok = new LatLng[19];
        mok[0]= new LatLng(51.6913529, 39.208550100000025);
        mok[1]= new LatLng(51.676182, 39.17086399999994);
        mok[2]= new LatLng(51.6954597, 39.129628000000025);
        mok[3]= new LatLng(51.6678024, 39.17323929999998);
        mok[4]= new LatLng(51.6830772, 39.16643620000002);
        mok[5]= new LatLng(51.7181043, 39.149277299999994);
        mok[6]= new LatLng(51.7106588, 39.1598467);
        mok[7]= new LatLng(51.7096875, 39.18145119999997);
        mok[8]= new LatLng(55.74363289999999, 52.42517470000007);
        mok[9]= new LatLng(51.6421909, 39.29484070000001);
        mok[10]= new LatLng(51.6387981, 39.163099999999986);
        mok[11]= new LatLng(51.7265496, 39.21328510000001);
        mok[12]= new LatLng(51.68033819999999, 39.17666370000006);
        mok[13]= new LatLng(51.6934225, 39.13540510000007);
        mok[14]= new LatLng(55.74363289999999, 52.42517470000007);
        mok[15]= new LatLng(51.7116774, 39.14053530000001);
        mok[16]= new LatLng(51.66791720000001, 39.197081300000036);
        mok[17]= new LatLng(51.661997, 39.28403300000002);
        mok[18]= new LatLng(51.701746, 39.134803499999975);

        for (int i=0;i<19;i++){
            mMap.addMarker(new MarkerOptions().position(mok[i]).title(""));
        }


        LatLng sydney = new LatLng(51.6786, 39.20865);
        mMap.setMinZoomPreference(10);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,11));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
