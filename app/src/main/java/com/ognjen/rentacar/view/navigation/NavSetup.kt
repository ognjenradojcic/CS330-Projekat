package rs.ac.metropolitan.student.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ognjen.rentacar.view.AppViewModel
import com.ognjen.rentacar.view.activities.AccountActivity
import com.ognjen.rentacar.view.activities.HomeActivity
import com.ognjen.rentacar.view.activities.InternetCheckActivity
import com.ognjen.rentacar.view.activities.LocationActivity
import com.ognjen.rentacar.view.activities.LoginActivity
import com.ognjen.rentacar.view.activities.OrdersActivity
import com.ognjen.rentacar.view.activities.RegisterActivity

@Composable
fun NavSetup(navController: NavHostController) {
    val vm: AppViewModel = viewModel()
    vm.navController = navController

    NavHost(navController = navController, startDestination = NavigationRoutes.InternetCheck.route) {
        composable(route = NavigationRoutes.InternetCheck.route){
            InternetCheckActivity(vm)
        }
        composable(route = NavigationRoutes.Login.route) {
            LoginActivity(vm)
        }

        composable(route = NavigationRoutes.Register.route) {

            RegisterActivity(vm)
        }

        composable(route = NavigationRoutes.Home.route) {
            HomeActivity(vm)
        }

        composable(route = NavigationRoutes.Orders.route){
            OrdersActivity(vm)
        }

        composable(route = NavigationRoutes.Account.route){
            AccountActivity(vm)
        }

        composable(route = NavigationRoutes.Location.route){
            LocationActivity(vm)
        }

    }
}