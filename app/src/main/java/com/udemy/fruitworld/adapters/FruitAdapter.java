package com.udemy.fruitworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.udemy.fruitworld.R;
import com.udemy.fruitworld.model.Fruit;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.fruitList.get(i);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        //View Holder Pattern
        ViewHolder holder;
        if (convertView == null) {
            //Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            //Referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            holder.originTextView = (TextView) convertView.findViewById(R.id.textViewOrigin);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Fruit currentFruit = fruitList.get(pos);
        holder.nameTextView.setText(currentFruit.getName());
        holder.originTextView.setText(currentFruit.getOrigin());
        holder.imageView.setImageResource(currentFruit.getIcon());


        return convertView;
    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView originTextView;
        private ImageView imageView;
    }
}
