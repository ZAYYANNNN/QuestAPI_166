package com.example.duabelas.ui.home

import com.example.duabelas.model.Mahasiswa

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object  Error : HomeUiState()
    object Loading : HomeUiState()
}