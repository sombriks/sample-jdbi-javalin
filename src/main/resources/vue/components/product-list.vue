<template id="product-list">
  <ul v-if="products">
    <li v-for="product in products" :key="product.id">
      {{ product.name }}
    </li>
  </ul>
</template>
<script nonce="@addNonce">
app.component("product-list", {
  template: "#product-list",
  props: ["products"]
})
</script>
<style>

</style>
