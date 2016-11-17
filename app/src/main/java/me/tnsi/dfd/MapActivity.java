package me.tnsi.dfd;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, OnMarkerClickListener {

    private GoogleMap mMap;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    public static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);



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
        mMap.setOnMarkerClickListener(this);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_FINE_LOCATION);
        }

        // Add a marker in Sydney and move the camera
        LatLng uxRoom = new LatLng(42.966821, -85.887142);
        LatLng macPod = new LatLng(42.966683, -85.887133);
        LatLng manMango = new LatLng(42.966564, -85.887375);
        mMap.addMarker(new MarkerOptions().position(macPod).title("Provisions on Demand").draggable(false));
        mMap.addMarker(new MarkerOptions().position(manMango).title("Mandrake's Mangos").draggable(false));
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uxRoom));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_FINE_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        String name = marker.getTitle();
        if (name.equalsIgnoreCase("Provisions on Demand")) {
            Toast.makeText(this, "You're really demanding of those provisions.", Toast.LENGTH_SHORT).show();
            return true;
        } else if(name.equalsIgnoreCase("Mandrake's Mangos")) {
            Toast.makeText(this, "Mandrake has the best mangos.", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
}
