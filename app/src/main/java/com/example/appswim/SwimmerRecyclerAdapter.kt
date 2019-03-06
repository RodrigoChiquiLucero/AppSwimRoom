package com.example.appswim

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.appswim.models.Swimmer




class SwimmerRecyclerAdapter internal constructor(private val context: Context, private var swimmerList: List<Swimmer>?, private val colors: IntArray) : RecyclerView.Adapter<SwimmerRecyclerAdapter.ViewHolder>() {

    private var mActionCallbacks: ActionCallback? = null

    interface ActionCallback {
        fun onLongClickListener(swimmer: Swimmer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_swimmer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return swimmerList!!.size
    }

    internal fun updateData(swimmers: List<Swimmer>) {
        this.swimmerList = swimmers
        notifyDataSetChanged()
    }

    // ViewHolder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnLongClickListener {

        private val mNameTextView: TextView
        private val mInitialsTextView: TextView
        private val mInitialsBackground: GradientDrawable

        init {

            itemView.setOnLongClickListener(this)

            mInitialsTextView = itemView.findViewById(R.id.initialsTextView)
            mNameTextView = itemView.findViewById(R.id.nameTextView)
            mInitialsBackground = mInitialsTextView.background as GradientDrawable
        }

        fun bindData(position: Int) {
            val swimmer = swimmerList!![position]

            val fullName = swimmer.FirstName + " " + swimmer.LastName
            mNameTextView.text = fullName

            val initial = swimmer.FirstName.toUpperCase().substring(0, 1)
            mInitialsTextView.setText(initial)

            mInitialsBackground.setColor(colors[position % colors.size])
        }

        override fun onLongClick(view: View): Boolean {
            if (mActionCallbacks != null) {
                mActionCallbacks!!.onLongClickListener(swimmerList!![adapterPosition])
            }
            return true
        }
    }

    fun addActionCallback(actionCallbacks: ActionCallback){
        mActionCallbacks = actionCallbacks
    }
}

