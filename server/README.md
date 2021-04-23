# server

## 概要

**QR for Multiplatform**のサーバーサイドモジュール.

**server**モジュールでは以下の役割を担っている.

* **QR Screenshot**のダウンロードページ
* QRコードを生成するWebAPI（WebAPIに関する使い方は[こちら](https://github.com/cyan-0fbcf9/qr-for-multiplatform/blob/feature/%231_readme/server/README.md#webapi%E3%83%AA%E3%83%95%E3%82%A1%E3%83%AC%E3%83%B3%E3%82%B9))

## フレームワーク

* [Ktor](https://ktor.io/)
* [Vue](https://jp.vuejs.org/index.html)

## プロジェクト構成

サーバーサイドの動作は**Ktor**だが, Webページの作成には [Vue](https://jp.vuejs.org/index.html) を利用している.  
`web` ディレクトリがそのVueプロジェクトであり, **Ktor**と連携されている.

## WebAPIリファレンス

近日更新
