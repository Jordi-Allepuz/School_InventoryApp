package com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject

class StorageService @Inject constructor(private val firebaseStorage: FirebaseStorage, private val firebaseFirestore: FirebaseFirestore){
}