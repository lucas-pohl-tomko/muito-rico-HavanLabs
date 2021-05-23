<template>

  <div id="app">
    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Casa de Câmbios Muito Rico</a>
      </div>
    </nav>
    <div class="container">
    <div class="ui hidden divider"></div>
    </div>
    <div class="container">
      <div class="ui segment">
        <form @submit.prevent="salvar">

          <label>Nome</label>
          <input type="text" placeholder="Nome" v-model="cambio.nome">
          <div class="ui basic segment">
            <div class="ui two column very relaxed grid">
              <div class="column">
                <label>Moeda de origem</label>
                <input type="text" list="moedas" v-model="cambio.moedaOrigem"/>
                <datalist id="moedas">
                  <option value="Real">Real</option>
                  <option value="Dólar Americano">Dólar Americano</option>
                  <option value="Dólar Canadense">Dólar Canadense</option>
                  <option value="Dólar Australiano">Dólar Australiano</option>
                  <option value="Yen Japonês‎">Yen Japonês‎</option>
                </datalist>
              </div>
              <div class="column">
                <label>Moeda de destino</label>
                <input type="text" list="moedas" v-model="cambio.moedaDestino"/>
                <datalist id="moedas">
                  <option value="Real">Real</option>
                  <option value="Dólar Americano">Dólar Americano</option>
                  <option value="Dólar Canadense">Dólar Canadense</option>
                  <option value="Dólar Australiano">Dólar Australiano</option>
                  <option value="Yen Japonês‎">Yen Japonês‎</option>
                </datalist>
              </div>
            </div>
          </div>


          
          <label>Data</label>
          <input type="date" placeholder="Data" v-model="cambio.dataCambio">
          <label>Valor Original</label>
          <input type="number" placeholder="Valor" v-model="cambio.valorOriginal">
          <label>Valor de Conversão</label>
          <input type="number" step="any" placeholder="Conversão" v-model="cambio.conversao">
    

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
      </div>
    </div>
    <div class="container">
      <div class="ui hidden divider"></div>
    </div>
    <div class="container">
        <div class="ui top attached tabular menu">
          <a 
            class="item" 
            data-tab="cliente"
            :class="{ active: clienteEstaAtivo }"
            @click="switchTabs('cliente')"
          >
            Pesquisar por Clientes
          </a>
          <a 
            class="item" 
            data-tab="data"
            :class="{ active: dataEstaAtivo }"
            @click="switchTabs('data')"
          >
            Pesquisar por Datas
          </a>
        </div>
        <div 
          class="ui bottom attached tab segment" 
          data-tab="cliente"
          :class="{ active: clienteEstaAtivo }"
        >
              <div>
                <label>Pesquise Clientes:</label>
                <input type="text" v-model="pesquisaNome" placeholder="Exemplo: lucas"/>
              </div>
              <table class="ui celled table">
                <thead>

                  <tr>

                    <th>NOME</th>
                    <th>MOEDA DE ORIGEM</th>
                    <th>MOEDA DE DESTINO</th>
                    <th>DATA</th>
                    <th>VALOR ORIGINAL</th>
                    <th>VALOR CONVERTIDO</th>
                    <th>TAXA COBRADA </th>

                  </tr>

                </thead>

                <tbody>

                  <tr v-for="cliente of cambiosFiltradosPorNome" :key="cliente.id">

                    <td>{{cliente.nome}}</td>
                    <td>{{cliente.moedaOrigem}}</td>
                    <td>{{cliente.moedaDestino}}</td>
                    <td>{{cliente.dataCambio}}</td>
                    <td>{{cliente.valorOriginal}} : {{cliente.moedaOrigem}}</td>
                    <td>{{cliente.valorConvertido}} : {{cliente.moedaDestino}}</td>
                    <td>{{cliente.taxa}}  :  {{cliente.moedaDestino}}</td>

                  </tr>
                </tbody>
              </table>
        </div>
        <div 
          class="ui bottom attached tab segment" 
          data-tab="data"
          :class="{ active: dataEstaAtivo }"
        >

              <div>
                <label>Pesquise Datas:</label>
                <input type="text" v-model="pesquisaData" placeholder="Exemplo: 1999... ou 12-12-1999..."/>
              </div>
              <table class="ui celled table">
                <thead>
                  <tr>

                    <th>NOME</th>
                    <th>MOEDA DE ORIGEM</th>
                    <th>MOEDA DE DESTINO</th>
                    <th>DATA</th>
                    <th>VALOR ORIGINAL</th>
                    <th>VALOR CONVERTIDO</th>
                    <th>TAXA COBRADA </th>

                  
                  </tr>

                </thead>

                <tbody>

              <tr v-for="cliente of cambiosFiltradosPorData" :key="cliente.id">

                <td>{{cliente.nome}}</td>
                <td>{{cliente.moedaOrigem}}</td>
                <td>{{cliente.moedaDestino}}</td>
                <td>{{cliente.dataCambio}}</td>
                <td>{{cliente.valorOriginal}} : {{cliente.moedaOrigem}}</td>
                <td>{{cliente.valorConvertido}} : {{cliente.moedaDestino}}</td>
                <td>{{cliente.taxa}}  :  {{cliente.moedaDestino}}</td>
                
              </tr>

            </tbody>
          
          </table>
        </div>
      </div>
  </div>
  
</template>

<script>

  import Cambio from './services/cambios'

  export default{
    
    data(){

      return{
        
        cambio: {
          nome: '',
          moedaOrigem: '',
          moedaDestino: '',
          dataCambio: '',
          valorOriginal: '',
          valorConvertido: '',
          taxa: '',
          conversao: ''
        },
        cambios: [],
        clientes: [],
        pesquisaNome: '',
        pesquisaData: '',
        clienteEstaAtivo: true,
        dataEstaAtivo: false,
      }
      
    },
    computed: {
      cambiosFiltradosPorNome() {
        return this.cambios.filter(cambio => {
          return cambio.nome.toLowerCase().includes(this.pesquisaNome.toLowerCase())
        })
      },
      cambiosFiltradosPorData() {
        return this.cambios.filter(cambio => {
          return cambio.dataCambio.includes(this.pesquisaData)
        })
      }
    },
    mounted(){
      this.listar()
    },
    methods: {
      listar(){
        Cambio.listar().then(resposta => {
        this.cambios = resposta.data
        })
      },
      switchTabs(tab) {
        if (tab === 'cliente') {
          this.clienteEstaAtivo = true;
          this.dataEstaAtivo = false;
        } else {
          this.clienteEstaAtivo = false;
          this.dataEstaAtivo = true;
        }
        
      },
      listarPorCliente(){
        Cambio.listarPorCliente("lucas").then(resposta => {
        this.clientes = resposta.data
        })
      },
      salvar(){
        
          Cambio.salvar(this.cambio).then(resposta => {
            resposta
            console.log(this.cambio)
            alert('Cambio salvo com sucesso!')
            this.listar()
          })
      },
    }
  }
  

</script>

<style>

</style>
