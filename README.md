# 💰 Banking App - Spring Boot

A secure and RESTful **Banking Application** built using **Spring Boot**, designed to manage bank accounts and handle financial operations such as deposits, withdrawals, and account updates.

---

![Visitors](https://komarev.com/ghpvc/?username=Bhuvanyu02\&color=blue\&style=flat-square)
![Stars](https://img.shields.io/github/stars/Bhuvanyu02/Banking-App?style=social)
![Forks](https://img.shields.io/github/forks/Bhuvanyu02/Banking-App?style=social)
![License](https://img.shields.io/github/license/Bhuvanyu02/Banking-App)

---

## 🧹 Features

* ➕ Add a new bank account
* 🔍 Get account information by ID
* 💸 Deposit money into an account
* 🏧 Withdraw money from an account
* ✏️ Update account details
* 🗑️ Delete bank accounts
* 🧪 Uses DTOs, mappers, and a clean controller-service-repository structure

---

## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **H2 / MySQL Database**
* **MapStruct (for DTO mapping)**
* **Postman / Swagger for API testing**
* **JUnit / Mockito for testing**

---

## 🔧 Architecture

```text
Controller → Service → Mapper → DTO ↔ Entity → Repository
```

* 🔄 **DTOs**: Transfer structured data safely
* ⚙️ **Mappers**: Convert between Entity ↔ DTO
* 💼 **Repository**: Interact with the database using JPA

---

## 🚀 Getting Started

```bash
# Clone the repo
git clone https://github.com/Bhuvanyu02/Banking-App.git
cd Banking-App

# Build and run the app
./mvnw spring-boot:run
```
---

## 📬 API Endpoints

* `POST /accounts` – Create account
* `GET /accounts/{id}` – Get account info
* `PUT /accounts/{id}/deposit` – Deposit funds
* `PUT /accounts/{id}/withdraw` – Withdraw funds
* `PUT /accounts/{id}` – Update account info
* `DELETE /accounts/{id}` – Delete account

> Full API test collection available in Postman 

---

## 🚧 Future Enhancements

* [ ] Add user authentication & roles
* [ ] Enable transaction history tracking
* [ ] Add multi-currency support
* [ ] Deploy to AWS / Heroku

---

## 🤝 Contributing

Contributions, suggestions, and pull requests are welcome!

1. Fork the repo
2. Create your branch: `git checkout -b feature/my-feature`
3. Commit changes: `git commit -m 'Add feature'`
4. Push to your branch: `git push origin feature/my-feature`
5. Open a Pull Request

---

## 🔗 Contact

* GitHub: [@Bhuvanyu02](https://github.com/Bhuvanyu02)
---
