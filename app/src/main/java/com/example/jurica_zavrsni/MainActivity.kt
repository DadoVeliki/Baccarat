package com.example.jurica_zavrsni

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.jurica_zavrsni.ui.theme.Jurica_zavrsniTheme
import java.util.*

var bankUlog=(1..1000).random()
val karte=listOf<Karte>(Karte(0,R.drawable.obrnuta),Karte(1,R.drawable.trefa),Karte(2,R.drawable.tref2),Karte(3,R.drawable.tref3),Karte(4,R.drawable.tref4),Karte(5,R.drawable.tref5),Karte(6,R.drawable.tref6),Karte(7,R.drawable.tref7),Karte(8,R.drawable.tref8),Karte(9,R.drawable.tref9),Karte(0,R.drawable.tref10),Karte(0,R.drawable.trefj),Karte(0,R.drawable.trefq),Karte(0,R.drawable.trefk),
Karte(1,R.drawable.karoa),Karte(2,R.drawable.karo2),Karte(3,R.drawable.karo3),Karte(4,R.drawable.karo4),Karte(5,R.drawable.karo5),Karte(6,R.drawable.karo6),Karte(7,R.drawable.karo7),Karte(8,R.drawable.karo8),Karte(9,R.drawable.karo9),Karte(0,R.drawable.karo10),Karte(0,R.drawable.karoj),Karte(0,R.drawable.karoq),Karte(0,R.drawable.karok),
Karte(1,R.drawable.herca),Karte(2,R.drawable.herc2),Karte(3,R.drawable.herc3),Karte(4,R.drawable.herc4),Karte(5,R.drawable.herc5),Karte(6,R.drawable.herc6),Karte(7,R.drawable.herc7),Karte(8,R.drawable.herc8),Karte(9,R.drawable.herc9),Karte(0,R.drawable.herc10),Karte(0,R.drawable.hercj),Karte(0,R.drawable.hercq),Karte(0,R.drawable.herck),
Karte(1,R.drawable.pika),Karte(2,R.drawable.pik2),Karte(3,R.drawable.pik3),Karte(4,R.drawable.pik4),Karte(5,R.drawable.pik5),Karte(6,R.drawable.pik6),Karte(7,R.drawable.pik7),Karte(8,R.drawable.pik8),Karte(9,R.drawable.pik9),Karte(0,R.drawable.pik10),Karte(0,R.drawable.pikj),Karte(0,R.drawable.pikq),Karte(0,R.drawable.pikk))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jurica_zavrsniTheme {
                glavna()
            }
        }

          Log.d("karte: ",karte.get(0).vrijednost.toString())
    }
}

@Composable
fun glavna(){
    var ulog by remember {
        mutableStateOf(1)
    }
    var rn1 by remember {
        mutableStateOf(0)
    }
    var rn2 by remember {
        mutableStateOf(0)
    }
    var rn3 by remember {
        mutableStateOf(0)
    }
    var rn4 by remember {
        mutableStateOf(0)
    }
    var rn5 by remember {
        mutableStateOf(0)
    }
    var rn6 by remember {
        mutableStateOf(0)
    }
    var oklada by remember {
        mutableStateOf("SEBE")
    }
    var izgubljeno by remember {
        mutableStateOf(0)
    }
    var dobiveno by remember {
        mutableStateOf(0)
    }
    var stanje by remember {
        mutableStateOf(1000)
    }
    var profit by remember {
        mutableStateOf(0)
    }
    var ukupniUlog by remember {
        mutableStateOf(bankUlog+ulog)
    }
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color("#35654d".toColorInt()))
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Column(
                modifier = Modifier.background(Color.White)
            ) {

                Text(text = "BANKAROV ULOG: $bankUlog €",
                    fontWeight = FontWeight.Bold

                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.width(400.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BANKAR",
                color=Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .width(100.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                obrnuta(karte.get(rn1).slika)
                obrnuta(karte.get(rn2).slika)
                var zbroj=karte.get(rn1).vrijednost+karte.get(rn2).vrijednost
                if(zbroj!=8 && zbroj!=9){
                    obrnuta(karte.get(rn3).slika)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Column(
                modifier = Modifier.width(400.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row() {
                    obrnuta(karte.get(rn4).slika)
                    obrnuta(karte.get(rn5).slika)
                    var zbroj=karte.get(rn4).vrijednost+karte.get(rn5).vrijednost
                    if(zbroj!=8 && zbroj!=9){
                        obrnuta(karte.get(rn6).slika)
                    }
                    //obrnuta(R.drawable.obrnuta)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "TI",
                    modifier = Modifier
                        .background(Color("#FFBD00".toColorInt()))
                        .width(100.dp),
                    color=Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
    }
        Spacer(modifier = Modifier.height(50.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
                ){
            Text(text = "UKUPNI ULOG: $ukupniUlog €")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.strelica), contentDescription = null)
            Text(text = "Kladiš se na: $oklada", color = Color.White)
            Image(painter = painterResource(id = R.drawable.strelica), contentDescription = null,
            modifier = Modifier.rotate(180f))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { oklada="SEBE"},
                colors = ButtonDefaults.buttonColors(contentColor = Color("#FFBD00".toColorInt()), backgroundColor = Color.Black)
                ) {
                Text(text = "TI",
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {oklada="IZJEDNAČENO" },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White)) {
                Text(text = "IZJEDNAČENO",
                    fontWeight = FontWeight.Bold)
            }
            Button(onClick = {oklada="BANKARA" },
                colors = ButtonDefaults.buttonColors(contentColor = Color.Red, backgroundColor = Color.White)) {
                Text(text = "BANKAR",
                    fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center ){
            Text(text = "ULOG:",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                ulog--
                if(ulog<1){
                    ulog=1
                }
                ukupniUlog= bankUlog+ulog
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White)) {
                Text(text = "-",
                    fontSize = 20.sp


                )
            }
            Text(text = ulog.toString()+"€",
                modifier= Modifier
                    .width(100.dp)
                    .align(Alignment.CenterVertically)
                    .background(Color.White),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp


            )
            Button(onClick = {
                  ulog++
                ukupniUlog= bankUlog+ulog
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White)) {
                Text(text = "+",
                fontSize = 20.sp

                    )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Button(onClick = {
                //stanje-=ulog
                bankUlog=(1..1000).random()
                do{
                    rn1=(1..51).random()
                    rn2=(1..51).random()
                    rn3=(1..51).random()
                    rn4=(1..51).random()
                    rn5=(1..51).random()
                    rn6=(1..51).random()
                }while(rn1==rn2 || rn1==rn3 || rn1==rn4 || rn1==rn5 || rn1==rn6 || rn2==rn3 || rn2==rn4 || rn2==rn5 || rn2==rn6 || rn3==rn4 || rn3==rn5 || rn3==rn6 || rn4==rn5 || rn4==rn6 || rn5==rn6)

                var zbroj1=karte.get(rn1).vrijednost+karte.get(rn2).vrijednost
                var zbroj2=karte.get(rn4).vrijednost+karte.get(rn5).vrijednost
                if((zbroj1!=8 && zbroj1!=9) || (zbroj2!=8 && zbroj2!=9)){
                    zbroj1+=karte.get(rn3).vrijednost
                    zbroj2+=karte.get(rn6).vrijednost
                    while(zbroj1>10){
                        zbroj1-=10
                    }
                    while(zbroj2>10){
                        zbroj2-=10
                    }
                    if(zbroj1>zbroj2){//bankar ima veći zbroj
                       when(oklada){
                           "SEBE"->{
                               stanje-=ulog
                           }
                           "IZJEDNAČENO"->{
                               stanje-=ulog
                           }
                           "BANKARA"->{
                               stanje+=ukupniUlog
                           }
                       }
                    }
                    else if(zbroj1<zbroj2){
                        when(oklada){
                            "SEBE"->{
                                stanje+=ukupniUlog
                            }
                            "IZJEDNAČENO"->{
                                stanje-=ulog
                            }
                            "BANKARA"->{
                                stanje-=ulog
                            }
                        }
                    }
                    else{
                        when(oklada){
                            "SEBE"->{
                                stanje-=ulog
                            }
                            "IZJEDNAČENO"->{
                                stanje+=ukupniUlog
                            }
                            "BANKARA"->{
                                stanje-=ulog
                            }
                        }
                    }
                }
                else{
                    while(zbroj1>10){
                        zbroj1-=10
                    }
                    while(zbroj2>10){
                        zbroj2-=10
                    }
                }

                profit=stanje-1000
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red, contentColor = Color.White),
                modifier = Modifier
                    //.align(Alignment.CenterHorizontally)
                    .width(200.dp),) {
                Text(text = "IGRAJ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = {
                  ulog=bankUlog
                ukupniUlog= bankUlog+ulog
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White),
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "BANKA",
                    fontSize = 15.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Stanje na računu: $stanje€",
            fontWeight = FontWeight.Bold)
            Text(text = "Profit: $profit €",
                fontWeight = FontWeight.Bold)
            /*Text(text = "Dobiveno: $dobiveno€",
                fontWeight = FontWeight.Bold)*/
        }
    }
}

@Composable
fun obrnuta(sl:Int){
    var obr=sl
    Image(painter = painterResource(id = obr),
        contentDescription = null,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)

    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jurica_zavrsniTheme {
    }
}