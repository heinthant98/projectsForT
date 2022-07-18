# Applicationについて

## 概要
このプロジェクトはInternshipの登録するサイトのレポジトリです。

## 前提
- Java 11
- Spring boot 2.7.1
- ThymeLeaf view
- Spring Security
- MySQL

## 名レイヤの責務
### Controller
画面遷移の制御とServiceを呼び出すことを担当する。

### Service
業務処理の提供を担当する。

### Repo
CRUD処理を担当する。

### Security
Login するときUserを確認することと Logout したら　ホームページの画面を遷移することを担当する。

## Getting Start

Dockerを使ってMySQLを構築しましょう。

## Dockerの準備
Dockerをinstallする。
確認方法はターミナルから下記を実行する。
```bash
$ docker -v
Docker version 20.10.17, build 100c701
```

## 手順

まずは、レポジトリをcloneします。
cloneしたらディレクトリ内に移動します。
docker-compose.ymlがあることを確認する。

```bash
$ ls
conf/  docker-compose.yml  Dockerfile  LICENSE  mvnw*  mvnw.cmd  pom.xml  README.md  sql/  src/
```

コンテナを起動する。
ただし初回は時間がかかります。
出力内容も下記より多いです。
```bash
$ docker compose up -d
[+] Running 2/2
 - Network projectsForT_default  Created                                                                      0.9s
 - Container Mysql_Intern_db        Started                                                                      1.9s
```

コンテナを確認する。
"Mysql_Intern_db"があればOKです。
```bash
$ docker ps
CONTAINER ID   IMAGE                COMMAND                  CREATED          STATUS          PORTS                               NAMES
7e583596bcaf   projectsForT_db   "docker-entrypoint.s…"   47 seconds ago   Up 45 seconds   33060/tcp, 0.0.0.0:3307->3306/tcp   Mysql_Intern_db
```

MYSQLにLoginします。パスワードはdocker-compose.ymlに記載されているとおり"admin"です。
```bash
$ docker compose exec db mysql -u user -p
Enter password:
```

もし、パスワードを入力したあと動作しないこともあります。Window環境の方は下記のコメントを入力して試してください。
```bash
$ winpty docker compose exec db mysql -u user -p
Enter password:
```

以下のように表示されるとDatabaseを使いましょう。
```bash
$ docker compose exec db mysql -u user -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 8.0.29 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>
```

"show databases;"　コメントを入力して、intern_dbがあることを確認する。
```bash
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| intern_db          |
+--------------------+
2 rows in set (0.01 sec)
```

"intern_db"の利用を開始する。
```bash
mysql> use intern_db;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
```

"account"テーブルがあることを確認する。
```bash
mysql> show tables;
+---------------------+
| Tables_in_intern_db |
+---------------------+
| account             |
+---------------------+
1 row in set (0.01 sec)

```

以下のコメントを使って"account"テーブルのレコードを確認する。
```bash
mysql> select * from account;
+----+-----------------+-------+------+--------------------------------------------------------------+
| id | email           | name  | role | password                                                     |
+----+-----------------+-------+------+--------------------------------------------------------------+
|  1 | admin@gmail.com | admin |    0 | $2a$10$V2P4daPnPXxBsYNGNpBwmu.A91IXrzyJUUsU8E21Iz5foXhVlN3Sq |
+----+-----------------+-------+------+--------------------------------------------------------------+
1 row in set (0.00 sec)
```

アプリを始める前にまずMySQL Databaseに'intern_db'の名前でdatabase作成してください。

<img width="700" height="200" alt="database作成" src="https://user-images.githubusercontent.com/100908505/178402989-f0e31ceb-8f66-4bd4-ad3f-581dbcea7795.png">

**起動成功時のイメージ**

<img width="700" src="https://user-images.githubusercontent.com/100908505/178414780-35d7d6b7-4388-4c9a-8466-7b08fe5e99c1.png">

http://localhost:8080/homepage をアクセスすると検索画面が表示される

**検索画面**

<img src="https://user-images.githubusercontent.com/100908505/178428233-8588acfd-db7d-4e21-a6e7-668ab5d94e6b.png">

**Sign-Up画面**

<img src="https://user-images.githubusercontent.com/100908505/178420502-5e8e6d12-9e4e-4051-b13f-508c42f7b832.png">

- "Name", "Email", "Password"　を入力して登録する。(エラーについては何も準備していませんのでこの３つを全部入力してください。Emailを入力するときにも "@gmail.com"を付けてください。）
  - 登録した方たちは　Student になります。
- 全部入力した後、Sign-up　をクリックしたら、Studentのホームページが表示される。

**Home-Page(Student)**

<img src="https://user-images.githubusercontent.com/100908505/178423842-d5fc646d-2fa7-4c88-981c-261036dba6c7.png">

- Apply は完成していませんのでクリックしても何も表示されません。
- Sign-outをクリックしたら、ホームページが表示される。

**Sign-In画面**

<img src="https://user-images.githubusercontent.com/100908505/178420697-4f64906c-559f-44e2-9d2a-fac52b556b28.png">

- "Email", "Password"　を入力して Sign-Inする。
- Sign-in するときは登録した方だけSign inできます。
    - もし、登録していない場合、それともadminとして使いたい場合は作成したusername="admin@gmail.com"とpassword="admin"を使いできます。
    - "admin@gmail.com"　以外はStudentとしてStudentのホームページが表示される。
- "admin@gmail.com"　を使って　Sign-In をクリックしたら、Adminのホームページが表示される。

**Home-page(Admin)**

<img src="https://user-images.githubusercontent.com/100908505/178426213-1df25f3b-4a3f-46b1-8b92-66cef2fb63e8.png">

- Application, Confirmation, Setting は完成していませんのでクリックしても何も表示されません。
- Sign-outをクリックしたら、ホームページが表示される。

**Sign-Out画面(ホームページ)**

<img src="https://user-images.githubusercontent.com/100908505/178428233-8588acfd-db7d-4e21-a6e7-668ab5d94e6b.png">

ログアウトする。
```bash
mysql> exit
Bye
```

起動したDockerコンテナを停止する。
```bash
$ docker compose down
[+] Running 2/2
 - Container Mysql_Intern_db        Removed                                                                      1.7s
 - Network projectsForT_default  Removed                                                                      0.8s
```

停止できていることを確認する。
```bash
$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

```

終了です。

 



