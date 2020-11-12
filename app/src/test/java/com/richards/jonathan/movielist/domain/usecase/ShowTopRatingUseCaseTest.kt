package com.richards.jonathan.movielist.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.richards.jonathan.movielist.data.Status
import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.data.network.CallHandler
import com.richards.jonathan.movielist.data.network.contract.NetworkHelperContract
import com.richards.jonathan.movielist.utils.NetworkTestHelper
import com.richards.jonathan.movielist.utils.TestModule
import com.richards.jonathan.movielist.utils.TestResponse
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class ShowTopRatingUseCaseTest : KoinTest {

    val networkHelper: NetworkHelperContract by inject()
    val showTopRatingUseCase: ShowTopRatingUseCase by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        startKoin {
            modules(listOf(TestModule.getTestModules()))
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun getTopRatedMovies() {
        (networkHelper as NetworkTestHelper).setMockedResponse(TestResponse("discover.json", 200))

        val response = CallHandler<MovieListResponse>().makeCall(showTopRatingUseCase.getTopRatedMovies("en-US",
                "popularity.desc")).test()
                .awaitValue()
                .assertHasValue()
                .assertValue { it.status == Status.Loading }
                .awaitNextValue()
                .assertValue {
                    it.status == Status.Success
                }
                .value()
        val data = response.data

        if (data != null) {
            assert(data.totalResults == 397962)
            assert(data.totalPages > 0)

            val results = data.results

            assert(results.size > 1)
            assert(results.get(0).id != null)
        } else {
            assert(false)
        }
    }
}