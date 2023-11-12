import { axiosInstance } from "../base/axiosInstance";

export async function obterDeputadosApi() {

    try {
        const response = await axiosInstance.get(`/deputados`);

        return response.data;

    } catch (error) {
        throw error?.response?.data?.message;
    }
}