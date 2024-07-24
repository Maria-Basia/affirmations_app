/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsApp()
        }
    }
}

@Preview
@Composable
fun AffirmationsApp() {
    val datasource = Datasource()
    val affirmationsArray = datasource.loadAffirmations()
    
    Column {
        for (item in affirmationsArray) {
            AffirmationCard(
                affirmation = item,
                modifier = Modifier
                )
        }
    }


}




@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Any = Modifier
        .fillMaxSize()
) {
    Card {
        Image(painter = painterResource(id = affirmation.imageResourceID), contentDescription = "" )
        Text(text = stringResource(id = affirmation.stringResourceID))
    }
}
