package br.com.rodrigo.financarte.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

object Currency {
    fun formatCurrency(value: Float): String {
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
        val decimalFormat = (currencyFormat as? DecimalFormat)

        decimalFormat?.apply {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance().apply {
                decimalSeparator = ','
                groupingSeparator = '.'
            }
        }

        return currencyFormat.format(value)
    }
}