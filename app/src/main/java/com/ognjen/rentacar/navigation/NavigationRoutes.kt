package rs.ac.metropolitan.student.navigation

sealed class NavigationRoutes(val route: String) {
    object Login : NavigationRoutes(route = "login")
    object Register : NavigationRoutes(route = "register")
    object Home : NavigationRoutes(route = "home")
    object Orders : NavigationRoutes(route = "orders")
    object Location : NavigationRoutes(route = "location")
    object Account : NavigationRoutes(route = "account")
}