import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import MainView from '@/views/MainView.vue'
import ArticleRouter from '@/router/ariticle'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: LoginView
    },
    {
      path: '/main',
      name: 'main',
      component: MainView,
      children:[
        ArticleRouter
      ]
    },
  ]
})

export default router
