package com.example.duabelas.ui.home.viewModel

import android.app.Application
import com.example.duabelas.ui.AppContainer
import com.example.duabelas.ui.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}