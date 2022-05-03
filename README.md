# Αλγόριθμος για την εύρεση της κορυφογραμμής (Skyline)
Αλγόριθμος για την εύρεση της κορυφογραμμής (skyline) σε σύνολα σημείων δύο διαστάσεων στο Ευκλείδειο επίπεδο.

[![built with java](https://img.shields.io/badge/Built%20with-Java-orange?style=for-the-badge&logo=appveyor)](https://www.java.com/en/)
[![built in intellij ide](https://img.shields.io/badge/Built%20in-Intellij%20IDE-lightgrey?style=for-the-badge&logo=appveyor)](https://www.jetbrains.com/)

> Η λύση του αλγορίθμου είναι Θ(nLogn) σε πολυπλοκότητα.

## Πώς να τρέξετε τον αλγόριθμο
Αρχικά θα πρέπει να γίνει build μέσω terminal αφού βεβαιωθούμε πως βρισκόμαστε στον ίδιο φάκελο με το αρχείο `Skyline.java`.

Με τις παρακάτω εντολές θα κάνουμε build και θα τρέξουμε με βάση τα αρχεία [`test{x}.txt`](https://github.com/ochotzas/skyline/blob/main/src/) που έχουμε και θα δούμε τις εξόδους.
```
javac Skyline.java
java Skyline test1.java
java Skyline test2.java
java Skyline test3.java
java Skyline test4.java
```
## Αποτελέσματα

### Πρώτο ([`test1.txt`](https://github.com/ochotzas/skyline/blob/main/src/test1.txt))
Είσοδος:
```
10
9 2
8 5
6 4
7 3
5 5
6 6
4 7
4 8
3 8
2 9
```
![image](https://user-images.githubusercontent.com/74056187/166476681-ca4ba352-d965-4535-b258-c41b1e1a4c80.png)

Έξοδος:
```
2 9
3 8
4 7
5 5
6 4
7 3
9 2
```

### Δεύτερο ([`test12.txt`](https://github.com/ochotzas/skyline/blob/main/src/test2.txt))
Είσοδος:
```
10
1 4
5 8
6 2
7 3
2 9
3 3
4 2
5 5
8 3
7 7
```
![image](https://user-images.githubusercontent.com/74056187/166473036-fd557d77-7c9e-4af6-b25a-a8298325590c.png)

Έξοδος:
```
1 4
3 3
4 2
```

### Τρίτο ([`test3.txt`](https://github.com/ochotzas/skyline/blob/main/src/test3.txt))
Είσοδος:
```
10
2 5
4 3
3 6
7 5
4 4
1 2
2 3
6 6
8 9
9 8
```
![image](https://user-images.githubusercontent.com/74056187/166477178-78a7c79a-4cc4-4732-9922-2cb0801c03d7.png)

Έξοδος:
```
1 2
```

### Τέταρτο ([`test4.txt`](https://github.com/ochotzas/skyline/blob/main/src/test4.txt))
Είσοδος:
```
20
1 12
1 12
2 7
4 22
5 14
6 5
8 19
9 9
10 4
12 13
15 15
15 22
16 6
17 10
17 20
21 3
22 14
1 20
22 3
22 22
```

Έξοδος:
```
1 12
2 7
6 5
10 4
21 3
```
<hr/>

Αναπτύχθηκε με ❤️ από τον Ολγκέρ Χότζα @ AUTh ως εργασία στο μάθημα των Αλγορίθμων.
