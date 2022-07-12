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
画面遷移の制御とRepoを呼び出しことを担当する。

### Service
User の呼び出し、そしてもし、User がない場合は User(admin)をdatabaseに作成することを担当する。

### Repo
CRUD処理を担当する。

### Security
Login するときUserを確認することと Logout したら　ホームページの画面を遷移することを担当する。

## Getting Start

アプリを始める前にまずMySQL Databaseに'intern_db'の名前でdatabase作成してください。

<img width="700" height="200" alt="database作成" src="https://user-images.githubusercontent.com/100908505/178402989-f0e31ceb-8f66-4bd4-ad3f-581dbcea7795.png">

**起動成功時のイメージ**

<img width="700" src="https://user-images.githubusercontent.com/100908505/178414780-35d7d6b7-4388-4c9a-8466-7b08fe5e99c1.png">

http://localhost:8080/ をアクセスすると検索画面が表示される

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

終了です。

 



