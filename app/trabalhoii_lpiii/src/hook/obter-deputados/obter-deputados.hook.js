import { obterDeputadosApi } from "../../api";
import { toast } from "react-toastify";

export function useObterDeputados(){

    async function obterDeputados(){

        try{
            const response = await obterDeputadosApi();

            return response;
        }
        catch(error){
            toast.error(error);
        }

    }

    return {obterDeputados}
}