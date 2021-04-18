<template>
  <div id="app">
    <!--    <div id="nav">-->
    <!--      <router-link to="/">Home</router-link>-->
    <!--      <router-link to="/about">About</router-link>-->
    <!--      <router-link to="/download">Download</router-link>-->
    <!--    </div>-->
    <router-view />
  </div>
</template>

<script>
export default {
  head: {
    link: [
      {
        rel: 'stylesheet',
        href: 'https://fonts.googleapis.com/icon?family=Material+Icons'
      }
    ]
  }
};
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css?family=Noto+Sans+JP:300&display=swap');

* {
  margin: 0;
  padding: 0;
}

#app {
  font-family: 'Noto Sans JP', Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: $font-color;
}

#nav {
  background-color: $gray-color;
}

#nav a {
  color: $font-color;
  display: inline-block;
  font-size: 1.2em;
  font-weight: bold;
  padding: 12px 18px;
  text-decoration: none;
  transition: 0.5s;

  &:hover {
    background-color: $background-color;
  }
}

#nav a.router-link-exact-active {
  background-color: $background-color;
}
</style>
