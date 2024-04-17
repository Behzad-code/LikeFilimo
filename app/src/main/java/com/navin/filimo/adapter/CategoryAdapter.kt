package com.navin.filimo.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.navin.filimo.R
import com.navin.filimo.models.Category
import com.squareup.picasso.Picasso

class CategoryAdapter(activity: Activity, mutableList : List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryVh>(){

    val categories = mutableList
    val activity = activity


    class CategoryVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCategory = itemView.findViewById<AppCompatImageView>(R.id.img_category)
        val txtTitle = itemView.findViewById<AppCompatTextView>(R.id.txt_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVh {
        val view = LayoutInflater.from(activity).inflate(R.layout.category_adapter,null)
        return CategoryVh(view)

    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryVh, position: Int) {

        val category = categories.get(position)
        holder.txtTitle.setText(category.categoryName)
        Picasso.get().load(category.categoryImage).into(holder.imgCategory)
    }
}