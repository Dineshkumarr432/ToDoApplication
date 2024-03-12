import React from 'react';
import './App.css';
import Navigation from './Component/Navigation';
import { Route, Switch } from 'react-router-dom';
import ListToDo from './Component/ListToDo';
import ToDo from './Component/ToDo';

const Home = () => {
  return (
    <>
      <h1 className="text-center mb-4">
        <b>ToDo Application</b>
      </h1>
    </>
  );
};

function App() {
  return (
    <>
      <Navigation />
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path="/listTodo">
          <ListToDo />
        </Route>
        <Route exact path="/edit-todo/:id">
          <ToDo />
        </Route>
        <Route exact path="/todo">
          <ListToDo />
        </Route>
        <Route exact path="/add-todo">
          <ToDo />
        </Route>
      </Switch>
    </>
  );
}

export default App;
