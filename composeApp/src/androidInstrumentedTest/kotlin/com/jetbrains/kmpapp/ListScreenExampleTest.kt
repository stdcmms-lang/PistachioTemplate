package com.jetbrains.kmpapp

import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jetbrains.kmpapp.screens.list.ListScreenExample
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

@RunWith(AndroidJUnit4::class)
class ListScreenExampleTest : BaseComposeTest() {

    private val testDataModule = createTestDataModule()

    @Before
    override fun setUp() {
        super.setUp()
        // Koin is already initialized in MuseumApp.onCreate()
        // Load test module to override the production storage with fake data
        loadKoinModules(testDataModule)
    }

    @After
    override fun tearDown() {
        // Unload test module to restore production behavior
        unloadKoinModules(testDataModule)
        // Do not stop Koin here as it will affect other tests in the same process
        super.tearDown()
    }

    @Test
    fun testListScreenDisplaysContentAndScrolling() {
        composeTestRule.setContent {
            ListScreenExample(
                navigateToDetails = {
                }
            )
        }

        // Wait for the screen to load
        Thread.sleep(500)

        // Perform swipe up gesture to simulate scrolling down
        // Find the root node and perform swipe gesture
        composeTestRule.onRoot().performTouchInput {
            swipeUp()
        }

        // Wait a bit for the scroll to complete
        Thread.sleep(1000)
    }
}
