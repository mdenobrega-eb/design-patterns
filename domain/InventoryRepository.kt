/***
Repository Pattern:
mediates between the domain and the data mapping layers using a collection-like interface for accessing the domain objects

 This is a contract in the domain.
 Contracts in domain are implemented in infrastructure.
*/
interface InventoryRepository {
    fun findById(id: String);

    fun save(inventory: Inventory);
}
