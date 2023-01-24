package designpatterns.domain.state

import designpatterns.domain.InventoryState
import designpatterns.domain.Inventory as InventoryDomain

class BlockedState(inventory: InventoryDomain) : InventoryState(inventory) {

    /**
     * Do not allow transitions when our Inventory is in Blocked state
     */
    override fun canTransitionTo(newState: InventoryState): Boolean = false

    override fun addStock(amount: Int) {
        // Throw a domain exception
    }
}
