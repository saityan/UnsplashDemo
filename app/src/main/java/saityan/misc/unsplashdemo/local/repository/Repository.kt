package saityan.misc.unsplashdemo.local.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import saityan.misc.unsplashdemo.local.UnsplashDatabase
import saityan.misc.unsplashdemo.model.UnsplashImage
import saityan.misc.unsplashdemo.paging.mediator.UnsplashRemoteMediator
import saityan.misc.unsplashdemo.remote.UnsplashApi
import saityan.misc.unsplashdemo.utils.Constants.ITEMS_PER_PAGE
import javax.inject.Inject

@ExperimentalPagingApi
class Repository  @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {

        val pagingSourceFactory = {
            unsplashDatabase.unsplashImageDao().getAllImages()
        }

        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        )
        .flow
    }
}
