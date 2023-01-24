package designpatterns.domain

import designpatterns.domain.Inventory as InventoryDomain

abstract class InventoryState(open val inventory: InventoryDomain) {
    abstract fun canTransitionTo(newState: InventoryState): Boolean
    abstract fun addStock(amount: Int)
}
