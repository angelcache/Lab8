package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * This gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * This adds a city object to the list
     * for the first phase it will be
     * empty @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This returns whether or not a city belongs in the list
     * @param city
     *      The city that we check if it us is in our list or not
     * @return
     *      Returns a boolean
     */
    public Boolean hasCity(City city) {
        for (int i = 0; i < this.cities.size(); i++) {
            if (this.cities.get(i).equals(city)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * This checks if a city is present in the list. If it does then it removes it from the list,
     * if not then it throws an exception
     * @param city
     *      The city we try to remove from the list
     * @throws IllegalArgumentException
     *      Throws an IllegalArgumentException if the city we are trying to delete is not in the
     *      list.
     */
    public void delete(City city) {
        if (hasCity(city)) {
            this.cities.remove(city);
        } else {
            throw new IllegalArgumentException("City is not in the City List.");
        }
    }

    /**
     * This returns how many cities are in the list
     * @return
     *      Returns an int
     */
    public int countCities() {
        if (this.cities == null) {
            return 0;
        } else {
            return this.getCount();
        }
    }
}
