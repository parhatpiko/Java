package com.example.ht.nsdnetworkservicediscovery_practice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


/*  Android's wireless APIs also enable communication with other devices on the same
 local network, and even devices which are not on a network, but are physically nearby.
 The addition of Network Service Discovery (NSD) takes this further by allowing an
 application to seek out a nearby device running services with which it can communicate.
 Integrating this functionality into your application helps you provide a wide range of
 features, such as playing games with users in the same room, pulling images from a
 networked NSD-enabled webcam, or remotely logging into other machines on the same network. */




public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}