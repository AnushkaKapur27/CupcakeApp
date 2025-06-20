package com.example.cupcake.test

import android.icu.util.Calendar
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.cupcake.CupcakeApp
import com.example.cupcake.CupcakeScreen
import com.example.cupcake.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Locale

class CupcakeScreenNavigationTest {
    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController : TestNavHostController

    @Before
    fun setupCupcakeNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }

    @Test
    fun cupcakeNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }
    @Test
    fun cupcakeNavHost_verifyBackNavigationNotShownOnStartOrderScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }
    @Test
    fun cupcakeNavHost_clickOneCupcake_navigatesToSelectFlavorScreen(){
        composeTestRule.onNodeWithStringId(R.string.one_cupcake)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Flavor.name)
    }
    private fun navigateToFlavorScreen() {
        composeTestRule.onNodeWithStringId(R.string.one_cupcake)
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.red_velvet)
            .performClick()
    }
    private fun navigateToPickupScreen(){
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.next)
            .performClick()
    }
    private fun getFormattedDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(java.util.Calendar.DATE, 1)
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        return formatter.format(calendar.time)
    }
    private fun navigateToSummaryScreen(){
        navigateToPickupScreen()
        composeTestRule.onNodeWithText(getFormattedDate())
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.next)
            .performClick()
    }
    private fun navigateUp(){
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }
    @Test
    fun navigateToStart_clickingUp_fromFlavour(){
        navigateToFlavorScreen()
        navigateUp()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }
    @Test
    fun navigateToStart_clickingCancel_FromFlavour(){
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }
    @Test
    fun navigateToPickup_fromStart(){
        navigateToPickupScreen()
        navController.assertCurrentRouteName(CupcakeScreen.Pickup.name)
    }
    @Test
    fun navigateToFlavor_clickingUp_fromPickup(){
        navigateToPickupScreen()
        navController.assertCurrentRouteName(CupcakeScreen.Flavor.name)
    }
    @Test
    fun navigateToStart_clickingCancel_fromPickup(){
        navigateToPickupScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }
    @Test
    fun navigatingToSummary_fromStart(){
        navigateToSummaryScreen()
        navController.assertCurrentRouteName(CupcakeScreen.Summary.name)
    }
    @Test
    fun navigateToStart_clickingCancel_fromSummary(){
        navigateToSummaryScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }
}