package com.yogi.android.arrow

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import com.yogi.android.arrow.ui.MainActivity
import com.yogi.android.arrow.viewmodel.city.CityWeatherViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.net.HttpURLConnection

/**
 * Created on 2019-10-25.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class CityTest: BaseTest() {
    @Rule
    @JvmField
    val immediateSchedulerRule = RxImmediateSchedulerRule()

    private lateinit var activity: MainActivity
    private lateinit var viewModel: CityWeatherViewModel

    override fun isMockServerEnabled(): Boolean = true

    @Before
    override fun setup() {
        super.setup()
        activity = Robolectric.setupActivity(MainActivity::class.java)
        viewModel = ViewModelProviders.of(activity, viewModelFactory)[CityWeatherViewModel::class.java]
    }

    @Test
    fun getCityWhenSuccess() {
        mockHttpResponse("city.json", HttpURLConnection.HTTP_OK)
        assertEquals("City should be null as stream not started yet", viewModel.getCity().value, null)
        viewModel.load()
        assertEquals("London", viewModel.getCity().value?.name)
    }
}