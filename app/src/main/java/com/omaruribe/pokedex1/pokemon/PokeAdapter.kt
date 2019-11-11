package com.omaruribe.pokedex1.pokemon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.omaruribe.pokedex1.R
import com.squareup.picasso.Picasso

class PokeAdapter(var pokeList: ArrayList<Pokemon>) : Adapter<PokeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_pokemon,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val poke : Pokemon = pokeList[position]

        holder.pokeName.text = poke.name

        var picasso = Picasso.get()
        var url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position+1}.png"
        picasso.load(url).into(holder.pokeView)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val pokeName = itemView.findViewById<TextView>(R.id.pokeName)
        val pokeView = itemView.findViewById<ImageView>(R.id.pokeView)
    }

}