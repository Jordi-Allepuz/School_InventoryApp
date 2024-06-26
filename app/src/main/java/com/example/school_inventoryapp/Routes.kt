package com.example.school_inventoryapp


sealed class Routes(val route: String) {
    object LoginScreen : Routes("loginscreen")
    object UserInfoScreen : Routes ("userinfoscreen")
    object SignUpScreen : Routes ("signupscreen")
    object EditUserScreen : Routes ("edituserscreen")
    object MaterialInfoScreen : Routes ("materialinfoscreen")
    object MaterialListScreen : Routes ("materiallistscreen")
    object NewMaterialScreen : Routes ("newmaterialscreen")
    object EditMaterialScreen : Routes ("editmaterialscreen")
    object AppInfoScreen : Routes ("appinfoscreen")
}
