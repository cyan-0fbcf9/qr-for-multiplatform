# server

## 概要

**QR for Multiplatform**のサーバーサイドモジュール.

**server**モジュールでは以下の役割を担っている.

* **QR Screenshot**のダウンロードページ
* QRコードを生成するWebAPI（WebAPIに関する使い方は[こちら]())

## フレームワーク

* [Ktor](https://ktor.io/)
* [Vue](https://jp.vuejs.org/index.html)

## プロジェクト構成

サーバーサイドの動作は**Ktor**だが, Webページの作成には [Vue](https://jp.vuejs.org/index.html) を利用している.  
`web` ディレクトリがそのVueプロジェクトであり, **Ktor**と連携されている.
