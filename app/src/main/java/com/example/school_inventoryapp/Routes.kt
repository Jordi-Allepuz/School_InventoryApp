package com.example.school_inventoryapp


sealed class Routes(val route: String) {
    object LoginScreen : Routes("loginscreen")
    object UserInfoScreen : Routes ("userinfoscreen")
    object SignUpScreen : Routes ("signupscreen")
    object MaterialInfoScreen : Routes ("materialinfoscreen")
    object MaterialListScreen : Routes ("materiallistscreen")
    object MaterialCreateScreen : Routes ("materialcreatescreen")
    object AppInfoScreen : Routes ("appinfoscreen")
}
