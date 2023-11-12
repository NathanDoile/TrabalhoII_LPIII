import './home.screen.css';
import { Deputado, Cabecalho } from '../../component';
import { useState, useEffect } from 'react';
import { useObterDeputados } from '../../../hook';

export function TelaHome() {

    const [deputados, setDeputados] = useState([]);

    const [deputadosTag, setDeputadosTag] = useState([]);

    const { obterDeputados } = useObterDeputados();

    useEffect(() => {

        async function obter() {
            const response = await obterDeputados();

            setDeputados(response);
        }

        obter();
    }, []);

    useEffect(() => {

        setDeputadosTag([]);

        deputados.forEach(deputado => {
            setDeputadosTag((oldDeputados) => ([...oldDeputados,
                <Deputado foto={deputado.urlFoto}
                    nome={deputado.nome} partido={deputado.siglaPartido} estado={deputado.siglaUf}
                    email={deputado.email} id={deputado.id} />
            ]))
        })

    }, [deputados]);

    return (
        <>

            <Cabecalho />

            <main className='main-home'>

                {deputadosTag}

            </main>
        </>
    )
}