package com.ticonsys.taxcalculator.domain

import com.ticonsys.taxcalculator.data.AnnualSalary
import com.ticonsys.taxcalculator.data.Investment
import com.ticonsys.taxcalculator.data.TaxPaid
import com.ticonsys.taxcalculator.data.TaxReturn

expect class TaxCalculator {
    fun calculate(
        annualSalary: AnnualSalary,
        investment: Investment,
        taxPaid: TaxPaid
    ): TaxReturn
}