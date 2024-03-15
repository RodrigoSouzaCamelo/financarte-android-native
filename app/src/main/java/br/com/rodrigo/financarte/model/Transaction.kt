package br.com.rodrigo.financarte.model

data class Transaction(
    val id: Int = 0,
    val transactionType: String,
    val description: String?,
    val amount: Double,
    val transactionDate: String,
    val category: String?,
    val paymentMethod: String?
)