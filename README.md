Here’s a polished and well-structured version of your GitHub README that will make your project presentation more professional and visually appealing:

---

# 📚 KJC-SDC-TASKS

> 👨‍🎓 Kristu Jayanti College - Software Development Cell
> 📅 **Day 2 & Day 3 Tasks**
> 🧑‍💻 Reg No: `<YourRegNo>`
> 🗂️ Java, Maven, MongoDB

---

## 📦 Day 2 Tasks (Evening)

### ✅ 1. Maven Project Setup

**Project Title:** `Day2<YourRegNo>`
Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- SLF4J with Log4j -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.7.36</version>
    </dependency>

    <!-- Apache Commons CLI -->
    <dependency>
        <groupId>commons-cli</groupId>
        <artifactId>commons-cli</artifactId>
        <version>1.5.0</version>
    </dependency>
</dependencies>
```

---

### 📖 2. Library Management System (Inheritance)

**Structure:**

```bash
src/
├── model/
│   ├── Book.java
│   ├── FictionBook.java
│   └── NonFictionBook.java
```

**Features:**

* Base class: `Book`
* Subclasses: `FictionBook`, `NonFictionBook`
* Demonstrates **inheritance** and **polymorphism**

---

### 🏦 3. Basic Banking System (Exception Handling)

**Operations Implemented:**

* ✅ Create account
* ✅ Deposit money
* ✅ Withdraw money
* ✅ Check balance

**Custom Exceptions:**

* `OverdraftException`
* `NegativeTransactionException`
* `AccountNotFoundException`

**Handled with try-catch blocks for robust error management.**

---

## 💾 Day 3 Tasks (Afternoon) — MongoDB Integration

### 🧩 Project: Student Enrollment System

**Collections:**

* `students` — Student details
* `courses` — Course details
* `enrollments` — Enrollment records

---

### 📋 Document Structure

#### 🔗 Referenced Document

```json
{
  "_id": ObjectId("..."),
  "student_id": ObjectId("..."),
  "course_id": ObjectId("...")
}
```

#### 📎 Embedded Document

```json
{
  "_id": ObjectId("..."),
  "student": { "name": "John", "regNo": "21KJC1234" },
  "course": { "name": "Java", "code": "CS101" }
}
```

---

### 🔨 Tasks Done

* ✅ Inserted sample students and courses
* ✅ Added enrollments using both embedded and referenced formats
* ✅ Queried and printed both types of enrollments
* ✅ Updated student name:

  * **Embedded:** Needs to update all enrollments manually
  * **Referenced:** Automatically reflects updated name
* ✅ Created indexes for `students` collection

---

## 📂 Folder Structure

```bash
Day2<RegNo>/
├── src/
│   └── ... (Library & Banking system)
├── pom.xml

Day3-Task/
├── src/
│   └── ... (MongoDB Java Integration)
├── README.md
├── screenshots/
│   ├── insert.png
│   ├── query.png
│   ├── update.png
│   └── index.png
```

---

## 🖼️ Screenshots

| Insert                      | Query                      | Update                      | Index                      |
| --------------------------- | -------------------------- | --------------------------- | -------------------------- |
| ![Screenshot 2025-06-18 170325](https://github.com/user-attachments/assets/81de26f1-bbac-40cf-895d-4377933e9191) |![Screenshot 2025-06-18 170449](https://github.com/user-attachments/assets/839bc3bf-a56b-46b9-8804-04ebab4e9f76) | ![Screenshot 2025-06-18 170517](https://github.com/user-attachments/assets/86493275-3421-41f4-a865-3c03da07a6c7) | ![](screenshots/index.png) |

---

## 📝 How to Run

### 💻 Day 2

```bash
mvn clean install
java -cp target/Day2<RegNo>.jar com.day2.Main
```

### 🌐 Day 3

Ensure MongoDB is running and Java MongoDB driver is configured.

```bash
java -cp target/Day3-Task.jar com.day3.Main
```

---

## 🔗 GitHub Repo Links

* **Day 2 Tasks:** [Day2<RegNo>](#)
* **Day 3 Tasks:** [Day3-Task](#)

---

Let me know if you'd like this as a downloadable `README.md` file or want help generating the actual screenshots/images.





