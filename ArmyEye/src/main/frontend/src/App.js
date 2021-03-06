import logo from './logo.svg';
import React from "react";
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import styled from 'styled-components';
import MapComponent from "./components/MapComponent";
import GPS from "./components/GPS";
import Helmet from "./components/Helmet";
import ECG from "./components/ECG";
import Comp2 from "./components/Comp2";
import Initial from "./components/Initial";
import axios from "axios";



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
            <H0><i>ArmyEye</i></H0>
            <H1>We save lives!</H1>

            <nav className="navbar navbar-expand-lg navbar-light bg-light">
              <ul className="navbar-nav mr-auto">
                <li><Link to={'/map'} className="nav-link"><b>Map</b></Link></li>
                <li><Link to={'/gps'} className="nav-link"><b>GPS</b></Link></li>
                <li><Link to={'/helmet'} className="nav-link"><b>Helmet</b></Link></li>
                <li><Link to={'/ecg'} className="nav-link"><b>ECG</b></Link></li>
                {/*<li><Link to={'/comp2'} className="nav-link"><b>Comp2</b></Link></li>*/}
              </ul>
            </nav>
            <hr/>
            <Switch>
              <Route path='/map' component={MapComponent}/>
              <Route path='/gps' component={GPS}/>
              <Route path='/helmet' component={Helmet}/>
              <Route path='/ecg' component={ECG}/>
              <Route path='/' component={Initial}/>
              {/*<Route path='/comp2' component={Comp2}/>*/}
            </Switch>
          </div>
        </Router>
    );
  }
}

export default App;
