import { TelaHome, TelaDeputado, TelaInscreverEvento, TelaVerEventos } from "../ui/screen";

const { createBrowserRouter } = require("react-router-dom");

export const router = createBrowserRouter([
    {
        path: "/",
        element: <TelaHome />,
    },
    {
        path: "/deputado",
        element: <TelaDeputado />
    },
    {
        path: "/deputado/inscrever-eventos",
        element: <TelaInscreverEvento />
    },
    {
        path: "/deputado/eventos",
        element: <TelaVerEventos />
    }
]);
