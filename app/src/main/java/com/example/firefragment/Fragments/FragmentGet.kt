package com.example.firefragment.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firefragment.model.Employee
import com.example.firefragment.viewholder.EmployeeAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_get.*

class FragmentGet : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.firefragment.R.layout.fragment_creat, container, false)

        v = inflater.inflate(R.layout.fragment_get, container, false)

        shimmer =  v.findViewById(R.id.shimmer)

        loadData()

        return v
    }
    private fun loadData() {

        val db = FirebaseFirestore.getInstance()

        val query = db.collection("employees")

        //Membangun FirestoreRecyclerOptions untuk mendapatkan querynya

        val option = FirestoreRecyclerOptions.Builder<Employee>()

            .setQuery(query, Employee::class.java)

            .build()

        //Buat objek adapter

        adapter = EmployeeAdapter(activity!!.baseContext, option)



        //Cek apakah query akan jalan atau tidak

        //Kalau jalan akan kodingan di blok addOnSuccessListener akan dijalankan

        query.get().addOnSuccessListener {

            //Berhentikan animasi shimmer


            shimmer.stopShimmer()

            shimmer.visibility = View.GONE



            //Membangun recyclerview adapter

            activity?.rv_emp?.setHasFixedSize(true)

            activity?.rv_emp?.adapter = EmployeeAdapter

            activity?.rv_emp?.layoutManager = LinearLayoutManager(activity)

            Toast.makeText(activity, "Success: ${it}", Toast.LENGTH_LONG).show()

        }.addOnFailureListener { err ->

            Toast.makeText(activity, "Error: ${err}", Toast.LENGTH_LONG).show()

        }
        override fun onStart() {

            super.onStart()

            Emadapter.startListening()

            shimmer.startShimmer()

        }


        override fun onPause() {

            shimmer.stopShimmer()

            super.onPause()

            adapter.stopListening()

        }
}
