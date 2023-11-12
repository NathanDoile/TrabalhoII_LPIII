import { axiosInstance } from "../base/axiosInstance";

export async function desinscreverEventoApi(idDeputado, idEvento) {

    try {
        await axiosInstance.put(`/deputados/${idDeputado}/eventos/${idEvento}/desinscrever`);

    } catch (error) {
        throw error?.response?.data?.message;
    }
}