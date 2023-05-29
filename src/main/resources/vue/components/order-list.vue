<template id="order-list">
  <ul v-if="orders">
    <li v-for="order in orders" :key="order.id">
      {{ order.name }}
    </li>
  </ul>
</template>
<script nonce="@addNonce">
app.component("order-list", {
  template: "#order-list",
  props: ["orders"]
})
</script>
<style>

</style>
