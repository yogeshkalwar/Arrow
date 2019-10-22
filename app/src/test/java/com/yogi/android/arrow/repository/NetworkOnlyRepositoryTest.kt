package com.yogi.android.arrow.repository

import com.yogi.android.arrow.RxImmediateSchedulerRule
import com.yogi.android.arrow.model.*
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

/**
 * Created on 2019-10-22.
 */
class NetworkOnlyRepositoryTest {

    @Rule @JvmField val rule = MockitoJUnit.rule()!!
    @Rule @JvmField var testSchedularRule = RxImmediateSchedulerRule()
    @Mock lateinit var repository: Repository
    internal lateinit var networkOnlyRepository: NetworkOnlyRepository

    @Before
    fun setup() {
        networkOnlyRepository = NetworkOnlyRepository(repository)
    }

    @Test
    fun testCityWeatherApi() {
        val response = City(Coordinate(-0.13f, 51.51f),
            listOf(Weather(800, "Clear", "clear sky", "01d")),
            Main(283.41f, 1025, 76, 281.48f, 285.37f),
            10000, Wind(1.5f), Clouds(0), 1571738787, 2643743, "London", 200)
        Mockito.`when`(repository.getCityWeather("London")).thenReturn(Single.just(response))
        val result = networkOnlyRepository.getCityWeather("London")
        val testObserver = TestObserver<City>()
        result.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val city = testObserver.values()[0]
        assertThat(city.coordinate?.longitude, `is`(-0.13f))
        assertThat(city.coordinate?.lattitude, `is`(51.51f))
        assertThat(city.weather?.get(0)?.id, `is`(800))
        assertThat(city.weather?.get(0)?.main, `is`("Clear"))
        assertThat(city.weather?.get(0)?.description, `is`("clear sky"))
        assertThat(city.id, `is`(2643743))
        assertThat(city.name, `is`("London"))
        assertThat(city.code, `is`(200))
    }
}