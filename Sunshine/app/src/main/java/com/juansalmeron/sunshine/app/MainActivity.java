package com.juansalmeron.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ArrayList<String> weekforecast =  new ArrayList<>();
            weekforecast.add("Hoy - Soleado - 28 / 15");
            weekforecast.add("Lunes - Soleado - 28 / 15");
            weekforecast.add("Martes - Soleado - 28 / 15");
            weekforecast.add("Miercoles - Soleado - 28 / 15");
            weekforecast.add("Jueves - Soleado - 28 / 15");
            weekforecast.add("Viernes - Soleado - 28 / 15");
            weekforecast.add("Sabado - Soleado - 28 / 15");
            weekforecast.add("Domingo - Soleado - 28 / 15");

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mForecastAdapter = new ArrayAdapter<String> (getActivity(),R.layout.list_item_forecast,R.id.list_item_forecast_textview,weekforecast);
            ListView list_view = (ListView) rootView.findViewById(R.id.listview_forecast);
            list_view.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
