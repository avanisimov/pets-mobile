package ru.alira.pets.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alira.pets.login.ui.vo.AnswerState
import ru.alira.pets.login.ui.vo.LoginMessageSource
import ru.alira.pets.login.ui.vo.LoginMessageVO
import ru.alira.pets.ui.theme.Color
import ru.alira.pets.ui.util.painter


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val listItems: List<LoginMessageVO> by viewModel.items.collectAsState(emptyList())
    val answerState by viewModel.answerState.collectAsState(AnswerState.Nothing)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            reverseLayout = true,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(listItems) { message ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = if (message.source == LoginMessageSource.SYSTEM) {
                                0.dp
                            } else {
                                56.dp
                            },
                            top = 4.dp,
                            end = if (message.source == LoginMessageSource.SYSTEM) {
                                56.dp
                            } else {
                                0.dp
                            },
                            bottom = 4.dp,
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .border(
                                1.dp,
                                MaterialTheme.colors.onPrimary,
                                RoundedCornerShape(4.dp, 4.dp, 4.dp, 0.dp)
                            )
                            .padding(8.dp)
                            .align(
                                if (message.source == LoginMessageSource.SYSTEM) {
                                    Alignment.CenterStart
                                } else {
                                    Alignment.CenterEnd
                                }
                            )

                    ) {
                        Text(
                            text = message.text, color = MaterialTheme.colors.onPrimary
                        )
                        message.image?.let { image ->
                            Image(
                                painter = image.painter(),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Teal700),
        ) {
            val state = answerState
            when (state) {
                AnswerState.Nothing -> {

                }
                is AnswerState.Buttons -> {
                    Row {
                        state.buttons.forEach { answerButton ->
                            Button(
                                onClick = {
                                    viewModel.onAnswer(answerButton.answerId, null)
                                }, modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                Text(answerButton.text)
                            }
                        }
                    }
                }
                is AnswerState.Password -> {
                    var password by rememberSaveable { mutableStateOf("") }

                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                            if (password.length == state.size) {
                                viewModel.onAnswer(state.answerId, password)
                            }
                        },
                        label = { Text("Enter password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                }
                is AnswerState.PhoneNumber -> {
                    Row {
                        var value by remember { mutableStateOf("+7") }
                        TextField(
                            value = value,
                            onValueChange = { newValue: String ->
                                value = newValue
                            },
                        )
                        Button(onClick = {
                            viewModel.onAnswer(state.answerId, value)
                        }, enabled = value.length == 12) {
                            Text("->")
                        }
                    }
                }
            }
        }
    }
}