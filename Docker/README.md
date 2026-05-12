# Docker Labs


# 🐳 Docker Hands-on Labs

## 👨‍💻 Overview

This section demonstrates practical experience with Docker including:

* Containerizing applications
* Multi-stage builds
* Environment variables management
* Volumes & bind mounts
* Docker networking
* Docker Compose (multi-service apps)

---

# 🚀 1. Run Java Spring Boot App in Container

## 📥 Clone Repository

```bash
git clone https://github.com/Ibrahim-Adel15/Docker-1.git
cd Docker-1
```

## 📝 Build Docker Image (Maven Base)

```bash
docker build -t app1 .
```

## ▶️ Run Container

```bash
docker run -d -p 8080:8080 app1
```

## 🧪 Test Application

```bash
curl http://localhost:8080
```

## 🧹 Cleanup

```bash
docker stop <container_id>
docker rm <container_id>
```

---

# 🚀 2. Java App (JAR-based Image)

## 📝 Dockerfile Steps

* Use Java 17 base image
* Copy JAR file
* Expose port 8080
* Run application

## 🏗️ Build Image

```bash
docker build -t app2 .
```

## ▶️ Run Container

```bash
docker run -d -p 8080:8080 app2
```

---

# ⚡ 3. Multi-Stage Docker Build

## 🏗️ Build Image

```bash
docker build -t app3 .
```

## 📉 Check Image Size

```bash
docker images
```

## ▶️ Run Container

```bash
docker run -d -p 8080:8080 app3
```

---

# 🔧 4. Environment Variables in Docker

## ▶️ Run Containers with Variables

### 🟢 CLI Variables

```bash
docker run -d -e APP_MODE=development -e APP_REGION=us-east app
```

### 📄 Env File

```bash
docker run -d --env-file config.env app
```

### 🧾 Dockerfile Variables

```bash
docker run -d app
```

---

# 📦 5. Docker Volumes & Bind Mount (Nginx)

## 📁 Create Volume

```bash
docker volume create nginx_logs
```

## ▶️ Run Nginx with Volume + Bind Mount

```bash
docker run -d \
-v nginx_logs:/var/log/nginx \
-v $(pwd)/nginx-bind/html:/usr/share/nginx/html \
-p 80:80 nginx
```

## 🌐 Test

```bash
curl http://localhost
```

## 📊 Check Logs

```bash
docker volume inspect nginx_logs
```

---

# 🌐 6. Docker Networking (Microservices)

## 🌐 Create Network

```bash
docker network create ivolve-network
```

## ▶️ Run Backend

```bash
docker run -d --name backend --network ivolve-network backend-image
```

## ▶️ Run Frontend (Same Network)

```bash
docker run -d --name frontend1 --network ivolve-network frontend-image
```

## ▶️ Run Frontend (Default Network)

```bash
docker run -d --name frontend2 frontend-image
```

## 🔍 Test Communication

```bash
docker exec -it frontend1 ping backend
```

## 🧹 Remove Network

```bash
docker network rm ivolve-network
```

---

# 🧩 7. Docker Compose (Node.js + MySQL)

## 📥 Clone Repo

```bash
git clone https://github.com/Ibrahim-Adel15/kubernets-app.git
cd kubernets-app
```

## 📝 Start Services

```bash
docker-compose up -d
```

## 📊 Check Running Containers

```bash
docker ps
```

## ❤️ Health Check

```bash
curl http://localhost:3000/health
curl http://localhost:3000/ready
```

## 📜 View Logs

```bash
docker logs <container_id>
```

## 🧹 Stop Stack

```bash
docker-compose down
```

---

# 🧠 Skills Demonstrated

✔ Docker image creation & optimization
✔ Multi-stage builds for lightweight images
✔ Environment variable management
✔ Persistent storage (Volumes & Bind mounts)
✔ Microservices networking
✔ Multi-container orchestration (Docker Compose)
✔ Production-style container deployment

---

# 🎯 Summary

This Docker portfolio demonstrates **real-world containerization skills used in DevOps environments**, focusing on scalability, modular architecture, and production-ready deployments.
