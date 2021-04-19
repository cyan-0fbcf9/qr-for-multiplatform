import Vue from 'vue';
import VueRouter from 'vue-router';
// import Home from '@/pages/Home.vue';
import Download from '@/pages/Download';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Download
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '@/pages/About.vue')
  },
  {
    path: '/download',
    name: 'Download',
    component: Download
  }
];

const router = new VueRouter({
  routes
});

export default router;
