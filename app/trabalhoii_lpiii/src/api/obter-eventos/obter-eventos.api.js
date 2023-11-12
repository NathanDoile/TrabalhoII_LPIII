import { axiosInstance } from "../base/axiosInstance";

export async function obterEventosApi() {

    try {
        const response = await axiosInstance.get(`/eventos`);

        return response.data;

    } catch (error) {
        throw error?.response?.data?.message;
    }
}