class Inventory {
    val id;
    val product;
    val stock;

    val state: InventoryState;

    fun addStock(val product, val count) {
        state->addStock(product, count)
    }

    fun onClick() {
        state->onClick()
    }

    fun transitionTo(val product, val state: InventoryState) {
        if (this.state is InventoryStateActive && state is InventoryStateDraft) {
            throw Exception("You cant")
        }

        this->state = state
    }
}
