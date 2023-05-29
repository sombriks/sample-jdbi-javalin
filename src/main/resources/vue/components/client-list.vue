<template id="client-list">
  <ul>
    <li v-for="client in clients" :key="client.id">
      {{ client.name }}
    </li>
  </ul>
</template>
<script nonce="@addNonce">
app.component("client-list", {
  template: "#client-list",
  props: ["clients"]
})
</script>
<style>

</style>
