package com.ticonsys.taxcalculator.data

data class TaxReturn(
    val totalNetTaxableAmount: Double = 0.0,
    val totalInvestmentAmount: Double = 0.0,
    val taxLiabilityAmount: Double = 0.0,
    val maxAllowableInvestment: Double = 0.0,
    val restInvestmentAmount: Double = 0.0,
    val maximumTaxRebate: Double = 0.0,
    val taxRebate: Double = 0.0,
    val totalTaxPaidAmount: Double = 0.0,
    val restTaxAmountToPay: Double = 0.0,
)
