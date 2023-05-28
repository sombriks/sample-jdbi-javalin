<template id="hello-world">
  <h1>Hello world</h1>
  <client-list :clients="clients"></client-list>
</template>

<script nonce="@addNonce">
app.component("hello-world", {
  template: "#hello-world",
  data() {
    return {
      clients: []
    }
  },
  async mounted() {
    const result = await fetch("/clients")
    this.clients = await result.json()
  }
})
</script>

<style>
body {
  background-color: antiquewhite;
  color: blue;
}
</style>
