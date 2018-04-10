package com.example.dap.whenwash.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DAPer on 20.03.2018.
 */

public class LocationResult implements JSONPopulator {

    private String address;

    public String getAddress() {
        return address;
    }

    @Override
    public void populate(JSONObject data) {
        address = data.optString("formatted_address");
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();

        try {
            data.put("formatted_address", address);
        } catch (JSONException e) {}

        return data;
    }
}