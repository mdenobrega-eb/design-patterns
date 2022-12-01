import domain.Inventory

class IncreaseInventoryForApples {
    companion object {
        fun operator invoke() {
            val productBannana = ProductRepository->findBy("2")
            val inventory = Inventory()

            inventory->addStock(productBannana, 1)
        }
    }
}
