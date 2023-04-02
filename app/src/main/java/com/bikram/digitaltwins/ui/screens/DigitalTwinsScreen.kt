package com.bikram.digitaltwins.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bikram.digitaltwins.helpers.DataStoreManager
import com.bikram.digitaltwins.model.MainViewModel
import com.bikram.digitaltwins.model.MainViewModelFactory
import com.bikram.digitaltwins.ui.components.DigitalTwinListItem
import com.bikram.digitaltwins.ui.theme.colorPrimary
import com.bikram.digitaltwins.helpers.SwipeActions
import com.bikram.digitaltwins.helpers.SwipeActionsConfig
import com.bikram.digitaltwins.helpers.animatedItemsIndexed
import com.bikram.digitaltwins.helpers.updateAnimatedItemsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DigitalTwinsScreen(
    acceptedTwins: String,
    rejectedTwins: String,
    isSwipeable: Boolean = true,
    showAccepted: Boolean = false
) {
    val viewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(DataStoreManager(LocalContext.current)))
    val digitalTwinsList = viewModel.digitalTwinsState

    val animatedList by updateAnimatedItemsState(newList = digitalTwinsList.map { it })

    // show placeholder for accepted twins if none present
    if (showAccepted && acceptedTwins.equals(""))
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize())
        {
            Text(
                text = "No accepted items found",
                textAlign = TextAlign.Center,
                color = colorPrimary
            )
        }
    else {
        LazyColumn {
            animatedItemsIndexed(
                state = animatedList,
                key = { email ->
                    email.id!!
                }
            ) { index, digitalTwin ->
                SwipeActions(
                    startActionsConfig = SwipeActionsConfig(
                        threshold = 0.3f,
                        background = Color(0xFF1B5E20),
                        iconTint = Color.White,
                        icon = Icons.Default.Check,
                        stayDismissed = true,
                        onDismiss = {
                            //persist to data store on swipe right (accept)
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.saveAcceptedToDataStore(
                                    digitalTwin.id!!
                                )
                            }
                        }
                    ),
                    endActionsConfig = SwipeActionsConfig(
                        threshold = 0.3f,
                        background = Color(0xffFF4444),
                        iconTint = Color.Black,
                        icon = Icons.Default.Delete,
                        stayDismissed = true,
                        onDismiss = {
                            //persist to data store on swipe left (reject)
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.saveRejectedToDataStore(
                                    digitalTwin.id!!
                                )
                            }
                        }
                    ),
                    isSwipeable = isSwipeable,
                    showTutorial = index == 0
                ) { state ->
                    val animateCorners by remember {
                        derivedStateOf {
                            state.offset.value.absoluteValue > 30
                        }
                    }
                    val startCorners by animateDpAsState(
                        targetValue = when {
                            state.dismissDirection == DismissDirection.StartToEnd &&
                                    animateCorners -> 8.dp
                            else -> 0.dp
                        }
                    )
                    val endCorners by animateDpAsState(
                        targetValue = when {
                            state.dismissDirection == DismissDirection.EndToStart &&
                                    animateCorners -> 8.dp
                            else -> 0.dp
                        }
                    )
                    val elevation by animateDpAsState(
                        targetValue = when {
                            animateCorners -> 6.dp
                            else -> 2.dp
                        }
                    )
                    Card(
                        shape = RoundedCornerShape(
                            topStart = startCorners,
                            bottomStart = startCorners,
                            topEnd = endCorners,
                            bottomEnd = endCorners,
                        ),
                        elevation = elevation,
                    ) {
                        if (showAccepted && acceptedTwins.contains(digitalTwin.id!!)) {
                            DigitalTwinListItem(digitalTwin)
                        } else if (!showAccepted && !acceptedTwins.contains(digitalTwin.id!!)
                            && !rejectedTwins.contains(digitalTwin.id!!)
                        ) {
                            DigitalTwinListItem(digitalTwin)
                        }
                    }
                }
            }
        }
    }
}