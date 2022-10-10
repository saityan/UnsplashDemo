package saityan.misc.unsplashdemo.paging.mediator

import androidx.paging.PagingState
import saityan.misc.unsplashdemo.local.dao.UnsplashRemoteKeysDao
import saityan.misc.unsplashdemo.model.UnsplashImage
import saityan.misc.unsplashdemo.model.UnsplashRemoteKeys

suspend fun getRemoteKeyClosestToCurrentPosition(
    state: PagingState<Int, UnsplashImage>,
    unsplashRemoteKeysDao: UnsplashRemoteKeysDao
): UnsplashRemoteKeys? {
    return state.anchorPosition?.let { position ->
        state.closestItemToPosition(position)?.id?.let { id ->
            unsplashRemoteKeysDao.getRemoteKeys(id = id)
        }
    }
}
