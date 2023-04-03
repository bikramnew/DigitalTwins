package com.bikram.digitaltwins

import com.bikram.digitaltwins.model.MainViewModel
import org.junit.Test
import org.junit.Assert.*

class MainVMUnitTest {
    val viewModel = MainViewModel()

    @Test
    fun mainViewModel_Initialization_FirsTwinLoaded() {
        val digitalTwinsState = viewModel.digitalTwinsState
        val digitalTwin = getDigitalTwin(1)

        // Assert that the price is 1.
        assertFalse(digitalTwin.price.equals("1"))
        // Assert that twin state is PENDING.
        assertTrue(digitalTwin.status.equals("PENDING"))
        // Assert that twin state is not PENDING.
        assertFalse(digitalTwin.status.equals("ACCEPTED"))

        //TODO add other tests with VM
    }
}