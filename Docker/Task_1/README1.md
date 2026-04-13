# Lab 1 - Building and Packaging Java Applications with Gradle

## 📌 Overview
This lab demonstrates how to build, test, and package a Java application using Gradle.

---

## ⚙️ Step 1: Install Gradle
Install Java and Gradle:

    sudo apt update
    sudo apt install -y openjdk-17-jdk gradle

![Install Gradle](Screenshots/Screenshot_2026-04-13_14_35_50.png)

---

## 📥 Step 2: Clone Repository

    git clone https://github.com/Ibrahim-Adel15/build1.git
    cd build1

![Clone Repo](Screenshots/Screenshot_2026-04-13_15_55_06.png)

---

## 🧪 Step 3: Run Tests

    gradle test

![Tests](Screenshots/Screenshot_2026-04-13_15_55_06.png)

---

## 🏗️ Step 4: Build App

    gradle build

![Build](Screenshots/Screenshot_2026-04-13_15_56_10.png)

---

## 🚀 Step 5: Run App

    java -jar build/libs/ivolve-app.jar

![Run App](Screenshots/Screenshot_2026-04-13_15_56_57.png)

---

## ✅ Result
- Tests pass
- Build succeeds
- App runs successfully
