import domain.Inventory

class IncreaseInventoryForApples.kt {
    companion object {
        fun operator invoke() {
            val productApple = ProductRepository->findBy("1")
            val inventory = Inventory()

            inventory->addStock(productApple, 1)
        }
    }
}
