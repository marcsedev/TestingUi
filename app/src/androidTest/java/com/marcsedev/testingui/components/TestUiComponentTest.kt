package com.marcsedev.testingui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class TestUiComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            TestUiComponent()
        }

        //FINDER
        composeTestRule.onNodeWithText("ada lovelace", ignoreCase = true)
        composeTestRule.onNodeWithTag("component2")
        composeTestRule.onNodeWithContentDescription("profileImage")

        composeTestRule.onAllNodesWithText("a", ignoreCase = true)
        composeTestRule.onAllNodesWithTag("component2")
        composeTestRule.onAllNodesWithContentDescription("profileImage")
    }
}