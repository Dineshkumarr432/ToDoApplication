import axios from "axios";

const baseUrl = "http://localhost:9091/api/todo";
export const createToDo = (todo: any) => axios.post(baseUrl, todo);
export const getAllToDo = () => axios.get(baseUrl);
export const UpdateToDoById = (id: number, todo: any) =>
  axios.put(baseUrl + "/" + id, todo);
export const getToDoById = (id: number) => axios.get(baseUrl + "/" + id);
export const deleteToDo = (id: number) => axios.delete(baseUrl + "/" + id);
export const completeToDoById = (id: number) =>
  axios.put(baseUrl + "/" + id + "/complete");
export const inCompleteToDoById = (id: number) =>
  axios.put(baseUrl + "/" + id + "/inComplete");