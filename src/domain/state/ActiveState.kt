package designpatterns.domain.state

import designpatterns.domain.InventoryState
import designpatterns.domain.Inventory as InventoryDomain

class ActiveState(inventory: InventoryDomain) : InventoryState(inventory) {

    /**
     * Active Inventories can transition to Blocked States
     */
    override fun canTransitionTo(newState: InventoryState): Boolean {
        return newState is BlockedState
    }

    override fun addStock(amount: Int) {
        // Mutate the domain through their methods
        inventory.addStock(amount)
    }

    fun charge() {

    }
}
