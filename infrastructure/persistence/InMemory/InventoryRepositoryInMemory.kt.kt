class InventoryRepositoryInMemory.kt(inmemory: InMemoryBase ): InventoryRepository {
    fun findById(id: String) {
        conn = inmemory.connect()

        query = "select * from a where a.id = id";

        result = inmemory.query(query)

        return Inventory(
            id = result.id,
            product = result.product,
            stock = result.stock
        )
    }

    fun save(inventory: Inventory) {

    }
}