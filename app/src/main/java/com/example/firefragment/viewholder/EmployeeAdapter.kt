package com.example.firefragment.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.firefragment.R
import com.example.firefragment.model.Employee
import java.text.DecimalFormat

class EmployeeAdapter (val context: Context, options: FirestoreRecyclerOptions<Employee>) : FirestoreRecyclerAdapter<Employee,EmployeeHolder>(options) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {

        return EmployeeHolder(
            LayoutInflater.from(context).inflate(R.layout.list_employee, parent, false)
        )

    }


    override fun onBindViewHolder(holder: EmployeeHolder, position: Int, model: Employee) {

        val df = DecimalFormat("#,###")

        holder.name.text = model.name

        holder.address.text = model.address

        holder.phone.text = model.phone

        holder.salary.text = "Rp${df.format(model.salary)}"

    }
}

