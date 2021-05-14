import logo from './logo.svg';
import React from "react";
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import styled from 'styled-components';
import Comp1 from "./components/Comp1";
import Comp2 from "./components/Comp2";


const H0 = styled.h1({
  fontSize: 25,
  fontWeight: 'bold',
  paddingBottom: 2,
  paddingTop: 20,
  color: 'black',
  textAlign: "center"
});

const H1 = styled.h1({
  fontSize: 15,
  paddingBottom: 20,
  paddingTop: 0,
  color: 'gray',
  textAlign: "center"
});

class App extends React.Component{
  render() {
    return (
        <Router>
          <div>
            <H0><i>ArmyEyer</i></H0>
            <H1> Our Army are comming...</H1>

            <nav className="navbar navbar-expand-lg navbar-light bg-light">
              <ul className="navbar-nav mr-auto">
                <li><Link to={'/comp1'} className="nav-link"><b>Comp1</b></Link></li>
                <li><Link to={'/comp2'} className="nav-link"><b>Comp2</b></Link></li>
              </ul>
            </nav>
            <hr/>
            <Switch>
              <Route path='/comp1' component={Comp1}/>
              <Route path='/comp2' component={Comp2}/>
            </Switch>
          </div>
        </Router>
    );
  }
}

export default App;
