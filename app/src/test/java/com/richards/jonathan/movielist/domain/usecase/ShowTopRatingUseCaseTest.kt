package com.richards.jonathan.movielist.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.richards.jonathan.movielist.data.Status
import com.richards.jonathan.movielist.data.entity.MovieList
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
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.standalone.inject
import org.koin.test.KoinTest

class ShowTopRatingUseCaseTest : KoinTest {

    val networkHelper: NetworkHelperContract by inject()
    val showTopRatingUseCase: ShowTopRatingUseCase by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        loadKoinModules(listOf(TestModule.getTestModules()))
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getTopRatedMovies() {
        (networkHelper as NetworkTestHelper).setMockedResponse(TestResponse("discover.json", 200))

        val response = CallHandler<MovieList>().makeCall(showTopRatingUseCase.getTopRatedMovies("en-US",
                "popularity.desc")).test()
                .awaitValue()
                .assertHasValue()
                .assertValue { it.status == Status.LOADING }
                .awaitNextValue()
                .assertValue {
                    it.status == Status.SUCCESS
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