import { axiosInstance } from "../base/axiosInstance";

export async function obterEventoPorDeputadoApi(id) {

    try {
        const response = await axiosInstance.get(`/eventos/deputado/${id}`);

        return response.data;

    } catch (error) {
        throw error?.response?.data?.message;
    }
}