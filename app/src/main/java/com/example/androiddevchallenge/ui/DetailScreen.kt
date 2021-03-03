/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.colorBoxBg
import com.example.androiddevchallenge.ui.theme.colorButtonBg
import com.example.androiddevchallenge.ui.theme.colorButtonText
import com.example.androiddevchallenge.ui.theme.colorMainBg
import com.example.androiddevchallenge.ui.theme.colorTextBody1
import com.example.androiddevchallenge.ui.theme.colorTextBody2
import com.example.androiddevchallenge.ui.theme.colorTextH6

@Composable
fun DetailScreen(index: Int, puppy: Puppy) {
    Scaffold(
        topBar = {
            DetailHeader()
        },
        content = {
            Detail(index = index, puppy = puppy)
        },
        bottomBar = {
            DetailFooter()
        }
    )
}

@Composable
fun DetailHeader() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = colorMainBg,
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
        ) {
            Spacer(modifier = Modifier.padding(10.dp))

            IconButton(
                onClick = {
                    Log.i("Detail", "Back")
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_back),
                    contentDescription = null,
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                )
            }
        }
    }
}

@Composable
fun Detail(index: Int, puppy: Puppy) {
    val painterId = when (index) {
        0 -> R.drawable.image_puppy_1
        1 -> R.drawable.image_puppy_2
        else -> R.drawable.image_puppy_3
    }

    val gender = if (puppy.gender == "0") "Male" else "Female"

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(0.dp)
    ) {
        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h6,
            maxLines = 1,
            color = colorTextH6,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 0.dp)
        )

        Text(
            text = puppy.breed,
            style = MaterialTheme.typography.body1,
            maxLines = 1,
            color = colorTextBody1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
        )

        Row {
            val boxModifier = Modifier
                .width(0.dp)
                .wrapContentHeight()
                .weight(1f)
                .padding(20.dp, 20.dp, 20.dp, 10.dp)
                .background(colorBoxBg, RoundedCornerShape(5.dp))

            BoxContent(modifier = boxModifier, title = "AGE", value = "${puppy.age} Months")
            BoxContent(modifier = boxModifier, title = "GENDER", value = gender)
            BoxContent(modifier = boxModifier, title = "WEIGHT", value = "${puppy.weight} Kg")
        }

        Text(
            text = puppy.description,
            style = MaterialTheme.typography.body2,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            color = colorTextBody2,
            lineHeight = 20.sp,
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 10.dp)
        )

        Image(
            painter = painterResource(id = painterId),
            contentDescription = null,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 20.dp, 20.dp)
                .clip(RoundedCornerShape(5.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(60.dp))
    }
}

@Composable
fun BoxContent(modifier: Modifier, title: String, value: String) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body2,
                color = colorTextBody2,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = value,
                style = MaterialTheme.typography.body1,
                color = colorTextBody1,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DetailFooter() {
    Surface(
        elevation = 0.dp,
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Transparent),

        ) {
            Button(
                onClick = {
                    Log.i("Detail", "Adopt Now!")
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorButtonBg),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Text(
                    text = "Adopt Now!",
                    color = colorButtonText
                )
            }
        }
    }
}
