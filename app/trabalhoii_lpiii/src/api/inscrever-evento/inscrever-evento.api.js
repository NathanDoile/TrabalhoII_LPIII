import { axiosInstance } from "../base/axiosInstance";

export async function inscreverEventoApi(idDeputado, idEvento) {

    try {
        await axiosInstance.put(`/deputados/${idDeputado}/eventos/${idEvento}/inscrever`);

    } catch (error) {
        throw error?.response?.data?.message;
    }
}