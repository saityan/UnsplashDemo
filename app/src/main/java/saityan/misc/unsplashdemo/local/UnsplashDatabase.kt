package saityan.misc.unsplashdemo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import saityan.misc.unsplashdemo.local.dao.UnsplashImageDao
import saityan.misc.unsplashdemo.local.dao.UnsplashRemoteKeysDao
import saityan.misc.unsplashdemo.model.UnsplashImage
import saityan.misc.unsplashdemo.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}
