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
    textAlign: "center",
});

class GPS extends React.Component {

    constructor(props){
      super(props);
        this.state = {
            armys:[]
        }
      this.loadData = this.loadData.bind(this);
    }

    componentDidMount(){
      this.loadData();
      setInterval(this.loadData, 100000);

    }

    async loadData() {
        try {
            axios.get("http://192.168.160.87:21001/gps").then(response => {
                this.setState({ armys: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    render(){
        return(
            <div>
                <H0 className="text-center" > Army Steps </H0>

                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td>Timestamp (UTC)</td>
                        <td>Timestamp (ms)</td>
                        <td>GPS time</td>
                        <td>Latitude</td>
                        <td>Longitude</td>
                        <td>Altitude</td>

                    </tr>
                    </thead>
                    <tbody id="myTable"> { this.state.armys.map( arm =>
                        <tr key = {arm.Latitude}>
                            <td>{arm.TimestampUTC}</td>
                            <td>{arm.Timestampms}</td>
                            <td>{arm.GPStime}</td>
                            <td>{arm.Latitude}</td>
                            <td>{arm.Longitude}</td>
                            <td>{arm.Altitude}</td>
                        </tr>
                    )
                    }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default GPS