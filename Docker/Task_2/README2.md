# Lab 2: Building and Packaging Java Applications with Maven

## Objective
Build, test, and package a Java application using Maven on Kali Linux.

---

## Prerequisites
- Kali Linux  
- Java 17 installed  
- Maven installed  
- Git  
- VS Code (recommended)

---

## Step-by-Step Instructions

### 1. Install Maven and Java
~~~sh
sudo apt update
sudo apt install -y openjdk-17-jdk maven
~~~

![Install Maven](./Screenshots/Screenshot_2026-04-13_17_23_06.png)

---

### 2. Clone Repository
~~~sh
git clone https://github.com/Ibrahim-Adel15/build2.git
cd build2
~~~

![Clone Repository](./Screenshots/Screenshot_2026-04-13_17_24_54.png)

---

### 3. Run Unit Tests
~~~sh
mvn test
~~~

![Tests](./Screenshots/Screenshot_2026-04-13_17_26_52.png)

---

### 4. Build Application
~~~sh
mvn package
~~~

![Build 1](./Screenshots/Screenshot_2026-04-13_17_27_49.png)
![Build 2](./Screenshots/Screenshot_2026-04-13_17_28_15.png)

---

### 5. Run Application
~~~sh
java -jar target/hello-ivolve-1.0-SNAPSHOT.jar
~~~

![Run App](./Screenshots/Screenshot_2026-04-13_17_28_27.png)

---

## Commands Summary

| Step | Command | Description |
|------|--------|------------|
| 1 | sudo apt install openjdk-17-jdk maven | Install dependencies |
| 2 | git clone ... | Clone repository |
| 3 | mvn test | Run unit tests |
| 4 | mvn package | Build JAR |
| 5 | java -jar target/...jar | Run application |

---

## ✅ Lab Completed Successfully

- Maven installed successfully  
- Repository cloned  
- Tests passed successfully  
- Application built successfully  
- JAR generated in `target/`  
- Application runs successfully  

📁 Screenshots are in the `Screenshots/` folder.
