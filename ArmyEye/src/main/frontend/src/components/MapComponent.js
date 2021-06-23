import React from "react";
import ReactMapGL, { Marker, Popup } from "react-map-gl";
import 'mapbox-gl/dist/mapbox-gl.css';
import axios from "axios";
import {NotificationContainer, NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';



class MapComponent extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            army:[],
            viewport:{
                latitude: 37.41037,
                longitude: -122.05937,
                width: "81vw",
                height: "67vh",
                zoom: 6
            },
            mounted: false,
            selectedPark: false,
            message:"",
            lastMessage: "",
            messageCO:"",
            lastMessageCO: "",
            showPop: false,
            valorECG: "1",
            valorCO: "1"
        }

        this.loadData = this.loadData.bind(this);
        this.loadData2 = this.loadData2.bind(this);
        this.loadData3 = this.loadData3.bind(this);
        this.loadMessages = this.loadMessages.bind(this);
        this.loadMessagesCO = this.loadMessagesCO.bind(this);
    }

    componentDidMount(){
        this.loadData();
        this.loadData2();
        this.loadData3();
        this.loadMessages();
        this.loadMessagesCO();
        setInterval(this.loadData, 10000);
        setInterval(this.loadData2, 10000);
        setInterval(this.loadData3, 10000);
        setInterval(this.loadMessages, 10000);
        setInterval(this.loadMessagesCO, 10000);
        this.setState({ mounted: true })

    }

    async loadData() {
        try {
            axios.get("http://192.168.160.87:21001/map").then(response => {
                this.setState({ army: response.data })
                console.log( response.data)
            });
        } catch (e) {
            console.log(e);
        }
    }
    async loadData2() {
        try {
            axios.get("http://192.168.160.87:21001/valorECG").then(response => {
                console.log("ECG", response.data)
                this.setState({ valorECG: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    async loadData3() {
        try {
            axios.get("http://192.168.160.87:21001/valorCO").then(response => {
                console.log("ECG", response.data)
                this.setState({ valorCO: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    async loadMessages() {
        try {
            axios.get("http://192.168.160.87:21001/msg").then(response => {
                this.setState({ message: response.data })
            });
        } catch (e) {
            console.log(e);
        }
        if (this.state.lastMessage !== this.state.message && this.state.message !== ""){
            NotificationManager.info('',this.state.message ,4000);
            this.state.lastMessage = this.state.message;
        }
    }

    async loadMessagesCO() {
        try {
            axios.get("http://192.168.160.87:21001/msgCO").then(response => {
                this.setState({ messageCO: response.data })
            });
        } catch (e) {
            console.log(e);
        }
        if (this.state.lastMessageCO !== this.state.messageCO && this.state.messageCO !== ""){
            NotificationManager.error('',this.state.messageCO ,4000);
            this.state.lastMessageCO = this.state.messageCO;
        }
    }

    delta2 = () => {
        console.log("saiu no Delta")
        this.setState({
            showPop: true
        });
    }

    delta3 = () => {
        console.log("ehehe no Delta")
        this.setState({
            showPop: false
        });
    }


    render(){
        const { mounted } = this.state

        return(
            <div >
                <NotificationContainer/>

                <ReactMapGL {...this.state.viewport}
                            onViewportChange={(viewport) => {
                                if (mounted) { this.setState({ viewport }) }
                            }}
                            mapboxApiAccessToken="pk.eyJ1Ijoicml0YS1hbWFudGU5OTU1IiwiYSI6ImNrbmEyZGpzYzBqcjcybm55Z2NyOTVkazMifQ.oRw17OIsKSA0CeIUG2UC1Q">

                    {this.state.army.map( arm => (
                            <Marker key={arm.latitude} latitude={Number(arm.latitude)} longitude={Number(arm.longitude)}>
                                <button
                                    className="marker-btn"
                                    onClick={this.delta2}
                                    onDoubleClick={this.delta3}
                                >
                                    <img  width="20" height="20" src="../soldado.jpg" alt="Army Icon" />
                                </button>
                                {this.state.showPop ? (

                                    <Popup
                                        latitude={Number(arm.latitude)}
                                        longitude={Number(arm.longitude)}
                                        onClose={this.delta3}>
                                        <div className="marker">
                                            <span>
                                                <p><b>Latitude:</b> {this.state.army.map( arm => ( arm.latitude))}</p>
                                                <p><b>Longitude:</b>  {this.state.army.map( arm => ( arm.longitude))}</p>
                                                <p><b>CO:</b>  {this.state.valorCO}</p>
                                                <p><b>ECG:</b>  {this.state.valorECG}</p>
                                            </span>
                                        </div>
                                    </Popup>

                                ) : null}
                            </Marker>


                    ))}



                </ReactMapGL>
                <p style={{ marginTop: '20px'}} >
                    Latitude: {this.state.army.map( arm => ( arm.latitude))},
                    Longitude: {this.state.army.map( arm => ( arm.longitude))}
                </p>
            </div>
        );
    }
}

export default MapComponent