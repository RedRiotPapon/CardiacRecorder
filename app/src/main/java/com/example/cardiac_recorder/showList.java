package com.example.cardiac_recorder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class showList extends RecyclerView.Adapter<showList.ViewHolder> {

    private ArrayList<Measurement> MeasurementList=new ArrayList<>();
    private Context context;

    public showList(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    /**
     * creating viewHolder
     */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.showlist,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    /**
     * if any high or low blood pressure
     * there will be red sign
     */
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(MeasurementList.get(position).getDate());
        holder.time.setText(MeasurementList.get(position).getTime());
        holder.syspr.setText(Integer.toString(MeasurementList.get(position).getSystolicPressure()));
        holder.diaspr.setText(Integer.toString(MeasurementList.get(position).getDiastolicPressure()));
        if((MeasurementList.get(position).getDiastolicPressure()<60) || (MeasurementList.get(position).getDiastolicPressure()>90) )
        {

            holder.diaspr.setTextColor(Color.RED);
        }
        if((MeasurementList.get(position).getSystolicPressure()<90) ||(MeasurementList.get(position).getSystolicPressure()>140))
        {
            holder.syspr.setTextColor(Color.RED);

        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ConditionDetails.class);
                intent.putExtra("data", MeasurementList.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    /**
     * count item on list view
     */
    public int getItemCount() {
        return MeasurementList.size();
    }

    public void setMeasurementList(ArrayList<Measurement> measurementList) {
        MeasurementList = measurementList;
        notifyDataSetChanged();
    }

    /**
     * recycler view
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView date;
        private TextView time;
        private TextView syspr;
        private TextView diaspr;
        private ConstraintLayout parent;

        /**
         * item added in recycler view
         * @param itemView
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            time=itemView.findViewById(R.id.time);
            syspr=itemView.findViewById(R.id.syspr);
            diaspr=itemView.findViewById(R.id.diaspr);
            parent = itemView.findViewById(R.id.measurelist);
        }
    }
}

