# Lab 12: Managing Configuration and Sensitive Data with ConfigMaps and Secrets

## Objective

Define and manage application configuration using ConfigMaps for non-sensitive data and Secrets for sensitive data, then verify their usage inside a Kubernetes pod.

---

## Prerequisites

* Ubuntu / Debian-based Linux system
* Kubernetes cluster (Kind / Minikube)
* kubectl installed and configured
* Existing namespace `ivolve`
* Internet connection

---

## Steps

### 1. Create ConfigMap (Non-Sensitive Data)

```yaml id="c1m4ap"
apiVersion: v1
kind: ConfigMap
metadata:
  name: mysql-config
  namespace: ivolve
data:
  DB_HOST: "mysql-service"
  DB_USER: "ivolve_user"
```

Apply ConfigMap:

```bash id="a2p9ly"
kubectl apply -f configmap.yaml
```

Verify:

```bash id="b3x7tr"
kubectl get configmap -n ivolve
kubectl describe configmap mysql-config -n ivolve
```

---

### 2. Encode Secret Values (Base64)

```bash id="d4k8qw"
echo -n "mypassword" | base64
echo -n "rootpassword" | base64
```

Example output:

```bash id="e5v2bn"
bXlwYXNzd29yZA==
cm9vdHBhc3N3b3Jk
```

---

### 3. Create Secret (Sensitive Data)

```yaml id="f6z1os"
apiVersion: v1
kind: Secret
metadata:
  name: mysql-secret
  namespace: ivolve
type: Opaque
data:
  DB_PASSWORD: bXlwYXNzd29yZA==
  MYSQL_ROOT_PASSWORD: cm9vdHBhc3N3b3Jk
```

Apply Secret:

```bash id="g7u3nc"
kubectl apply -f secret.yaml
```

Verify:

```bash id="h8y5kd"
kubectl get secret -n ivolve
kubectl describe secret mysql-secret -n ivolve
```

---

### 4. Test ConfigMap and Secret in a Pod

```bash id="i9r6pm"
kubectl run test-pod \
--image=nginx \
-n ivolve \
--env-from=configmap/mysql-config \
--env-from=secret/mysql-secret
```

Check environment variables:

```bash id="j1t4vx"
kubectl exec -it test-pod -n ivolve -- printenv
```

---

### 5. Verify Output

* Pod should contain environment variables:

  * DB_HOST
  * DB_USER
  * DB_PASSWORD
  * MYSQL_ROOT_PASSWORD

---

## Screenshots

### Commands Used

![Commands](commands.png)

### ConfigMap Created

![ConfigMap](configmap.png)

### Secret Created

![Secret](secret.png)

---

## Summary

| Step             | Command / Action        | Result                              |
| ---------------- | ----------------------- | ----------------------------------- |
| Create ConfigMap | YAML + `kubectl apply`  | Non-sensitive data stored           |
| Encode values    | `echo -n \| base64`     | Sensitive data encoded              |
| Create Secret    | YAML + `kubectl apply`  | Secure data stored                  |
| Run test pod     | `kubectl run`           | Pod created with env variables      |
| Verify env       | `kubectl exec printenv` | Config + Secret successfully loaded |

---

## Notes

* ConfigMaps store **non-sensitive configuration data**.
* Secrets store **sensitive data encoded in base64**.
* Always use `echo -n` when encoding to avoid newline issues.
* Both ConfigMaps and Secrets can be injected into pods as environment variables.
* Keep Secrets secure and avoid exposing them in logs or public repositories.
