package designpatterns.domain

interface PaymentMethod {
    fun charge(amount: Double)
}