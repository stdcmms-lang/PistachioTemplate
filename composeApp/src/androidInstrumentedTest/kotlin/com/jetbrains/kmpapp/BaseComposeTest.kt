package com.jetbrains.kmpapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestName
import java.io.File

/**
 * Base test class for Compose UI tests with video recording functionality.
 * 
 * All test classes should extend this class to automatically get:
 * - Compose test rule
 * - Test name rule
 * - Video recording setup/teardown
 * 
 * Override [setUp] and [tearDown] if you need additional setup/cleanup logic.
 */
abstract class BaseComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val testName = TestName()

    private var videoFile: File? = null

    @Before
    open fun setUp() {
        startVideoRecording()
    }

    @After
    open fun tearDown() {
        stopVideoRecording()
    }

    private fun startVideoRecording() {
        try {
            val instrumentation = InstrumentationRegistry.getInstrumentation()
            val context = instrumentation.targetContext

            // Get external files directory
            val externalFilesDir = context.getExternalFilesDir(null) ?: return

            // Generate filename with test name
            val testMethodName = testName.methodName
            videoFile = File(externalFilesDir, "screenrecord_${testMethodName}.mp4")
            
            // Delete existing file if it exists to allow overwriting
            if (videoFile!!.exists()) {
                videoFile!!.delete()
            }

            // Start recording using adb shell screenrecord
            // Note: screenrecord has a default 3-minute limit which is plenty for a test
            instrumentation.uiAutomation.executeShellCommand("screenrecord ${videoFile!!.absolutePath}")
        } catch (e: Exception) {
            android.util.Log.e(getLogTag(), "Failed to start video recording", e)
        }
    }

    private fun stopVideoRecording() {
        try {
            // Ensure test is at least 1s long
            Thread.sleep(1000)

            // Send SIGINT to screenrecord to stop it gracefully so the MP4 header is written correctly
            InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("pkill -2 screenrecord")
            
            // Give it a moment to finish writing the file
            Thread.sleep(500)

            videoFile?.let {
                android.util.Log.d(getLogTag(), "Video saved to: ${it.absolutePath}")
            }
        } catch (e: Exception) {
            android.util.Log.e(getLogTag(), "Failed to stop video recording", e)
        }
    }

    /**
     * Returns the log tag for this test class. Override if you want a custom tag.
     */
    protected open fun getLogTag(): String = this::class.simpleName ?: "BaseComposeTest"
}
