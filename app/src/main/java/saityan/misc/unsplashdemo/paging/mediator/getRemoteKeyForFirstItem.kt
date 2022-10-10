package saityan.misc.unsplashdemo.paging.mediator

import androidx.paging.PagingState
import saityan.misc.unsplashdemo.local.dao.UnsplashRemoteKeysDao
import saityan.misc.unsplashdemo.model.UnsplashImage
import saityan.misc.unsplashdemo.model.UnsplashRemoteKeys

suspend fun getRemoteKeyForFirstItem(
    state: PagingState<Int, UnsplashImage>,
    unsplashRemoteKeysDao: UnsplashRemoteKeysDao
): UnsplashRemoteKeys? {
    return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
        ?.let { unsplashImage ->
            unsplashRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
        }
}
