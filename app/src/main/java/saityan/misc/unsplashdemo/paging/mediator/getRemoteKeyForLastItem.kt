package saityan.misc.unsplashdemo.paging.mediator

import androidx.paging.PagingState
import saityan.misc.unsplashdemo.local.dao.UnsplashRemoteKeysDao
import saityan.misc.unsplashdemo.model.UnsplashImage
import saityan.misc.unsplashdemo.model.UnsplashRemoteKeys

suspend fun getRemoteKeyForLastItem(
    state: PagingState<Int, UnsplashImage>,
    unsplashRemoteKeysDao: UnsplashRemoteKeysDao
): UnsplashRemoteKeys? {
    return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
        ?.let { unsplashImage ->
            unsplashRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
        }
}
