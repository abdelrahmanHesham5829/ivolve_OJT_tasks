# Lab 10: Node Isolation Using Taints in Kubernetes

## Objective

Set up a Kubernetes cluster with 2 nodes and apply node taints to control pod scheduling, then verify the taints using node descriptions and events.

---

## Prerequisites

* Ubuntu / Debian-based Linux system
* Kubernetes cluster (Kind / Minikube)
* kubectl installed and configured
* 2-node cluster setup
* Internet connection

---

## Steps

### 1. Create Kubernetes Cluster with 2 Nodes

```bash id="c1a11"
kind create cluster --name taint-lab --config - <<EOF
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
nodes:
  - role: control-plane
  - role: worker
EOF
```

Verify nodes:

```bash id="c2b22"
kubectl get nodes
```

---

### 2. Apply Taint to Worker Node

```bash id="c3c33"
kubectl taint nodes <node-name> node=worker:NoSchedule
```

Example:

```bash id="c4d44"
kubectl taint nodes ivolve-cluster-worker node=worker:NoSchedule
```

---

### 3. Verify Node Taints

```bash id="c5e55"
kubectl describe node ivolve-cluster-worker
```

---

### 4. Check Cluster Nodes Status

```bash id="c6f66"
kubectl get nodes -o wide
```

---

### 5. Check Events (Scheduling Verification)

```bash id="c7g77"
kubectl get events -A --sort-by=.metadata.creationTimestamp
```

---

## Screenshots

### Commands Used

![Commands](Commands.png)

---

### Node List

![Nodes](nodes.png)

---

### Describe Node (Taints Verification)

![Describe](describe.png)

---

### Events (Scheduling Behavior)

![Events](events.png)

---

## Summary

| Step           | Command / Action        | Result                         |
| -------------- | ----------------------- | ------------------------------ |
| Create cluster | Kind 2-node setup       | Control-plane + worker created |
| Apply taint    | `kubectl taint nodes`   | Worker node restricted         |
| Verify nodes   | `kubectl get nodes`     | Nodes listed                   |
| Describe node  | `kubectl describe node` | Taint confirmed                |
| Check events   | `kubectl get events`    | Scheduling behavior visible    |

---

## Notes

* Taints prevent pods from being scheduled unless they tolerate the taint.
* `NoSchedule` means Kubernetes will **not place pods** on that node.
* Control-plane node is usually not used for workloads.
* Use `kubectl describe node` to verify applied taints.
* Events help debug scheduling issues in real-time.
