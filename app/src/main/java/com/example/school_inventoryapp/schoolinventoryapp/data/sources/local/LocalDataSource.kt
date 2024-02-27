package com.example.school_inventoryapp.schoolinventoryapp.data.sources.local

import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import android.content.Context

class LocalDataSource @Inject constructor(@ApplicationContext private val context: Context ) {
}