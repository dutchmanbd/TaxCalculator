package com.ticonsys.taxcalculator.domain

import com.ticonsys.taxcalculator.data.*

class TaxCalculator {
    fun calculate(
        annualSalary: AnnualSalary,
        investment: Investment,
        taxPaid: TaxPaid
    ): TaxReturn {
        val totalNetTaxableAmount = annualSalary.netTaxableAmount()
        val taxLiabilityAmount = totalNetTaxableAmount.taxLiability()
        val totalInvestmentAmount = investment.dps + investment.others + investment.providentFund
        val maxAllowableInvestment = totalNetTaxableAmount * 0.25
        val restInvestmentAmount = if (totalInvestmentAmount < maxAllowableInvestment)
            maxAllowableInvestment - totalInvestmentAmount
        else 0.0
        val maximumTaxRebate = maxAllowableInvestment * 0.15
        val taxRebate = if (totalInvestmentAmount < maxAllowableInvestment)
            totalInvestmentAmount * 0.15
        else maximumTaxRebate
        val totalTaxPaidAmount = taxRebate + taxPaid.fromSalary + taxPaid.fromOthers
        val restTaxAmountToPay = taxLiabilityAmount - totalTaxPaidAmount
        return TaxReturn(
            totalNetTaxableAmount = totalNetTaxableAmount,
            taxLiabilityAmount = taxLiabilityAmount,
            totalInvestmentAmount = totalInvestmentAmount,
            maxAllowableInvestment = maxAllowableInvestment,
            restInvestmentAmount = restInvestmentAmount,
            maximumTaxRebate = maximumTaxRebate,
            taxRebate = taxRebate,
            totalTaxPaidAmount = totalTaxPaidAmount,
            restTaxAmountToPay = restTaxAmountToPay,
        )
    }
}