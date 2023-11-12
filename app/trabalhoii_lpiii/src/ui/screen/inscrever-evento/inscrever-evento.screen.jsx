import './inscrever-evento.screen.css';
import { Cabecalho } from '../../component';
import { useState, useEffect } from 'react';
import { useObterEventos, useInscreverEvento, useDesinscreverEvento } from '../../../hook';
import { toast } from 'react-toastify';
import useGlobalDeputado from '../../../context/deputado/deputado.context';
import { useNavigate } from 'react-router-dom';

export function TelaInscreverEvento() {

    const [deputado, setDeputado] = useGlobalDeputado();

    const [evento, setEvento] = useState(0);

    const [eventos, setEventos] = useState([]);

    const [eventosTag, setEventosTag] = useState([]);

    const {obterEventos} = useObterEventos();

    const {inscreverEvento} = useInscreverEvento();

    const {desinscreverEvento} = useDesinscreverEvento();

    const navigate = useNavigate();

    function handleChange(event){
        const { value } = event.target;

        setEvento(value);
    }

    async function onSubmit(event){
        event.preventDefault();

        if(evento === 0){
            toast.error("Selecione uma opção!");
        }
        else{

            if(deputado.eventoEditar){

                await inscreverEvento(evento);

                await desinscreverEvento(deputado.eventoEditar);

                const {eventoEditar, ...outrasProps} = deputado;

                setDeputado(outrasProps);

                navigate("/deputado/eventos");
            }
            else{
                await inscreverEvento(evento);

                navigate("/deputado");
            }
        }
    }

    useEffect(() => {

        async function obter() {
            const response = await obterEventos();

            setEventos(response);
        }

        obter();
    }, []);

    useEffect(() => {

        setEventosTag([]);

        eventos.forEach(e => {
            setEventosTag((oldEventos) => ([...oldEventos,
                <option value={e.id}>{e.descricaoTipo}</option>
            ]))
        })

    }, [eventos]);

    return (
        <>
            <Cabecalho />

            <main className='main-inscrever-eventos'>

                <h1>Inscrever-se - <button onClick={() => {navigate("/deputado")}}>Tela principal</button></h1>

                <form className='form-inscrever' onSubmit={onSubmit}>

                    <select name="evento" onChange={handleChange} className='select-evento' required>
                        <option value={0}>Selecione</option>
                        {eventosTag}
                    </select>

                    <button className='botao-inscrever'>Inscrever</button>

                </form>

            </main>
        </>
    )
}