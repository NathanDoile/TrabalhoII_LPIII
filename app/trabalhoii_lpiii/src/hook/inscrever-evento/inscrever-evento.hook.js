import { inscreverEventoApi } from "../../api";
import { toast } from "react-toastify";
import useGlobalDeputado from "../../context/deputado/deputado.context";

export function useInscreverEvento(){

    const [deputado] = useGlobalDeputado();

    async function inscreverEvento(idEvento){

        try{
            await inscreverEventoApi(deputado.id, idEvento);

            toast.success("Inscrição feita.")

        }
        catch(error){
            toast.error(error);
        }

    }

    return {inscreverEvento}
}