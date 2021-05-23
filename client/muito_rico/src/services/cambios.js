import { http } from './config'

export default {

    listar:() => {
        return http.get('')
    },
    listarPorCliente:(cliente) => {
        return http.get('cliente/',cliente)
    },
    salvar:(cambio) => {
        cambio.valorConvertido = cambio.valorOriginal * cambio.conversao
        cambio.taxa = cambio.valorConvertido * 0.1
        return http.post('',cambio)
    }
}
