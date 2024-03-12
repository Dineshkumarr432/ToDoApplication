import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { Link, useHistory } from "react-router-dom";
import {
  completeToDoById,
  deleteToDo,
  getAllToDo,
  inCompleteToDoById,
} from "../Service/TodoService";
type ToDo={
id:number;
title:string;
description:string;
completed:boolean;
}
const ListToDo:React.FC=()=>{
const history = useHistory();
const [todo,setTodo]=useState<ToDo[]>([])
const updateToDo = (id: number) => {
history.push(`/edit-todo/${id}`);
};
 const listToDos=()=>{
        getAllToDo().
          then((response)=>{
              setTodo(response.data)
          console.log(response.data);
          })
          .catch((error)=>{
              console.log(error);
          })
      }
      const removeToDo=(id:number)=>{
        deleteToDo(id)
        .then(()=>listToDos())
        .catch((error)=>console.log(error));
    }
         const completeToDo=(id:number)=>{
        completeToDoById(id).then(()=>listToDos()).catch((error)=>console.log(error));
      }
      const inCompleteToDo=(id:number)=>{
        inCompleteToDoById(id).then(()=>listToDos()).catch((error)=>console.log(error));
      }
      useEffect(()=>
          listToDos(), [])
    return (
        <div className="col-md-20">
          <h1 className="text-center mb-4">List Of ToDos</h1>
          <Link to="/add-todo" className="btn btn-primary mb-2">
            Add your task
          </Link>
          <div className="table-responsive">
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Description</th>
                  <th>Completed</th>
                  <th>Action</th>
                </tr>
                </thead>
        <tbody>
                {todo.map((todo) => (
                  <tr key={todo.id}>
                    <td>{todo.title}</td>
                    <td>{todo.description}</td>
                    <td>{todo.completed ? "Yes" : "No"}</td>
                    <td>
                      <Button onClick={() => updateToDo(todo.id)} variant="primary">
                        Update
                      </Button>{" "}
                      <Button onClick={() => removeToDo(todo.id)} variant="danger">
                        Delete
                            </Button>{" "}
                    <Button onClick={() => completeToDo(todo.id)} variant="success">
                        Completed
                      </Button>{" "}
                      <Button onClick={() => inCompleteToDo(todo.id)} variant="warning">
                        InCompleted
                      </Button>{" "}
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
            </div>
            </div>
        ) 
    }
        export default ListToDo;