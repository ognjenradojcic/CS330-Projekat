package com.ognjen.rentacar

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import rs.ac.metropolitan.student.navigation.NavigationRoutes


class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController
//    val repository = Repository()
    var granted = mutableStateOf(false)

//    private val _students = MutableLiveData<List<StudentItem>>()
//    val students: LiveData<List<StudentItem>>
//        get() = _students

    // Komunikacija sa repozitorijumom
//    fun loadStudents() {
//        GlobalScope.launch {
//            repository.loadStudents()
//            MainScope().launch {
//                repository.studentsFlow.collect {
//                    _students.value = it
//                }
//            }
//        }
//    }

//    fun getStudent(id: String): StudentItem? {
//        return _students.value?.find { it.id == id }
//    }
//    fun deleteStudent(id: String) {
//        GlobalScope.launch {
//            repository.deleteStudent(id)
//        }
//        goBack()
//    }
//
//    fun submitStudent(student: StudentItem) {
//        GlobalScope.launch {
//            repository.submitStudent(student)
//        }
//    }

    // Routing methods

    fun login(){
        navController.navigate(NavigationRoutes.Home.route)
    }

    fun register(){
        navController.navigate(NavigationRoutes.Login.route)
    }

    fun navigateToLogin(){
        navController.navigate(NavigationRoutes.Login.route)
    }
    fun navigateToRegister(){
        navController.navigate(NavigationRoutes.Register.route)
    }

    fun goBack() {
        navController.popBackStack()
    }
}