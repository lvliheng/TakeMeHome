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

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.colorBorder
import com.example.androiddevchallenge.ui.theme.colorBoxBg
import com.example.androiddevchallenge.ui.theme.colorMainBg
import com.example.androiddevchallenge.ui.theme.colorTextBody1
import com.example.androiddevchallenge.ui.theme.colorTextBody2
import com.example.androiddevchallenge.ui.theme.colorTextH6
import com.example.androiddevchallenge.ui.theme.colorTextSubTitle2
import com.google.gson.Gson

@Composable
fun MainScreen(screenWidth: Int, puppies: List<Puppy>) {
    Scaffold(
        topBar = {
            MainHeader()
        },
        content = {
            PuppiesList(screenWidth = screenWidth, puppies = puppies)
        }
    )
}

@Composable
fun MainHeader() {
    TopAppBar(
        Modifier
            .fillMaxWidth()
            .height(80.dp),
        backgroundColor = colorMainBg,
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(20.dp, 10.dp, 20.dp, 0.dp)
        ) {
            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Adoptions",
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                color = colorTextH6,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "Take me home, please",
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                color = colorTextBody2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun PuppiesList(screenWidth: Int, puppies: List<Puppy>) {
    LazyColumn(
        modifier = Modifier
            .padding(0.dp),
    ) {
        // TODO: 2021/3/3  wait for gridview update
        var rowIndex = 0
        items(puppies.size / 2) { index ->
            PuppyListItem(screenWidth, index + rowIndex, puppies)
            rowIndex += 1

            if (index == (puppies.size / 2) - 1) {
                if (puppies.size % 2 != 0) {
                    rowIndex += 1
                    PuppyListItem(screenWidth, index + rowIndex, puppies)
                }
                Spacer(modifier = Modifier.padding(30.dp))
            }
        }
    }
}

@Composable
fun PuppyListItem(screenWidth: Int, index: Int, puppies: List<Puppy>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 5.dp, 20.dp, 5.dp)
    ) {
        BoxItem(screenWidth = screenWidth, index = index, puppies = puppies)
        if (index + 1 < puppies.size) {
            BoxItem(screenWidth = screenWidth, index = index + 1, puppies = puppies)
        }
    }
}

@Composable
fun BoxItem(screenWidth: Int, index: Int, puppies: List<Puppy>) {
    val painterId = when (index) {
        0 -> R.drawable.image_puppy_1
        1 -> R.drawable.image_puppy_2
        else -> R.drawable.image_puppy_3
    }

    val gender = if (puppies[index].gender == "0") "Male" else "Female"
    val genderIcon =
        if (puppies[index].gender == "0") R.drawable.icon_gender_male else R.drawable.icon_gender_female

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .width((screenWidth / 2 - 20).dp)
            .padding(10.dp, 5.dp, 10.dp, 5.dp)
            .border(1.dp, colorBorder, RoundedCornerShape(5.dp))
            .background(colorBoxBg)
            .clickable(
                onClick = {
                    intentToDetail(context = context, index = index, puppy = puppies[index])
                }
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
                .clip(RoundedCornerShape(4.dp))
        ) {
            Image(
                painter = painterResource(id = painterId),
                contentDescription = null,
                modifier = Modifier
                    .height((screenWidth / 2 - 50).dp)
                    .width((screenWidth / 2 - 50).dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = puppies[index].name,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                color = colorTextSubTitle2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = puppies[index].breed,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 1,
                color = colorTextBody1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(5.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(15.dp)
            ) {
                TextWithIcon(icon = R.drawable.icon_calender, value = "${puppies[index].age} Months")

                Spacer(modifier = Modifier.width(10.dp))

                TextWithIcon(icon = genderIcon, value = gender)
            }
        }
    }
}

@Composable
fun TextWithIcon(icon: Int, value: String) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier
            .padding(0.dp, 5.dp, 2.dp, 0.dp)
            .width(15.dp)
            .height(15.dp)
    )

    Text(
        text = value,
        style = MaterialTheme.typography.body1,
        fontSize = 14.sp,
        color = colorTextBody2
    )
}

fun intentToDetail(context: Context, index: Int, puppy: Puppy) {
    val intent = Intent().apply {
        setClass(context, DetailActivity::class.java)
        putExtra("index", index)
        putExtra("puppy", Gson().toJson(puppy))
    }
    context.startActivity(intent)
}
