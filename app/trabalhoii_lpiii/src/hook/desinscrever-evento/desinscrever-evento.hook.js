import { desinscreverEventoApi } from "../../api";
import { toast } from "react-toastify";
import useGlobalDeputado from "../../context/deputado/deputado.context";

export function useDesinscreverEvento(){

    const [deputado] = useGlobalDeputado();

    async function desinscreverEvento(idEvento){

        try{
            await desinscreverEventoApi(deputado.id, idEvento);

            toast.success("Inscrição cancelada.")
        }
        catch(error){
            toast.error(error);
        }

    }

    return {desinscreverEvento}
}