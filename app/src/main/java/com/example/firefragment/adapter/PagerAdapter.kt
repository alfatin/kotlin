package com.example.firefragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.firefragment.Fragments.FragmentCreat
import com.example.firefragment.Fragments.FragmentGet
import com.example.firefragment.Fragments.FragmentUpdate

class PagerAdapter(fm : FragmentManager): FragmentPagerAdapter (fm) {


    //list fragment

    private val pages = listOf(

        FragmentCreat(),

        FragmentGet(),

        FragmentUpdate()

    )


    //menentukan fragment yang dibuka pada posisi tertentu

    override fun getItem(position: Int): Fragment= pages[position]


    //mendapatkan size dari listnya

    override fun getCount(): Int = pages.size


    override fun getPageTitle(position: Int): CharSequence? {

        return when(position) {

            0 -> "Creat Employees"

            1 -> "Get Employess"

            else -> "Update Employees"

        }

    }

}