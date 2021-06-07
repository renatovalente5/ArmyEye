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


class Comp2 extends React.Component {

    constructor(props){
      super(props);
        this.state = {
            army:''
        }
      this.loadData = this.loadData.bind(this);
    }

    componentDidMount(){
      this.loadData();
      setInterval(this.loadData, 10000);

    }

    async loadData() {
        try {
            axios.get("http://192.168.160.87:21001/comp2").then(response => {
                this.setState({ army: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    render(){       

                
        return(
            <div>
                <H0 className="text-center" > ehehe <b>{ this.state.army}</b>  </H0>

            </div>
      );
    }
}

export default Comp2