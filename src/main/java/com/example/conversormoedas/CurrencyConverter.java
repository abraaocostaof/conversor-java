package com.example.conversormoedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private JsonObject rates;

    public CurrencyConverter(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        this.rates = jsonObject.getAsJsonObject("conversion_rates");
    }

    public double convert(String from, String to, double amount) {
        double fromRate = rates.get(from).getAsDouble();
        double toRate = rates.get(to).getAsDouble();
        return (amount / fromRate) * toRate;
    }
}
