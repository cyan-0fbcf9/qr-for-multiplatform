<template>
  <div class="download-page">
    <div class="title">
      ダウンロード
    </div>
    <div class="download-content-wrapper">
      <div class="download-content">
        <div class="logo">
          <img src="@/assets/logo.png" alt="logo" width="256" />
        </div>
        <div class="download-content-title">
          QR Screenshot
        </div>
        <div class="download-content-description">
          ディスプレイに表示されているQRコードを読み取れるQRスキャナ
        </div>
        <div class="download-link-wrapper">
          <div class="link-for-macos download-link">
            <div class="platform-target">macOS</div>
            <a href="#" target="_blank">
              <span class="material-icons">file_download</span>
              <span class="package-name">dmg</span>
            </a>
          </div>
          <div class="link-for-windows download-link">
            <div class="platform-target">Windows</div>
            <a href="#" target="_blank">
              <span class="material-icons">file_download</span>
              <span class="package-name">msi</span>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Download'
};
</script>

<style scoped lang="scss">
.download-page {
  background-color: $background-color;
  font-size: 1.2rem;
  height: 100vh;
  width: 100vw;
}

.title {
  color: $font-color;
  font-size: 3.5em;
  padding: 16px 0;
}

.download-content {
  .download-content-title {
    color: $primary-color;
    font-size: 3em;
    font-weight: bold;
  }
  .download-content-description {
    margin: 8px 0;
  }
  .download-link-wrapper {
    display: grid;
    justify-items: center;
    margin: 16px 0;

    .download-link {
      align-items: center;
      display: grid;
      grid-template-columns: 1fr 1fr;
      margin: 16px 0;

      .platform-target {
        margin: 0 12px;
      }

      a {
        align-items: center;
        border-radius: 8px;
        color: white;
        background-color: $primary-color;
        display: flex;
        justify-content: center;
        padding: 8px;
        text-decoration: none;
        width: 150px;

        .package-name {
          padding: 0 8px;
        }
      }
    }
  }
}
</style>
