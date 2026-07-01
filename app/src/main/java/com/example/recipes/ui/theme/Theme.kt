package com.example.recipes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightCoffeeScheme = lightColorScheme(
    primary = Espresso,
    onPrimary = CreamSurface,
    primaryContainer = Foam,
    onPrimaryContainer = EspressoDeep,
    secondary = Latte,
    onSecondary = CreamSurface,
    secondaryContainer = FoamDeep,
    onSecondaryContainer = EspressoDeep,
    tertiary = Mocha,
    onTertiary = CreamSurface,
    background = Cream,
    onBackground = CoffeeText,
    surface = CreamSurface,
    onSurface = CoffeeText,
    surfaceVariant = FoamDeep,
    onSurfaceVariant = CoffeeMuted,
    outline = CoffeeOutline,
    error = Terracotta,
    onError = CreamSurface
)

private val DarkCoffeeScheme = darkColorScheme(
    primary = FoamLight,
    onPrimary = EspressoDeep,
    primaryContainer = Espresso,
    onPrimaryContainer = Foam,
    secondary = CaramelLight,
    onSecondary = EspressoDeep,
    secondaryContainer = EspressoVariant,
    onSecondaryContainer = CreamOnDark,
    tertiary = Caramel,
    onTertiary = EspressoDeep,
    background = EspressoBg,
    onBackground = CreamOnDark,
    surface = EspressoSurface,
    onSurface = CreamOnDark,
    surfaceVariant = EspressoVariant,
    onSurfaceVariant = CoffeeOutline,
    outline = Mocha,
    error = Caramel,
    onError = EspressoDeep
)

@Composable
fun MyRecipesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkCoffeeScheme else LightCoffeeScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
