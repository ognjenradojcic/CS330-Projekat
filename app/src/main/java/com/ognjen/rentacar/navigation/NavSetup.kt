package rs.ac.metropolitan.student.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ognjen.rentacar.AppViewModel
import com.ognjen.rentacar.activities.HomeActivity
import com.ognjen.rentacar.activities.LoginActivity
import com.ognjen.rentacar.activities.RegisterActivity

@Composable
fun NavSetup(navController: NavHostController) {
    val vm: AppViewModel = viewModel()
    val paddingValues = PaddingValues()
    vm.navController = navController

    NavHost(navController = navController, startDestination = NavigationRoutes.Login.route) {
        composable(route = NavigationRoutes.Login.route) {
            LoginActivity(vm, paddingValues)
        }

        composable(route = NavigationRoutes.Register.route){
            RegisterActivity(vm, paddingValues)
        }

        composable(route = NavigationRoutes.Home.route) {
            HomeActivity(vm, paddingValues)
        }

    }
}