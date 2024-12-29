package com.example.duabelas.repository

import com.example.duabelas.model.Mahasiswa

interface MahasiswaRepository{
    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun  insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun  deleteMahasiswa(nim: String)

    suspend fun getMahasiswabyNim(nim: String): Mahasiswa
}
