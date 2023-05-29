<template id="index">
  <h1>General Reports</h1>
  <nav>
    <a href="/list/clients">List Clients</a>
    <span>|</span>
    <a href="/list/products">List Products</a>
    <span>|</span>
    <a href="/list/orders">List Orders</a>
  </nav>
</template>

<script nonce="@addNonce">
app.component("index", {
  template: "#index"
})
</script>

<style>
body {
  background-color: antiquewhite;
  color: blue;
}
nav>span{
  margin-left:1em;
  margin-right:1em;
}
</style>
