import './ver-eventos.screen.css';
import { Cabecalho, Evento } from '../../component';
import useGlobalDeputado from '../../../context/deputado/deputado.context';
import { useObterEventoPorDeputado, useDesinscreverEvento } from '../../../hook';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

export function TelaVerEventos(){

    const navigate = useNavigate();

    const [deputado] = useGlobalDeputado();

    const {obterEventoPorDeputado} = useObterEventoPorDeputado();

    const [eventos, setEventos] = useState([]);

    const [eventosTag, setEventosTag] = useState([]);

    const {desinscreverEvento} = useDesinscreverEvento();

    const [recarregar, setRecarregar] = useState(false);

    async function desinscrever(id){
        await desinscreverEvento(id);
        
        setRecarregar(!recarregar);
    }

    useEffect(() => {

        async function obter() {
            const response = await obterEventoPorDeputado(deputado.id);

            setEventos(response);
        }

        obter();
    }, [recarregar]);

    useEffect(() => {

        setEventosTag([]);

        eventos.forEach(evento => {
            setEventosTag((oldEventos) => ([...oldEventos,
                <Evento nome={evento.descricaoTipo} id={evento.id} excluir={desinscrever} />
            ]))
        })

    }, [eventos]);

    return(
        <>
            <Cabecalho />

            <main className='main-eventos'>

                <h1>Lista de eventos - Deputado {deputado.nome} - <button onClick={() => {navigate("/deputado")}}>Tela principal</button></h1>

                {eventosTag.length === 0 ? <h2>Nenhum evento encontrado.</h2> : eventosTag}
            </main>
        </>
    )
}