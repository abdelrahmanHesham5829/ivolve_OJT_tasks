# Lab 11: Namespace Management and Resource Quota Enforcement

## Objective

Create a Kubernetes namespace, apply a resource quota to limit the number of pods, and verify enforcement within the namespace.

---

## Prerequisites

* Ubuntu / Debian-based Linux system
* Kubernetes cluster (Kind / Minikube)
* kubectl installed and configured
* Internet connection

---

## Steps

### 1. Create Kubernetes Cluster (Kind)

```bash
kind create cluster --name ivolve-cluster
```

Verify cluster:

```bash
kubectl get nodes
```

---

### 2. Create Namespace

```bash
kubectl create namespace ivolve
```

---

### 3. Create Resource Quota File

```yaml
apiVersion: v1
kind: ResourceQuota
metadata:
  name: pod-limit-quota
  namespace: ivolve
spec:
  hard:
    pods: "2"
```

---

### 4. Apply Resource Quota

```bash
kubectl apply -f quota.yaml
```

---

### 5. Verify Resource Quota

```bash
kubectl get resourcequota -n ivolve
```

```bash
kubectl describe resourcequota pod-limit-quota -n ivolve
```

---

### 6. Create Pods to Test Quota

```bash
kubectl run pod1 --image=nginx -n ivolve
kubectl run pod2 --image=nginx -n ivolve
kubectl run pod3 --image=nginx -n ivolve
```

---

### 7. Verify Enforcement

```bash
kubectl get pods -n ivolve
```

* Only **2 pods** should be created successfully
* The **3rd pod will fail** due to quota restriction

---

## Screenshots

### Commands Used

![Commands](Commands.png)

### Namespace Created

![Namespace](namespace.png)

### Only 2 Pods Allowed

![2Pods](2pods.png)

---

## Summary

| Step              | Command                    | Result                     |
| ----------------- | -------------------------- | -------------------------- |
| Create cluster    | `kind create cluster`      | Kubernetes cluster created |
| Create namespace  | `kubectl create namespace` | Namespace `ivolve` created |
| Create quota file | YAML configuration         | Pod limit defined          |
| Apply quota       | `kubectl apply`            | Resource quota enforced    |
| Verify quota      | `kubectl describe quota`   | Quota details displayed    |
| Create pods       | `kubectl run`              | Only 2 pods allowed        |
| Exceed quota      | Create 3rd pod             | Request denied             |

---

## Notes

* Resource quotas help control resource consumption in a namespace.
* This lab limits the number of pods to prevent overuse.
* Namespaces provide logical isolation within a cluster.
* Always ensure your Kubernetes cluster is running before applying configurations.
