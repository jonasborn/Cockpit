package de.jonasborn.cockpit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.jonasborn.cockpit.ui.theme.CockpitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CockpitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Rounded.Home,
        ),
        BottomNavItem(
            name = "Create",
            route = "add",
            icon = Icons.Rounded.AddCircle,
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = Icons.Rounded.Settings,
        ),
    )

    Scaffold(
        bottomBar = {
            androidx.compose.material3.NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                bottomNavItems.forEach {
                    NavigationBarItem(
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = it.icon,
                                modifier = Modifier.size(24.dp),
                                contentDescription = "Hallo",
                                tint = Color.White
                            )
                        },
                        label = {
                            Text(
                                text = it.name,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        },
                        onClick = { /*TODO*/ }

                    )

                }
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            Text(text = "Hallo")
        }
    }
}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun GreetingPreview() {
    Surface {
        CockpitTheme {
            Greeting("Android")
        }
    }
}