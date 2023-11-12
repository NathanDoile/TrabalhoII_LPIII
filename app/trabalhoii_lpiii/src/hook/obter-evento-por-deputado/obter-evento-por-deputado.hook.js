import { obterEventoPorDeputadoApi } from "../../api";
import { toast } from "react-toastify";

export function useObterEventoPorDeputado(){

    async function obterEventoPorDeputado(idDeputado){

        try{
            const response = await obterEventoPorDeputadoApi(idDeputado);

            return response;
        }
        catch(error){
            toast.error(error);
        }

    }

    return {obterEventoPorDeputado}
}