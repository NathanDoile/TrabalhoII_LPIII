import './evento.component.css';
import useGlobalDeputado from '../../../context/deputado/deputado.context';
import { useNavigate } from 'react-router-dom';

export function Evento({nome, id, excluir}){

    const [deputado, setDeputado] = useGlobalDeputado();

    const navigate = useNavigate();

    function editar(){
        
        setDeputado({...deputado, "eventoEditar":id});

        navigate("/deputado/inscrever-eventos");
    }

    return(
        <div className='container-evento'>

            <p>{nome}</p>

            <span>
                <button className='botao-evento' onClick={editar}>Editar</button>
                <button className='botao-evento' onClick={() => {excluir(id)}}>Excluir</button>
            </span>
        </div>
    )
}