import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import '@quasar/extras/material-icons/material-icons.css'

import 'quasar/src/css/index.sass'
import { Quasar, Notify } from 'quasar'

const app = createApp(App)
app.use(Quasar, {
  plugins: {
    Notify
  }
})
app.use(createPinia())
app.use(router)

app.mount('#app')
