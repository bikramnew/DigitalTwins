package com.bikram.digitaltwins.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bikram.digitaltwins.model.DigitalTwin
import com.bikram.digitaltwins.ui.theme.colorPrimary

@Composable
fun DigitalTwinListItem(digitalTwin: DigitalTwin) {
    val drawableId = LocalContext.current.resources.getIdentifier(
        "img_" + digitalTwin.id,
        "drawable",
        LocalContext.current.packageName
    )

    Card(
        shape = RoundedCornerShape(40.dp),
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(width = 1.dp, colorPrimary, shape = RoundedCornerShape(40.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = null,

                modifier = Modifier
                    .size(88.dp)
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(10.dp)
            ) {
                Text(
                    text = "${digitalTwin.name} (${digitalTwin.brand})",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = digitalTwin.price!!,
                    modifier = Modifier
                        .padding(top = 5.dp),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = digitalTwin.description!!,
                    modifier = Modifier
                        .padding(top = 5.dp),
                    maxLines = 2,
                    fontStyle = FontStyle.Italic,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}