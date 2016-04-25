package com.example.tarik.athletto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by tarik on 9/3/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    LayoutInflater layoutInflater;
    Context c;

    List<DummyInformation> data = Collections.emptyList();

    public MyAdapter(Context context, List<DummyInformation> data){
        layoutInflater = LayoutInflater.from(context);
        this.data = data;
        c = context;
        //Toast.makeText(context,data.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {      // it will create a view. it will take the xml file of the row ie custom_row.xml
        View view = layoutInflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        // Toast.makeText(c,"OnCreateView",Toast.LENGTH_SHORT).show();
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {           // it will fetch the data and get position in the row

        DummyInformation current = data.get(position);
        holder.nameofperson.setText(current.name);
        holder.ageofperson.setText(String.valueOf(current.age)+"Yrs");
        holder.hometownofperson.setText(current.hometown);
        holder.prefrredgames.setText("MY GAMES -->"+current.prefrences);
        //Toast.makeText(c,current.name,Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameofperson;
        TextView ageofperson;
        TextView hometownofperson;
        TextView prefrredgames ;
        public MyViewHolder(View itemView) {
            super(itemView);
            nameofperson = (TextView) itemView.findViewById(R.id.nameofperson);
            ageofperson = (TextView) itemView.findViewById(R.id.ageofperson);
            hometownofperson = (TextView) itemView.findViewById(R.id.howntownofperson);
            prefrredgames = (TextView) itemView.findViewById(R.id.prefrerredgames);
        }
    }
}
