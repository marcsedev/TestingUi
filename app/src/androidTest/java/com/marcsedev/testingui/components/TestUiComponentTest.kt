package com.marcsedev.testingui.components

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

class TestUiComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            UiComponent()
        }

        //FINDER
        composeTestRule.onNodeWithText("ada lovelace", ignoreCase = true)
        composeTestRule.onNodeWithTag("component2")
        composeTestRule.onNodeWithContentDescription("profileImage")
        composeTestRule.onAllNodesWithText("a", ignoreCase = true)
        composeTestRule.onAllNodesWithTag("component2")
        composeTestRule.onAllNodesWithContentDescription("profileImage")

        //ACTIONS
        composeTestRule.onNodeWithText("ada lovelace", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("ada lovelace").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("ada lovelace").performScrollTo() //scrolling
        composeTestRule.onNodeWithText("ada lovelace")
            .performImeAction() //keyboard button action        composeTestRule.onNodeWithText("ada lovelace", ignoreCase = true)
        composeTestRule.onNodeWithText("ada lovelace").performTextClearance() //Delete TextField
        composeTestRule.onNodeWithText("ada lovelace")
            .performTextInput("add text") //Add to component
        composeTestRule.onNodeWithText("ada lovelace")
            .performTextReplacement("replace text") //Replace text
        composeTestRule.onNodeWithText("ada lovelace")
            .performScrollTo()
            .performClick()
            .performImeAction() //add multiactions

        //ASSERTIONS
        composeTestRule.onNodeWithText("ada lovelace").assertExists()
        composeTestRule.onNodeWithText("ada lovelace").assertDoesNotExist()
        composeTestRule.onNodeWithText("ada lovelace").assertContentDescriptionContains("profile")
        composeTestRule.onNodeWithText("ada lovelace").assertContentDescriptionEquals("profile")
        composeTestRule.onNodeWithText("ada lovelace").assertIsDisplayed()
        composeTestRule.onNodeWithText("ada lovelace").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("ada lovelace").assertIsEnabled()
        composeTestRule.onNodeWithText("ada lovelace").assertIsNotEnabled()
        composeTestRule.onNodeWithText("ada lovelace").assertIsSelected()
        composeTestRule.onNodeWithText("ada lovelace").assertIsNotSelected()
        composeTestRule.onNodeWithText("ada lovelace").assertIsFocused()
        composeTestRule.onNodeWithText("ada lovelace").assertIsNotFocused()
        composeTestRule.onNodeWithText("ada lovelace").assertIsOn()
        composeTestRule.onNodeWithText("ada lovelace").assertIsOff()
        composeTestRule.onNodeWithText("ada lovelace").assertTextEquals("")
        composeTestRule.onNodeWithText("ada lovelace").assertTextContains("Ada Lovelace")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsAdaLovelace() {
        composeTestRule.setContent {
            UiComponent()
        }
        composeTestRule.onNodeWithText("ada lovelace", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("test", ignoreCase = true)
    }

    @Test
    fun whenNamIsAdded_thenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            UiComponent()
        }
        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("TEST")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Your name is TEST")
    }
}