import './deputado.screen.css';
import { Cabecalho } from '../../component';
import useGlobalDeputado from '../../../context/deputado/deputado.context';
import { useNavigate } from 'react-router-dom';

export function TelaDeputado() {

    const [deputado] = useGlobalDeputado();

    const navigate = useNavigate();

    function sair(){

        localStorage.clear();

        navigate("/");
    }

    return (
        <>
            <Cabecalho />

            <main className='main-deputado'>
                
                <h1>Deputado {deputado.nome}</h1>

                <button className="botao-deputado" onClick={() => {navigate("/deputado/eventos")}}>Ver eventos</button>

                <button className="botao-deputado" onClick={() => {navigate("/deputado/inscrever-eventos")}}>Inscrever</button>

                <button className="botao-deputado" onClick={sair}>Sair</button>

            </main>
        </>
    )
}