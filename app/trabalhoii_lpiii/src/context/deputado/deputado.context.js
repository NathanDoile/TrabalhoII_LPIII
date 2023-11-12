import createGlobalState from "react-create-global-state";

const DEPUTADO_KEY = "deputado";

const stateInStorage = localStorage.getItem(DEPUTADO_KEY);
const initialState = stateInStorage ? JSON.parse(stateInStorage) : null;

const [_useGlobalUsuario, Provider] = createGlobalState(initialState);

function useGlobalDeputado() {
  const [_Deputado, _setDeputado] = _useGlobalUsuario();

  function setDeputado(deputado) {
    _setDeputado(deputado);
    localStorage.setItem(DEPUTADO_KEY, JSON.stringify(deputado));
  }

  return [_Deputado, setDeputado];
}

export const GlobalDeputadoProvider = Provider;
export default useGlobalDeputado;
