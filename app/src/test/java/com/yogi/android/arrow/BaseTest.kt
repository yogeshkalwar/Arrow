package com.yogi.android.arrow

import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import com.yogi.android.arrow.di.*
import com.yogi.android.arrow.viewmodel.ViewModelFactory
import org.junit.After
import org.junit.Before
import java.io.File
import javax.inject.Inject

/**
 * Created on 2019-10-22.
 */
abstract class BaseTest {

    lateinit var mockServer: MockWebServer
    lateinit var testAppComponent: TestAppComponent
    @Inject lateinit var viewModelFactory: ViewModelFactory

    @Before
    open fun setup() {
        initMockServer()
        initDagger()
    }

    @After
    open fun tearDown() {
        stopMockServer()
    }

    open fun initMockServer() {
        if (isMockServerEnabled()) {
            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    open fun initDagger() {
        testAppComponent = DaggerTestAppComponent.builder().repositoryModule(
            RepositoryModule()).testRxJavaModule(TestRxJavaModule()).build()
        testAppComponent.inject(this)
    }

    open fun stopMockServer() {
        if (isMockServerEnabled()) {
            mockServer.shutdown()
        }
    }

    open fun mockHttpResponse(filename: String, responseCode: Int) = mockServer.enqueue(MockResponse()
        .setResponseCode(responseCode)
        .setBody(getJson(filename)))

    private fun getJson(filePath: String): String {
        val uri = this.javaClass.classLoader.getResource(filePath)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    abstract fun isMockServerEnabled(): Boolean
}