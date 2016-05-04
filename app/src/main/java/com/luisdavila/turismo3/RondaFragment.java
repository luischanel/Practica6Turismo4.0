package com.luisdavila.turismo3;

import android.*;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 */
public class RondaFragment extends Fragment  {



    public RondaFragment() {
        // Required empty public constructor
    }

    private TextView tView;
    private EditText longi, lati;
    private Button go, actual;
    private double dlongi, dlati;
    private LocationManager locationManager;
    private int y;
    MapView mapView;
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ronda, container, false);
        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapademo);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();

        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Updates the location and zoom of the MapView
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(8.754964, -75.889307)).title("Ronda").snippet("Montería");
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(8.754964, -75.889307), 17);
        map.addMarker(marker);
        map.animateCamera(cameraUpdate);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setMyLocationEnabled(true);

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }




}
