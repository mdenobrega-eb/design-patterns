/***
Repository Pattern:
mediates between the domain and the data mapping layers using a collection-like interface for accessing the domain objects

This is an implementation of InventoryRepository in the domain.

Methods here should receive and return domain objects.
 */

class InventoryRepositoryMySql(mysql: MysqlBase ): InventoryRepository {
    fun findById(id: String) {
        conn = Mysql.connect()

        query = "select * from a where a.id = id";

        result = Mysql.query(query)

        return Inventory(
            id = result.id,
            product = result.product,
            stock = result.stock
        )
    }

    fun save(inventory: Inventory) {

    }
}