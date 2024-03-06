package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialslist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.R
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel


@Composable
fun ContentMaterialList(
    userInfoViewModel: UserInfoViewModel,
    materialsInfoViewModel: MaterialsInfoViewModel,
    navigationController: NavHostController,
    paddingValues: PaddingValues
) {

    val materials: List<Material>? by materialsInfoViewModel.materialList.observeAsState()

    val lazyListState = rememberLazyListState()
    var scrolled = 0f
    var previousOffset = 0

    LaunchedEffect(Unit) {
        materialsInfoViewModel.getMaterialList()
    }

    if (materials == null) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            ProgressIndicatorLogo()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            LazyColumn(state = lazyListState,content = {
                item {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp)
                            .padding(top = 6.dp)
                            .graphicsLayer {
                                scrolled += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                translationY = scrolled * 0.5f
                                previousOffset = lazyListState.firstVisibleItemScrollOffset
                            },
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.drawerimage),
                        contentDescription = ""
                    )
                }
                items(materials!!) { material ->
                    MaterialListCard(material, userInfoViewModel, navigationController)
                }
            }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
        }
    }
}

