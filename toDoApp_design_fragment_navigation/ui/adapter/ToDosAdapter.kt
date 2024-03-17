package com.gulcihan.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.gulcihan.todoapp.data.entity.ToDos
import com.gulcihan.todoapp.databinding.CardDesignBinding
import com.gulcihan.todoapp.databinding.FragmentUpdateBinding
import com.gulcihan.todoapp.ui.fragment.MainFragmentDirections

class ToDosAdapter (var mcontext : Context, var toDostList : List<ToDos> )
    : RecyclerView.Adapter<ToDosAdapter.CardDesignHolder>() {


    inner class CardDesignHolder(var binding : CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {

        val binding = CardDesignBinding.inflate(LayoutInflater.from(mcontext), parent, false)
        return  CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {

        val toDo = toDostList.get(position)
        val design = holder.binding
        design.textViewName.text = toDo.name

        design.cardViewRaw.setOnClickListener {
            val toUpdateScreen = MainFragmentDirections.toUpdateScreen(toDo = toDo)
            Navigation.findNavController(it).navigate(toUpdateScreen)  //it=binding.floatingActionButton2
        }

        design.imageViewDelete.setOnClickListener {

            Snackbar.make(it,"Do you want to delete? ${toDo.name} ? ",Snackbar.LENGTH_LONG)
                .setAction("Yes"){
                    delete(toDo.id)
                }.show()
        }  //it=design.imageViewDelete

    }

    override fun getItemCount(): Int {
        return toDostList.size
    }

    fun delete (id :Int){
        Log.e("ToDoOutput delete", id.toString())

    }

}