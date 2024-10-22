package com.luis.contactlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter :
    ListAdapter<Contact, ContactListAdapter.ContactViewHolder>(ContactDiffUtils()) {

    private lateinit var onItemClicked: (Contact) -> Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onItemClicked)
    }

    fun setOnClickListener(onCLick: (Contact) -> Unit) {
        onItemClicked = onCLick

    }

    class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val phone = itemView.findViewById<TextView>(R.id.phone)
        private val image = itemView.findViewById<ImageView>(R.id.image)

        fun bind(contact: Contact, onClick: (Contact) -> Unit) {
            name.text = contact.name
            phone.text = contact.phone
            image.setImageResource(contact.icon)
            view.setOnClickListener {
                onClick.invoke(contact)
            }


        }

    }

    class ContactDiffUtils : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name && oldItem.phone == newItem.phone

        }
    }



}