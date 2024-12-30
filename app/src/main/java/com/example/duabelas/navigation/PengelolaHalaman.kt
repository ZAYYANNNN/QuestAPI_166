package com.example.duabelas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.duabelas.ui.View.DestinasiDetail
import com.example.duabelas.ui.View.DestinasiEntry
import com.example.duabelas.ui.View.DestinasiHome
import com.example.duabelas.ui.View.DestinasiUpdate
import com.example.duabelas.ui.View.DetailView
import com.example.duabelas.ui.View.EntryMhsScreen
import com.example.duabelas.ui.View.HomeScreen
import com.example.duabelas.ui.View.UpdateView

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = {
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route){
                    popUpTo(DestinasiHome.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(DestinasiDetail.routesWithArg) { backStackEntry ->
            // Mendapatkan NIM dari argument route
            val nim = backStackEntry.arguments?.getString(DestinasiDetail.NIM)

            nim?.let {
                DetailView(
                    nim = it, // Mengirimkan NIM ke DetailMhsView
                    navigateBack = {
                        // Aksi ketika tombol "Kembali" ditekan
                        navController.navigate(DestinasiHome.route) {
                            popUpTo(DestinasiHome.route) {
                                inclusive = true // Pop sampai ke DestinasiHome
                            }
                        }
                    },
                    onEditClick = {
                        // Navigasi ke halaman update dengan NIM sebagai argumen
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routesWithArg, // Correct route with argument
            arguments = listOf(
                navArgument(DestinasiUpdate.NIM) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            // Retrieve the 'nim' argument from the navBackStackEntry
            val nim = backStackEntry.arguments?.getString(DestinasiUpdate.NIM)

            nim?.let {
                // Pass 'nim' to the UpdateView composable
                UpdateView(
                    navigateBack = {
                        navController.popBackStack()
                    },

                    modifier = modifier

                    )
            }
        }
    }
}