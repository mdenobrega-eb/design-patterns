class EnableInventory {
    companion object {
        fun operator invoke() {
            val inventory = Inventory()

            // We want to activate this inventory
            val state = InventoryStateActive()

            // We call the method that allows transitions
            inventory->transitionTo(state)

            // Now we can add stock in the current state
            inventory->addStock()
        }
    }
}
