package com.topguide.topguide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.topguide.topguide.R;
import com.topguide.topguide.model.Tour;

import java.util.ArrayList;

/**
 * Created by Igor on 6/28/2017.
 */

public class TourAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Tour> tours;

    public TourAdapter(Context con, ArrayList<Tour> tours) {
        context = con;
        this.tours = tours;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tours.size();
    }

    @Override
    public Object getItem(int i) {
        return tours.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Tour currentTour = (Tour) getItem(i);

        final ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_layout, viewGroup, false);
            holder = new ViewHolder();
            holder.tourName = (TextView) view.findViewById(R.id.tour_name);
            holder.cityName = (TextView) view.findViewById(R.id.city_name);
            holder.startDate = (TextView) view.findViewById(R.id.tour_date);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tourName.setText(currentTour.getName());
        holder.cityName.setText(currentTour.getPlaceName().getName());
        holder.startDate.setText(currentTour.getStartDate().toString());

        return view;
    }


    private static class ViewHolder {
        private TextView tourName;
        private TextView cityName;
        private TextView startDate;
    }
}
