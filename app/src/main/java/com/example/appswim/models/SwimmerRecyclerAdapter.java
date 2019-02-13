/*

package com.example.appswim.models;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appswim.R;
import com.example.appswim.Swimmer;

import java.util.List;

public class SwimmerRecyclerAdapter extends RecyclerView.Adapter<SwimmerRecyclerAdapter.ViewHolder> {

    // Creo que es una accion que llama a la clase y
    // pone los elementos en fila en la pantalla
    interface ActionCallBack {
        void onLongClickListener(Swimmer swimmer);
    }

    private Context context;
    private List<Swimmer> swimmerList;
    private int[] colors;
    private ActionCallBack mActionCallbacks;

    SwimmerRecyclerAdapter(Swimmer swimmer, List<Swimmer> swimmerList, int[] colors) {
        this.context = context;
        this.swimmerList = swimmerList;
        this.colors = colors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_swimmer, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView mNameTextView;
        private TextView mInitialsTextView;
        private GradientDrawable mInitialsBackground;

        ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnLongClickListener(this);

            mInitialsTextView = itemView.findViewById(R.id.initialsTextView);
            mNameTextView = itemView.findViewById(R.id.nameTextView);
            mInitialsBackground = (GradientDrawable) mInitialsTextView.getBackground();
        }

    }
}
 */