package com.example.firefragment.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_employee.view.*

class EmployeeHolder(v : View) : RecyclerView.ViewHolder(v) {


    val name = v.emp_name

    val address = v.emp_address

    val phone = v.emp_phone

    val salary = v.emp_salary


}