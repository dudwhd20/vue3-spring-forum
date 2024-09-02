<script setup lang="ts">
import { ref } from 'vue'
const leftDrawerOpen = ref(false)

function toggleLeftDrawer () {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
</script>
<template>
  <q-layout view="hHh lpR lFr">

    <q-header reveal class="bg-primary text-white">
      <q-toolbar>
        <q-btn dense flat round icon="menu"  @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Forum
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer  v-model="leftDrawerOpen" side="left" bordered>
      <!-- drawer content -->
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>


