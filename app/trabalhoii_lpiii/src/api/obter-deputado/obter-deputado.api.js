import { axiosInstance } from "../base/axiosInstance";

export async function obterDeputadoApi(id) {

    try {
        const response = await axiosInstance.get(`/deputados/${id}`);

        return response.data;

    } catch (error) {
        throw error?.response?.data?.message;
    }
}