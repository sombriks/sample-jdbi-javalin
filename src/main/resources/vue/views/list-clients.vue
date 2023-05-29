<template id="list-clients">
  <a href="/">Back</a>
  <div v-if="clients.loading">loading...</div>
  <client-list v-else :clients="clients.data"></client-list>
</template>
<script nonce="@addNonce">
app.component("list-clients", {
  template: "#list-clients",
  data() {
    return {
      clients: new LoadableData("/clients")
    }
  }
})
</script>
<style>

</style>