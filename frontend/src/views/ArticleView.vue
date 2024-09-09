<script setup lang="ts">
import { ref } from 'vue'

const posts = ref([
  { id: 1, user: 'User1', caption: 'Beautiful day!', likes: 120 },
  { id: 2, user: 'User2', caption: 'Loving this!', likes: 98 },
  // Add more posts as needed
])
</script>

<template>
  <section class="forum-section">
    <div class="posts">
      <div v-for="post in posts" :key="post.id" class="post">
        <div class="post-header">
          <span class="post-user-name">{{ post.user }}</span>
        </div>
        <div class="post-caption">
          <span class="post-user-name">{{ post.user }}</span> {{ post.caption }}
        </div>
        <div class="post-likes">{{ post.likes }} likes</div>
        <div class="post-actions">
          <button class="like-btn">Like</button>
          <button class="comment-btn">Comment</button>
<!--          <button class="share-btn">Share</button>-->
        </div>
      </div>
    </div>
  </section>
</template>

<style scoped>
.forum-section {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}

.posts {
  margin-top: 20px;
}

.post {
  margin-bottom: 20px;
}

.post-header {
  display: flex;
  align-items: center;
  padding: 10px 0;
}

.post-user-name {
  font-weight: bold;
}

.post-caption {
  padding: 10px 0;
}

.post-likes {
  font-weight: bold;
  padding: 5px 0;
}

.post-actions {
  display: flex;
  justify-content: space-around;
  padding: 10px 0;
}

.like-btn, .comment-btn, .share-btn {
  background: none;
  border: none;
  cursor: pointer;
}
</style>
