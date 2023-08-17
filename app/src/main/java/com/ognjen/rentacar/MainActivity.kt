package rs.ac.metropolitan.student.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.RentACarTheme
import rs.ac.metropolitan.student.navigation.NavSetup

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentACarTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                NavSetup(navController = navController)
            }
        }

    }
}
