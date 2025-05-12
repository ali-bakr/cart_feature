# cart_feature

- **MVVM Pattern**
- **Single Activity, Multi-Module, Feature-based Structure**
- **SOLID Principles + Clean Code Practices**
- **UseCases** for each business logic operation

---

## 🧩 Modules

- `app` – Main application host
- `core_ui` – Contains shared base classes (BaseFragment, Adapter, ViewHolder) and general utilities (e.g., message dialogs)
- `navigationrouter` – Centralized route handling between features
- `shopping_feature` – Previously `cart_feature`, contains:
  - Product listing & filtering
  - Cart management (add, delete, mark as bought)

---

## 🔧 Tech Stack

| Tech           | Purpose                             |
|----------------|-------------------------------------|
| Kotlin         | Primary language                    |
| Hilt           | Dependency Injection                |
| Room           | Local persistence                   |
| Retrofit       | API client (mocked data for now)    |
| Jetpack        | ViewModel, LiveData, Navigation, etc|
| Coroutines     | Async operations                    |
| RecyclerView   | Lists and custom item views         |
| TOML           | Centralized dependency management   |

---

## 🧪 Testing & Quality

- JUnit for Unit Testing
- Espresso for UI Testing (planned)
- Follows Clean Architecture & SOLID
- Reusable base classes and shared components

---

## 🚧 Tasks

- [x] Base architecture and modules setup
- [x] Product list and cart management
- [x] Sorting, filtering, search logic
- [x] Shared dialog & base UI
- [ ] Integrate real APIs via Retrofit
- [ ] UI enhancements and polish
- [ ] Full test coverage

---

## 🚀 Getting Started

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/shopping-app.git
