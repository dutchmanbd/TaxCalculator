package com.ticonsys.taxcalculator.data

import com.ticonsys.taxcalculator.domain.Constants

data class AnnualSalary(
    val basicSalary: Double,
    val houseRentAllowance: Double,
    val medicalAllowance: Double,
    val conveyanceAllowance: Double = 0.0,
    val otherAllowance: Double = 0.0,
    val overtimeAllowance: Double = 0.0,
    val providentFund: Double = 0.0,
    val festivalBonus: Double = 0.0
)

fun AnnualSalary.netTaxableAmount(): Double {
    val houseRentTaxAmount = if (houseRentAllowance > Constants.THREE_LAKH)
        houseRentAllowance - Constants.THREE_LAKH
    else 0.0
    val medicalPercent = basicSalary * 0.1
    val medicalTaxAmount = if (medicalAllowance > medicalPercent)
        medicalAllowance - medicalPercent
    else 0.0
    val conveyanceTaxAmount = if (conveyanceAllowance > Constants.THIRTY_THOUSAND)
        conveyanceAllowance - Constants.THIRTY_THOUSAND
    else 0.0
    return basicSalary +
            houseRentTaxAmount +
            medicalTaxAmount +
            conveyanceTaxAmount +
            otherAllowance +
            overtimeAllowance +
            providentFund +
            festivalBonus
}

fun Double.taxLeviableOnTotalIncome(): Double {
    var totalIncome = this
    var taxLeviableOnTotalIncome = 0.0
    if (totalIncome >= Constants.THREE_LAKH) {
        totalIncome -= com.ticonsys.taxcalculator.domain.Constants.THREE_LAKH
    }
    if (totalIncome > 0.0) {
        if (totalIncome > Constants.ONE_LAKH) {
            taxLeviableOnTotalIncome += Constants.ONE_LAKH * 0.05
            totalIncome -= com.ticonsys.taxcalculator.domain.Constants.ONE_LAKH
        } else {
            taxLeviableOnTotalIncome += totalIncome * 0.05
            totalIncome = 0.0
        }
    }

    if (totalIncome > Constants.THREE_LAKH) {
        taxLeviableOnTotalIncome += Constants.THREE_LAKH * 0.10
        totalIncome -= com.ticonsys.taxcalculator.domain.Constants.THREE_LAKH
    } else {
        taxLeviableOnTotalIncome += totalIncome * 0.10
        totalIncome = 0.0
    }

    if (totalIncome > Constants.FOUR_LAKH) {
        taxLeviableOnTotalIncome += Constants.FOUR_LAKH * 0.15
        totalIncome -= com.ticonsys.taxcalculator.domain.Constants.FOUR_LAKH
    } else {
        taxLeviableOnTotalIncome += totalIncome * 0.15
        totalIncome = 0.0
    }
    if (totalIncome > Constants.FIVE_LAKH) {
        taxLeviableOnTotalIncome += Constants.FIVE_LAKH * 0.20
        totalIncome -= com.ticonsys.taxcalculator.domain.Constants.FIVE_LAKH
    } else {
        taxLeviableOnTotalIncome += totalIncome * 0.20
        totalIncome = 0.0
    }

    if (totalIncome > 0.0) {
        taxLeviableOnTotalIncome += totalIncome * 0.25
        totalIncome -= totalIncome
    }
    return taxLeviableOnTotalIncome
}