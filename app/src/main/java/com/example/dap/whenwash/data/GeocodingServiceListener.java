package com.example.dap.whenwash.data;

/**
 * Created by DAPer on 20.03.2018.
 */

public interface GeocodingServiceListener {
    void geocodeSuccess(LocationResult location);

    void geocodeFailure(Exception exception);
}