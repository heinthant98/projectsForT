# 概要
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
User の呼び出しともし、User がいない場合は User(admin)をdatabaseに作成することを担当する。

### Repo
CRUD処理を担当する。

### Security
Login するときUserを確認することと Logout したら　ホームページの画面を遷移することを担当する。

## Getting Start

アプリを始める前にまずMySQL Databaseに'intern_db'の名前でdatabase作成してください。

<img width="700" height="200" alt="database作成" src="https://user-images.githubusercontent.com/100908505/178402989-f0e31ceb-8f66-4bd4-ad3f-581dbcea7795.png">

そして、Thymeleafを使ったので　IDE を使っていない場合は Java 11 変更する必要があります。

起動成功時のイメージ

<img width="700" height="300"　alt="Home_Page" src="https://user-images.githubusercontent.com/100908505/178414780-35d7d6b7-4388-4c9a-8466-7b08fe5e99c1.png">
http://localhost:8080/ をアクセスすると検索画面が表示される



