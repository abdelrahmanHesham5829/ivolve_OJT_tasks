# Lab 13: Persistent Storage Setup for Application Logging

## Objective

Create and manage persistent storage using a Persistent Volume (PV) and Persistent Volume Claim (PVC) to enable application log persistence in Kubernetes.

---

## Prerequisites

* Ubuntu / Debian-based Linux system
* Kubernetes cluster (Kind / Minikube)
* kubectl installed and configured
* Existing namespace `ivolve`
* Internet connection

---

## Steps

### 1. Create Persistent Volume (PV)

```yaml id="pv1a11"
apiVersion: v1
kind: PersistentVolume
metadata:
  name: app-logs-pv
spec:
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteMany
  persistentVolumeReclaimPolicy: Retain
  hostPath:
    path: /mnt/app-logs
```

Apply PV:

```bash id="pv2b22"
kubectl apply -f pv.yaml
```

---

### 2. Create Persistent Volume Claim (PVC)

```yaml id="pvc1c33"
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: app-logs-pvc
  namespace: ivolve
spec:
  accessModes:
    - ReadWriteMany
  resources:
    requests:
      storage: 1Gi
  storageClassName: ""
```

Apply PVC:

```bash id="pvc2d44"
kubectl apply -f pvc.yaml
```

---

### 3. Check Persistent Volume Status

```bash id="cmd1e55"
kubectl get pv
```

---

### 4. Check Persistent Volume Claim Status

```bash id="cmd2f66"
kubectl get pvc -n ivolve
```

---

### 5. Check PV ↔ PVC Binding Status

```bash id="cmd3g77"
kubectl describe pv app-logs-pv
kubectl describe pvc app-logs-pvc -n ivolve
```

---

### 6. Fix Pod Quota Issue (if needed)

If you see:

> exceeded quota: pod-limit-quota

Run:

```bash id="fix1h88"
kubectl delete pods --all -n ivolve
```

---

### 7. Create Test Pod Using PVC

```yaml id="pod1i99"
apiVersion: v1
kind: Pod
metadata:
  name: log-test-pod
  namespace: ivolve
spec:
  containers:
  - name: nginx
    image: nginx
    volumeMounts:
    - mountPath: /var/log/nginx
      name: log-storage
  volumes:
  - name: log-storage
    persistentVolumeClaim:
      claimName: app-logs-pvc
```

Apply:

```bash id="pod2j00"
kubectl apply -f test-pv.yaml
```

---

## Screenshots

### Commands Used

![Commands](commands.png)

---

### Persistent Volume (PV)

![PV](PV.png)

---

### Persistent Volume Claim (PVC)

![PVC](PVC.png)

---

### PV ↔ PVC Bound Status

![Bound](Bound.png)

---

## Summary

| Step         | Command / Action       | Result                     |
| ------------ | ---------------------- | -------------------------- |
| Create PV    | YAML + `kubectl apply` | Storage created (hostPath) |
| Create PVC   | YAML + `kubectl apply` | Storage request created    |
| Check PV     | `kubectl get pv`       | PV available               |
| Check PVC    | `kubectl get pvc`      | PVC created                |
| Bind storage | Automatic matching     | PV ↔ PVC Bound             |
| Create pod   | Uses PVC               | Storage mounted            |

---

## Notes

* PV is the actual storage resource on the node.
* PVC is the request for storage by applications.
* Binding happens when PV and PVC match in size and access mode.
* `storageClassName: ""` ensures static binding.
* Always verify **Bound status** before using storage.
