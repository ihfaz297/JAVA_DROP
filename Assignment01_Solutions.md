# Assignment 01 — Pattern Solutions

Every program reads its input (`n`, or `rows cols`) using `Scanner`.
Copy only the `// Problem X.Y:` line and the code below it.

> Run (Java 24): `java --enable-preview --source 24 File.java`
> Run (Java 25+): `java File.java`

---

## 1. Star Patterns

```java
// Problem 1.1:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.2:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.3:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.4:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.5:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.6:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.7:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.8:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.9:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.10:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.11:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.12:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * k - 1; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.13:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * k - 1; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.14:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        for (int j = 1; j <= 2 * (n - i); j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.15:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        for (int j = 1; j <= 2 * (n - i); j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.16:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        for (int j = 1; j <= 2 * (n - k); j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.17:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n; i++) {
        int k = (i <= n) ? n - i + 1 : i - n;
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        for (int j = 1; j <= 2 * (n - k); j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++)
            System.out.print("*");
        System.out.println();
    }
}
```

```java
// Problem 1.18:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || i == n || j == 1 || j == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.19:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            if (j == 1 || j == i || i == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.20:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++) {
            if (j == 1 || j == i || i == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.21:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= i; j++) {
            if (j == 1 || j == i || i == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.22:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++) {
            if (j == 1 || j == i || i == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.23:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            if (j == 1 || j == 2 * i - 1 || i == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.24:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            if (j == 1 || j == 2 * i - 1 || i == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.25:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++) {
            if (j == 1 || j == k)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.26:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= k; j++) {
            if (j == 1 || j == k)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.27:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= k; j++) {
            if (j == 1 || j == k || k == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.28:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++) {
            if (j == 1 || j == k || k == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.29:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * k - 1; j++) {
            if (j == 1 || j == 2 * k - 1)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 1.30:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * k - 1; j++) {
            if (j == 1 || j == 2 * k - 1 || k == n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

## 2. Number Patterns

```java
// Problem 2.1:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
            System.out.print(i);
        System.out.println();
    }
}
```

```java
// Problem 2.2:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n; j++)
            System.out.print(i);
        System.out.println();
    }
}
```

```java
// Problem 2.3:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.4:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = n; j >= 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.5:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if ((i + j) % 2 == 0)
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
        System.out.println();
    }
}
```

```java
// Problem 2.6:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || i == n || j == 1 || j == n)
                System.out.print(1);
            else
                System.out.print(0);
        }
        System.out.println();
    }
}
```

```java
// Problem 2.7:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= n; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.8:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i - 1; j++)
            System.out.print(" ");
        for (int j = n; j >= 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.9:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i - 1; j++)
            System.out.print(" ");
        System.out.print(i);
        System.out.print(i);
        System.out.println();
    }
}
```

```java
// Problem 2.10:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            System.out.print(j);
            System.out.print(j);
        }
        System.out.println();
    }
}
```

```java
// Problem 2.11:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.12:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = n; j >= n - i + 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.13:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.14:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = n; j >= n - i + 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.15:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = i; j >= 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.16:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print(j);
        for (int j = i - 1; j >= 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.17:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = n; j >= n - i + 1; j--)
            System.out.print(j);
        for (int j = n - i + 2; j <= n; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.18:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print(k + " ");
            k += 2;
        }
        System.out.println();
    }
}
```

```java
// Problem 2.19:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 2;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print(k + " ");
            k += 2;
        }
        System.out.println();
    }
}
```

```java
// Problem 2.20:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= i; j++)
            System.out.print(j);
        for (int j = i - 1; j >= 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.21:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = n; j >= n - i + 1; j--)
            System.out.print(j);
        for (int j = n - i + 2; j <= n; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.22:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 1; j <= k; j++)
            System.out.print(j);
        for (int j = k - 1; j >= 1; j--)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.23:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = n; j >= n - k + 1; j--)
            System.out.print(j);
        for (int j = n - k + 2; j <= n; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.24:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= 2 * n - 1; j++) {
            int d = Math.abs(n - j) + 1;
            if (d > n - i)
                System.out.print(d);
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 2.25:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= 2 * n - 1; j++) {
            int d = Math.abs(n - j) + 1;
            if (d > n - i)
                System.out.print(d);
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 2.26:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i % 2 == 1)
                System.out.print(n - j + 1);
            else
                System.out.print(j);
        }
        System.out.println();
    }
}
```

```java
// Problem 2.27:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (j % 2 == 1)
                System.out.print(i);
            else
                System.out.print(n - i + 1);
        }
        System.out.println();
    }
}
```

```java
// Problem 2.28:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
            System.out.print("" + i + j + " ");
        System.out.println();
    }
}
```

```java
// Problem 2.29:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 11;
    for (int i = 0; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            System.out.print(k + " ");
            k++;
        }
        System.out.println();
    }
}
```

```java
// Problem 2.30:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++)
            System.out.print(j);
        System.out.println();
    }
}
```

```java
// Problem 2.31:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++)
            System.out.print("" + i + j + " ");
        System.out.println();
    }
}
```

```java
// Problem 2.32:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++)
            System.out.print((i + j) % 9 + 1);
        System.out.println();
    }
}
```

```java
// Problem 2.33:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || i == n || j == 1 || j == n)
                System.out.print(j);
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 2.34:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = n - 2;
    for (int i = -m; i <= m; i++) {
        for (int j = -m; j <= m; j++)
            System.out.print(Math.max(Math.abs(i), Math.abs(j)) + 2);
        System.out.println();
    }
}
```

```java
// Problem 2.35:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n + i - 1; j++) {
            if (i == n)
                System.out.print(Math.abs(n - j) + 1);
            else if (Math.abs(n - j) == i - 1)
                System.out.print(i);
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 2.36:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n + k - 1; j++) {
            if (Math.abs(n - j) == k - 1)
                System.out.print(k);
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 2.37:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (j == i || j == n - i + 1)
                System.out.print(i);
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

---

## 3. Letter Patterns

```java
// Problem 3.1:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print((char) ('A' + i));
        System.out.println();
    }
}
```

```java
// Problem 3.2:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++)
            System.out.print((char) ('A' + i));
        System.out.println();
    }
}
```

```java
// Problem 3.3:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.4:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j >= 0; j--)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.5:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i % 2 == 0)
                System.out.print((char) ('A' + j));
            else
                System.out.print((char) ('A' + n - 1 - j));
        }
        System.out.println();
    }
}
```

```java
// Problem 3.6:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j % 2 == 0)
                System.out.print((char) ('A' + i));
            else
                System.out.print((char) ('A' + n - 1 - i));
        }
        System.out.println();
    }
}
```

```java
// Problem 3.7:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print((char) ('Z' - j));
        System.out.println();
    }
}
```

```java
// Problem 3.8:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i % 2 == 0)
                System.out.print((char) ('A' + j));
            else
                System.out.print((char) ('Z' - j));
        }
        System.out.println();
    }
}
```

```java
// Problem 3.9:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print("" + (char) ('A' + i) + (char) ('A' + j) + " ");
        System.out.println();
    }
}
```

```java
// Problem 3.10:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print("" + (char) ('A' + j) + (char) ('Z' - j) + " ");
        System.out.println();
    }
}
```

```java
// Problem 3.11:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print("" + (char) ('A' + i) + (char) ('Z' - i) + " ");
        System.out.println();
    }
}
```

```java
// Problem 3.12:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - 1 - i; j++)
            System.out.print(" ");
        for (int j = 0; j < n; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.13:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++)
            System.out.print(" ");
        for (int j = n - 1; j >= 0; j--)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.14:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.15:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.16:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 0; j < i; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.17:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 0; j < i; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.18:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 0; j < i; j++)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.19:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = i - 1; j >= 0; j--)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.20:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 0; j < i; j++)
            System.out.print((char) ('A' + j));
        for (int j = i - 2; j >= 0; j--)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.21:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 0; j < i; j++)
            System.out.print((char) ('A' + j));
        for (int j = i - 2; j >= 0; j--)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.22:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = n - Math.abs(n - i);
        for (int j = 1; j <= n - k; j++)
            System.out.print(" ");
        for (int j = 0; j < k; j++)
            System.out.print((char) ('A' + j));
        for (int j = k - 2; j >= 0; j--)
            System.out.print((char) ('A' + j));
        System.out.println();
    }
}
```

```java
// Problem 3.23:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = n - 2;
    for (int i = -m; i <= m; i++) {
        for (int j = -m; j <= m; j++)
            System.out.print((char) ('A' + Math.max(Math.abs(i), Math.abs(j))));
        System.out.println();
    }
}
```

```java
// Problem 3.24:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int k = 0;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            System.out.print((char) ('A' + k % 26));
            k++;
        }
        System.out.println();
    }
}
```

```java
// Problem 3.25:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int k = 0;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            System.out.print((char) ('Z' - k % 26));
            k++;
        }
        System.out.println();
    }
}
```

```java
// Problem 3.26:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            int k;
            if (i % 2 == 0)
                k = i * c + j;
            else
                k = i * c + (c - 1 - j);
            System.out.print((char) ('A' + k % 26) + " ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.27:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= 2 * n - 1; j++) {
            int d = n - Math.abs(n - j);
            if (d <= i)
                System.out.print((char) ('A' + d - 1));
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.28:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= 2 * n - 1; j++) {
            int d = n - Math.abs(n - j);
            if (d <= i)
                System.out.print((char) ('A' + d - 1));
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.29:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= 2 * n - 1; j++) {
            int d = n - Math.abs(n - j);
            if (d <= k)
                System.out.print((char) ('A' + d - 1));
            else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.30:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || i == n || j == 1 || j == n) {
                System.out.print((char) ('A' + k));
                k++;
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.31:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || i == n || j == 1 || j == n) {
                System.out.print((char) ('Z' - k));
                k++;
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.32:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            if (j == 1 || j == 2 * i - 1 || i == n) {
                System.out.print((char) ('A' + k));
                k++;
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.33:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 0;
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            if (j == 1 || j == 2 * i - 1 || i == n) {
                System.out.print((char) ('A' + k));
                k++;
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.34:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 0;
    for (int i = 1; i <= 2 * n - 1; i++) {
        int w = n - Math.abs(n - i);
        for (int j = 1; j <= n - w; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * w - 1; j++) {
            if (j == 1 || j == 2 * w - 1) {
                System.out.print((char) ('A' + k));
                k++;
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.35:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = 0;
    for (int i = 1; i <= 2 * n - 1; i++) {
        int w = n - Math.abs(n - i);
        for (int j = 1; j <= n - w; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * w - 1; j++) {
            if (j == 1 || j == 2 * w - 1) {
                System.out.print((char) ('Z' - k));
                k++;
            } else
                System.out.print(" ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.36:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if ((i + j) % 2 == 0)
                System.out.print("A ");
            else
                System.out.print("B ");
        }
        System.out.println();
    }
}
```

```java
// Problem 3.37:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int k = 0;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            System.out.print((char) ('A' + k % 26));
            k++;
        }
        System.out.println();
    }
}
```

```java
// Problem 3.38:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == i || j == n - 1 - i)
                System.out.print((char) ('A' + j) + " ");
            else
                System.out.print("  ");
        }
        System.out.println();
    }
}
```

---

## 4. Mixed Patterns

```java
// Problem 4.1:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i % 2 == 0)
                System.out.print((char) ('A' + j));
            else
                System.out.print(j + 1);
        }
        System.out.println();
    }
}
```

```java
// Problem 4.2:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i % 2 == 0)
                System.out.print((char) ('A' + j));
            else if (i % 4 == 1)
                System.out.print("#");
            else
                System.out.print("$");
        }
        System.out.println();
    }
}
```

```java
// Problem 4.3:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == i)
                System.out.print(i + 1);
            else
                System.out.print("@");
        }
        System.out.println();
    }
}
```

```java
// Problem 4.4:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == i)
                System.out.print((char) ('A' + i));
            else
                System.out.print(".");
        }
        System.out.println();
    }
}
```

```java
// Problem 4.5:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print((j + 1) + "" + (char) ('A' + j) + " ");
        System.out.println();
    }
}
```

```java
// Problem 4.6:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print((n - j) + "" + (char) ('A' + j) + " ");
        System.out.println();
    }
}
```

```java
// Problem 4.7:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            System.out.print("" + (char) ('A' + j) + (i + j + 1) + " ");
        System.out.println();
    }
}
```

```java
// Problem 4.8:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == i)
                System.out.print(i + 1);
            else
                System.out.print((char) ('A' + j));
        }
        System.out.println();
    }
}
```

```java
// Problem 4.9:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == n - 1 - i)
                System.out.print(i + 1);
            else
                System.out.print((char) ('A' + j));
        }
        System.out.println();
    }
}
```

```java
// Problem 4.10:
void main() {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int k = 1;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c / 2; j++) {
            System.out.print((char) ('A' + k - 1) + " " + k + " ");
            k++;
        }
        System.out.println();
    }
}
```

```java
// Problem 4.11:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j < i)
                System.out.print(n - j);
            else
                System.out.print((char) ('A' + n - 1 - j));
        }
        System.out.println();
    }
}
```

```java
// Problem 4.12:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++)
            System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            if (j == 1 || j == 2 * i - 1)
                System.out.print((char) ('A' + i - 1));
            else
                System.out.print(n - i + 1 + Math.abs(i - j));
        }
        System.out.println();
    }
}
```

```java
// Problem 4.13:
void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= 2 * n - 1; i++) {
        int k = Math.abs(n - i) + 1;
        for (int j = 1; j <= 2 * n - 1; j++) {
            int d = n - Math.abs(n - j);
            if (d <= k)
                System.out.print((char) ('A' + d - 1));
            else
                System.out.print(n - d + 1);
        }
        System.out.println();
    }
}
```
