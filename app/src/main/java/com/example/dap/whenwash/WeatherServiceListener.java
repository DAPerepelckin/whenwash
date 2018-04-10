package com.example.dap.whenwash;

import com.example.dap.whenwash.data.Channel;

/**
 * Created by DAPer on 20.03.2018.
 */

public interface WeatherServiceListener {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}