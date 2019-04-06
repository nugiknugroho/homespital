package com.nugik.myapplication.TabLayoutAdapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatChat.TabLayoutDetailChat.ProfilDokterFragment
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatChat.TabLayoutDetailChat.RiwayatChat

class DetailTabPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
            ProfilDokterFragment(),
            RiwayatChat()
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
            0 -> "Profil"
            1 -> "Chat"
            else -> null
        }
    }
}