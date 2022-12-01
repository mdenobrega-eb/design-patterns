class InventoryStateDraft: InventoryState {
    fun addStock(product, count) {
        throw Exception("You cant do this")
    }

    fun onClick(sum) {
        product->click(sum)
    }

    fun thirdFunction() {
        print(product)
    }
}