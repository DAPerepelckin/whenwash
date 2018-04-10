package com.example.dap.whenwash.data;

import org.json.JSONObject;

/**
 * Created by DAPer on 18.03.2018.
 */

public interface JSONPopulator {
    void populate(JSONObject data);

    JSONObject toJSON();
}