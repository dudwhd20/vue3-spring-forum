<script setup lang="ts">
import { ref } from 'vue'
import { useQuasar } from 'quasar'
import { loginMember} from '@/api/authtication'
import type { RequestUser } from '@/api/authtication'
import { useRouter } from 'vue-router'

const router = useRouter()

const $q = useQuasar()
const username = ref('')
const password = ref('')

const login = () => {
  if (username.value && password.value) {
    const requestUser: RequestUser = {
      email: username.value,
      password: password.value
    }
     loginMember(requestUser)
      .then(() => {
        $q.notify({
          type: 'positive',
          message: 'Login successful.'
        })
        router.push('/main')
      })
      .catch(() => {
        $q.notify({
          type: 'negative',
          message: 'Login failed.'
        })
      })
  } else {
    $q.notify({
      type: 'negative',
      message: 'Please enter both username and password.'
    })
  }
}
</script>

<template>
  <q-layout>
    <q-page-container>
      <q-page class="flex flex-center q-pa-md">
        <q-card class="q-pa-md" style="width: 400px">
          <q-card-section>
            <div class="text-h6">Login</div>
          </q-card-section>

          <q-card-section>
            <q-input v-model="username" label="Username" filled />
            <q-input v-model="password" label="Password" type="password" filled class="q-mt-md" />
          </q-card-section>

          <q-card-actions align="right">
            <q-btn label="Login" color="primary" @click="login" />
          </q-card-actions>
        </q-card>
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<style scoped></style>
