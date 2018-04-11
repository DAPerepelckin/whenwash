package com.example.dap.whenwash;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dap.whenwash.data.Condition;
import com.example.dap.whenwash.data.Units;

/**
 * Created by DAPer on 20.03.2018.
 */

public class WeatherConditionFragment extends Fragment {
    private ImageView weatherIconImageView;
    private TextView dayLabelTextView;
    private TextView highTemperatureTextView;
    private TextView lowTemperatureTextView;

    public WeatherConditionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_condition, container, false);

        weatherIconImageView = (ImageView) view.findViewById(R.id.weatherIconImageView);
        dayLabelTextView = (TextView) view.findViewById(R.id.dayTextView);
        highTemperatureTextView = (TextView) view.findViewById(R.id.highTemperatureTextView);
        lowTemperatureTextView = (TextView) view.findViewById(R.id.lowTemperatureTextView);

        return view;
    }

    public void loadForecast(Condition forecast, Units units) {

        int weatherIconImageResource = getResources().getIdentifier("icon_ "+forecast.getCode(), "drawable", getActivity().getPackageName());

        weatherIconImageView.setImageResource(weatherIconImageResource);
        String day =forecast.getDay().toString();

        if (day.equalsIgnoreCase("Wed".toString())){day=getString(R.string.WensdayShort).toString();}
        if (day.equalsIgnoreCase("Thu".toString())){day=getString(R.string.ThursdayShort).toString();}
        if (day.equalsIgnoreCase("Fri".toString())){day=getString(R.string.FridayShort).toString();}
        if (day.equalsIgnoreCase("Sat".toString())){day=getString(R.string.SaturdayShort).toString();}
        if (day.equalsIgnoreCase("Sun".toString())){day=getString(R.string.SundayShort).toString();}
        if (day.equalsIgnoreCase("Mon".toString())){day=getString(R.string.MondayShort).toString();}
        if (day.equalsIgnoreCase("Tue".toString())){day=getString(R.string.TuesdayShort).toString();}
        dayLabelTextView.setText(day);
        highTemperatureTextView.setText(getString(R.string.temperature_output, forecast.getHighTemperature(), units.getTemperature()));
        lowTemperatureTextView.setText(getString(R.string.temperature_output, forecast.getLowTemperature(), units.getTemperature()));


    }
}