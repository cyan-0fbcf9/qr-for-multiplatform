# QR for Multiplatform

## What's this?

QRコードに関するツールのマルチプロジェクト.

## 製品

### QR Screenshot

ディスプレイ上のQRコードをスクリーンショットするだけで読み取ることができるアプリ.  
[ダウンロードはこちらから](https://20210419t155442-dot-qr-screenshot.uc.r.appspot.com/)

### QRコードAPI

簡単にQRコードを作成できるWebAPI.  
[使い方はこちらから]()

## プロジェクト構成

このプロジェクトでは, 以下の通りにモジュールを分けており, それぞれ違う役割を担っている.

* common
* compose ([README](compose/README.md))
* nativeCommon
* server ([README](server/README.md))

### common

**compose**モジュールと**server**モジュールから利用される共通のロジックを提供.

### compose

[Jetpack Compose for Desktop](https://www.jetbrains.com/ja-jp/lp/compose/) によるデスクトップ用のQRコードツール.

### nativeCommon

**compose**モジュールに対して, プラットフォーム特有の処理を提供.

### server

[Ktor](https://ktor.io/) によるサーバーサイドアプリケーション.

## 動作環境

JDK16+  
Gradle7.0rc+
