import { obterEventosApi } from "../../api";
import { toast } from "react-toastify";

export function useObterEventos(){

    async function obterEventos(){

        try{
            const response = await obterEventosApi();

            return response;
        }
        catch(error){
            toast.error(error);
        }

    }

    return {obterEventos}
}