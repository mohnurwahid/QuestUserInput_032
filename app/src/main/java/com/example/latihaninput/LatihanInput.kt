package com.example.latihaninput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTlpn by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihjk by remember { mutableStateOf("") }

    val listJK = listOf("Laki-laki", "Perempuan")

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var noTlpnsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }

    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier .padding(20.dp))
        TextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama")},
            placeholder = { Text("Masukan nama")}
        )

        Row {
            listJK.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = memilihjk == item,
                        onClick = {
                            memilihjk = item
                        }
                    )
                    Text(item)
                }
            }
        }

        TextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")},
            placeholder = { Text("Masukan Email Anda")}
        )
        TextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = noTlpn,
            onValueChange = {noTlpn = it},
            label = { Text("NoHandphone")},
            placeholder = { Text("Masukan No Handphone")}
        )
        TextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukan Alamat Anda")}
        )

        Button (onClick = {
            namasv = nama
            emailsv = email
            noTlpnsv = noTlpn
            alamatsv = alamat
            jk = memilihjk
        }) {
            Text("Simpan")
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = modifier
                .fillMaxWidth(),

            ) {
            DetailMessage(judul = "Nama", isinya = namasv)
            DetailMessage(judul = "Email", isinya = emailsv)
            DetailMessage(judul = "NoHp", isinya = noTlpnsv)
            DetailMessage(judul = "Alamat", isinya = alamatsv)
            DetailMessage(judul = "Jenis Kelamin", isinya = jk)
        }

    }
}

@Composable
fun DetailMessage(
    judul: String, isinya: String
){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isinya,
            modifier = Modifier.weight(2f))
    }
}