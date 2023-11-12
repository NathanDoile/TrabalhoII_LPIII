import { obterDeputadoApi } from "../../api";
import { toast } from "react-toastify";
import useGlobalDeputado from "../../context/deputado/deputado.context";
import { useNavigate } from "react-router-dom";

export function useObterDeputado(){

    const [, setDeputado] = useGlobalDeputado();

    const navigate = useNavigate();

    async function obterDeputado(idDeputado){

        try{
            const response = await obterDeputadoApi(idDeputado);

            setDeputado(response);

            navigate("/deputado");
        }
        catch(error){
            toast.error(error);
        }

    }

    return {obterDeputado}
}