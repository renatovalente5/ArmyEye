import React, { Component, useState, SyntheticEvent  } from "react";
import axios from "axios";
import styled from 'styled-components';
import {Line} from "react-chartjs-2";

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



class ECG extends React.Component {

    constructor(props){
      super(props);
        this.state = {
            ECG:[],
            labels: ['Now','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','...'],
            datasets: [
                {
                    label: 'ECG',
                    fill: false,
                    lineTension: 0.5,
                    backgroundColor: 'rgba(75,192,192,1)',
                    borderColor: 'rgba(0,0,0,1)',
                    borderWidth: 2,
                    data: [120,146]
                }
            ]
        }
      this.loadData = this.loadData.bind(this);
      this.loadData2 = this.loadData2.bind(this);

    }

    componentDidMount(){
      this.loadData();
      this.loadData2();

      setInterval(this.loadData, 10000);
      setInterval(this.loadData2, 10000);

    }

    async loadData() {
        try {
            axios.get("http://192.168.160.87:21001/ecg").then(response => {
                this.setState({ ECG: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    async loadData2() {
        try {
            axios.get("http://192.168.160.87:21001/ecg2").then(response => {
                console.log(response.data);
                this.setState({ datasets: [
                        {
                            label: 'Rainfall',
                            fill: false,
                            lineTension: 0.5,
                            backgroundColor: 'rgba(75,192,192,1)',
                            borderColor: 'rgba(0,0,0,1)',
                            borderWidth: 2,
                            data: response.data
                        }
                    ] })
            });
        } catch (e) {
            console.log(e);
        }
    }


    render(){
        return(
            <div>
                <Line data={this.state} />
                <H0 className="text-center" > Health Army Status </H0>

                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td>ECG</td>

                    </tr>
                    </thead>
                    <tbody id="myTable"> { this.state.ECG.map( ecg =>
                        <tr key = {ecg.ECG}>
                            <td>{ecg.ECG}</td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default ECG