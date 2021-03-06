# QR for Multiplatform

## What's this?

QRコードに関するツールのマルチプロジェクト.

## 製品

### QR Screenshot

ディスプレイ上のQRコードをスクリーンショットするだけで読み取ることができるアプリ.  
[ダウンロードはこちらから](https://qr-screenshot.uc.r.appspot.com/)

### QRコードAPI

簡単にQRコードを作成できるWebAPI.  
[使い方はこちらから](https://github.com/cyan-0fbcf9/qr-for-multiplatform/blob/feature/%231_readme/server/README.md#webapi%E3%83%AA%E3%83%95%E3%82%A1%E3%83%AC%E3%83%B3%E3%82%B9)

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
