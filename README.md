Domain-Driven Development
=========================

### Project Structure

```bash
$ tree -L 4
.
├── src
│   ├── Main.kt
│   ├── application
│   │   └── EnableInventory.kt
│   ├── domain
│   │   ├── Inventory.kt
│   │   ├── InventoryException.kt
│   │   ├── InventoryRepository.kt
│   │   ├── InventoryState.kt
│   │   └── state
│   │       ├── ActiveState.kt
│   │       ├── BlockedState.kt
│   │       └── DraftState.kt
│   └── infrastructure
│       ├── logging
│       ├── monitorng
│       ├── payments
│       │   ├── PayPal
│       │   └── Stripe
│       └── persistence
│           ├── InMemory
│           ├── MySQL
│           ├── PostgreSQL
│           └── SQLite
└── tests
```

# Lesson 1
- [Domain](https://martinfowler.com/eaaCatalog/domainModel.html): `src/domain/`.
- Business rules in a domain
- [State Machine Design Pattern](https://refactoring.guru/design-patterns/state): `src/domain/state/`.
- [Use Cases](https://martinfowler.com/bliki/UseCase.html): `src/application/`.

# Lesson 2
- Repository Pattern: mediates between the domain and the data mapping layers using a collection-like interface for accessing the domain objects
- Interfaces in domain (InventoryRepository)
- Implement interfaces in Infrastructure. Our example contains:
  - a MySQL implementation meant to be used in prod
  - Sqlite implementation meant to be used in testing.
  - InMemory implementation meant to be used in testing (alternative).
- Proposed directory structure to use infrastructure.
- How Use Cases interact with Domain and Infrastructure. This layer is the glue between Domain and Infrastructure.
