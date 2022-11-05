//*** *************** https://github.com/VivekYadavDeveloper *********************//
//*** *************** Vivek Yadav Developer *****************//

package com.example.jetpackcomposetextfield


//*** So , We Create Textfield with Snack-bar With Jetpack Compose
//*** Firstly we created a "scaffoldState" val to call snack-bar with animation.
//*** Then Created val "CoroutineScope" scope which is Use for composable function that returns a
//***  CoroutineScope bound to the point of the Composition where it's called.
//*** Now Create Text Field pass all the parameter.

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            var textfieldState by remember {
                mutableStateOf(value = "")
            }
            val scope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),

                scaffoldState = scaffoldState
            ) {

                TopAppBar(
                    modifier = Modifier
                ) {
                    Text(text = "TextField", fontSize = 20.sp)


                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = textfieldState,
                        onValueChange = { textfieldState = it },
                        label = { Text(text = "Enter Your Name Here") },

                        singleLine = true,
//                        Text(text = "Hello Circle"),
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "Hello!  $textfieldState"
                            )
                        }
                    }) {
                        Text(text = "Submit")

                    }


                }

            }
        }
    }
}

