import React, { Component, useState, SyntheticEvent  } from "react";
import axios from "axios";
import styled from 'styled-components';


const H0 = styled.h1({
    fontSize: 25,
    paddingBottom: 30,
    paddingTop: 20,
    color: 'black',
    textAlign: "center"
});

const H1 = styled.h1({
    paddingBottom: 30,
    fontSize: 12,
    paddingTop: 0,
    textAlign: "center"
});


class Helmet extends React.Component {

    constructor(props){
      super(props);
        this.state = {
            helmet:[]
        }
      this.loadData = this.loadData.bind(this);
    }

    componentDidMount(){
      this.loadData();
      setInterval(this.loadData, 100000);

    }

    async loadData() {
        try {
            axios.get("http://192.168.160.87:21001/helmet").then(response => {
                this.setState({ helmet: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    render(){
        return(
            <div>
                <H0 className="text-center" > Army Status </H0>

                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td>Timestamp (UTC)</td>
                        <td>Timestamp (ms)</td>
                        <td>Altitude</td>
                        <td>CO</td>
                        <td>NO2</td>
                        <td>Environmentaltemperature</td>
                        <td>Atmosphericpressure</td>
                        <td>Humidity</td>
                        <td>Luminosity</td>
                        <td>Battery</td>

                    </tr>
                    </thead>
                    <tbody id="myTable"> { this.state.helmet.map( hel =>
                        <tr key = {hel.Timestampms}>
                            <td>{hel.TimestampUTC}</td>
                            <td>{hel.Timestampms}</td>
                            <td>{hel.Altitude}</td>
                            <td>{hel.CO}</td>
                            <td>{hel.NO2}</td>
                            <td>{hel.Environmentaltemperature}</td>
                            <td>{hel.Atmosphericpressure}</td>
                            <td>{hel.Humidity}</td>
                            <td>{hel.Luminosity}</td>
                            <td>{hel.Battery}</td>
                        </tr>
                    )
                    }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default Helmet