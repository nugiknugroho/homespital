package com.nugik.myapplication.TabLayoutAdapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatChat.HistoryChatFragment
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatMenu.HistoryMenuFragment

class MyPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
            HistoryMenuFragment(),
            HistoryChatFragment()
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // judul untuk tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Riwayat Menu"
            1 -> "Riwayat Chat"
            else -> null
        }
    }
}