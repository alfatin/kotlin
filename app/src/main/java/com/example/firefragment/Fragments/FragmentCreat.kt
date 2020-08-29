package com.example.firefragment.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.firefragment.R
import com.example.firefragment.model.Employee
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_creat.*


class FragmentCreat : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_creat, container, false)

        val btnCreate : Button = view.findViewById(R.id.btn_create)

        btnCreate.setOnClickListener {

            val employee = Employee(edit_name.text.toString(),

                edit_address.text.toString(),

                edit_phone.text.toString(),

                Integer.parseInt(edit_salary.text.toString()))

            save (employee)

    }
        return view

    }

    fun save(employee: Employee) {

        val db = FirebaseFirestore.getInstance()

        //Menampilkan progressbar ketika method save dipanggil

        activity?.progress_circular?.visibility = View.VISIBLE

        //Menghilangkan form

        activity?.linear?.visibility = View.GONE

        //Menentukan collection

        db.collection("employees")

            //Method add untuk menambahkan data kedalam firebase

            .add(employee)

            .addOnSuccessListener { success ->

                Toast.makeText(activity, "Success Insert Employee", Toast.LENGTH_LONG).show()

                //Restart Activity

                val intent = activity?.intent

                activity?.finish()

                activity?.startActivity(intent)

            }

            .addOnFailureListener {err ->

                Toast.makeText(activity, "Error: ${err}", Toast.LENGTH_LONG).show()

            }

    }


}