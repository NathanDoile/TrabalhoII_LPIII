import './deputado.component.css';
import { useObterDeputado } from '../../../hook';

export function Deputado({foto, nome, partido, estado, email, id}) {

    const {obterDeputado} = useObterDeputado();

    return (
        <div className='container-deputado' onClick={() => {obterDeputado(id)}}>

            <img className='foto-deputado' src={foto} alt={nome} />

            <p>{nome}</p>

            <p>Partido: {partido}</p>

            <p>Estado: {estado}</p>

            <p>E-mail: {email}</p>
        </div>
    );
}