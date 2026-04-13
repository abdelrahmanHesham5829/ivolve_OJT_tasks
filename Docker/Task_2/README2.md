# 📦 Lab 2 - Building and Packaging Java Applications with Maven

## 📌 Overview
This lab demonstrates how to build, test, and package a Java application using Maven.

---

### ⚙️ Step 1: Install Maven

Install Java and Maven:


    sudo apt update
    sudo apt install -y openjdk-17-jdk maven

![Install Maven](Screenshots/Screenshot_2026-04-13_17_23_06.png)

---

## 📥 Step 2: Clone Repository

    git clone https://github.com/Ibrahim-Adel15/build2.git
    cd build2

![Clone Repo](Screenshots/Screenshot_2026-04-13_17_24_54.png)

---

## 🧪 Step 3: Run Unit Tests

    mvn test

![Tests](Screenshots/Screenshot_2026-04-13_17_26_52.png)

---

## 🏗️ Step 4: Build App

    mvn package

![Build](Screenshots/Screenshot_2026-04-13_17_27_49.png)
![Build](Screenshots/Screenshot_2026-04-13_17_28_15.png)

---

## 🚀 Step 5: Run App

    java -jar target/hello-ivolve-1.0-SNAPSHOT.jar

![Run App](Screenshots/Screenshot_2026-04-13_17_28_27.png)

---

## ✅ Result
- Maven installed successfully
- Unit tests passed
- Application built successfully
- JAR file generated in target/
- Application runs successfully 🎉
