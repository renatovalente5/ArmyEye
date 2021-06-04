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


class ECG extends React.Component {

    constructor(props){
      super(props);
        this.state = {
            ECG:[]
        }
      this.loadData = this.loadData.bind(this);
    }

    componentDidMount(){
      this.loadData();
      setInterval(this.loadData, 100000);

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

    render(){
        return(
            <div>
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
                    )
                    }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default ECG