package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel

@Composable
fun UserInfoContent(
    userInfoViewModel: UserInfoViewModel,
    navigationController: NavHostController,
    paddingValues: PaddingValues
) {
    val brush =
        Brush.linearGradient(listOf(MaterialTheme.colorScheme.background, Color(0xFFEBB25B)))

    val user: User? by userInfoViewModel.user.observeAsState()

    LaunchedEffect(Unit) {
        userInfoViewModel.getInfoUser()
    }

    if (user == null) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            ProgressIndicatorLogo()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(brush)
                .padding(paddingValues)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserInfoCard(user!!)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
        }
    }
}
