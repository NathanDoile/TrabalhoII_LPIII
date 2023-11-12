import './App.css';
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { router } from "./router/index";
import { RouterProvider } from "react-router-dom";
import { GlobalDeputadoProvider } from "./context/deputado/deputado.context";

function App() {
  return (
    <>
      <GlobalDeputadoProvider>
        <ToastContainer />
        <RouterProvider router={router} />
      </GlobalDeputadoProvider>
    </>
  );
}

export default App;
