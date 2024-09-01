package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> //
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Composable function that displays the profile section.
 * @param profileImage Painter for the profile image.
 * @param name String for the name.
 * @param title String for the title.
 * @param cardBackgroundColor Color to apply to the background.
 * @param modifier Modifier to apply to the layout.
 */
@Composable
fun ProfileSection(
    profileImage: Painter,
    name: String,
    title: String,
    cardBackgroundColor : Color = Color.Black.copy(alpha = 0.5f),
    modifier: Modifier = Modifier) {

    // Column Layout to display the profile section
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(32.dp)
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
            .background(color = cardBackgroundColor, shape = RoundedCornerShape(10.dp))
            .fillMaxSize()
    ) {
        // Image Composable to display the profile image
        Image(
            painter = profileImage,
            contentDescription = stringResource(R.string.android_logo_image),
            modifier = Modifier
                .size(250.dp)
                // Border to the image  with a shape of a rounder corner
                .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
        )
        // Text Composable to display the developer name
        Text(
            text = name,
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        // Text Composable to display the title of the developer
        Text(
            text = title,
            color = Color(0xFF3CD982),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}
/**
 * Composable function that displays a row of contact information.
 * @param icon ImageVector for the icon.
 * @param contactInfo String for the contact information.
 * @param iconName String for the name of the icon.
 */
@Composable
fun ContactRowField(
    icon: ImageVector,
    contactInfo: String,
    iconName: String,
    modifier: Modifier = Modifier
    ) {
    // Row Layout to display the contact information
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 28.dp),
        // Spacing between the icon and the contact information
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Composable to display the contact icon
        Icon(
            imageVector = icon,
            contentDescription = iconName,
            tint = Color(0xFF3CD982), // Color of the icon
            modifier = Modifier
                .padding(top = 8.dp)

        )
        // Text Composable to display the contact information
        Text(
            text = contactInfo,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 8.dp)
                .weight(1F)


        )
    }
}
/**
 * Composable function that displays the contact section.
 * @param phoneNumber String for the phone number.
 * @param mailAddress String for the mail address.
 * @param githubLink String for the github link.
 * @param cardBackgroundColor Color to apply to the background.
 * @param modifier Modifier to apply to the layout.
 */
@Composable
fun ContactSection(
    phoneNumber: String,
    mailAddress: String,
    githubLink: String,
    cardBackgroundColor : Color = Color.Black.copy(alpha = 0.5f),
    modifier: Modifier = Modifier
) {
    // Column Layout to display the contact section
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(32.dp)
            .background(color = cardBackgroundColor, shape = RoundedCornerShape(10.dp))
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
            .fillMaxSize()
    ) {
        // Contact Row Field for Phone Number
        ContactRowField(
            icon = Icons.Rounded.Phone,
            contactInfo = phoneNumber,
            iconName = stringResource(R.string.phone_icon_text),
        )

        // Contact Row Field for Mail Address
        ContactRowField(
            icon = Icons.Rounded.Email,
            contactInfo = mailAddress,
            iconName = stringResource(R.string.mail_icon_text),
        )
        // Contact Row Field for Github Link
        ContactRowField(
            icon = Icons.Rounded.Person,
            contactInfo = githubLink,
            iconName = stringResource(R.string.github_icon_text),
        )
    }
}

/**
 * Composable function that displays the business card with the profile section and contact section.
 *  @param backgroundColor Color to apply to the background.
 *  @param modifier Modifier to apply to the layout.
 */
@Composable
fun BusinessCard(backgroundColor: Color = Color.DarkGray, modifier: Modifier = Modifier) {
    // Column Layout to display the business card with the profile section and contact section
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {
        // Calling Profile Section Composable to display the profile section
        ProfileSection(
            profileImage = painterResource(id = R.drawable.android_logo),
            name = stringResource(R.string.name_text),
            title = stringResource(R.string.title_text),
            modifier = Modifier.weight(1.5f)
        )
        // Calling Contact Section Composable to display the contact section
        ContactSection(
            phoneNumber = stringResource(R.string.mobile_no_text),
            mailAddress = stringResource(R.string.mail_address_text),
            githubLink = stringResource(R.string.github_link_text),
            modifier = Modifier.weight(0.75f)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}


