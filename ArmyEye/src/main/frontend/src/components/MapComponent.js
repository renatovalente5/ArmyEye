import React from "react";
import ReactMapGL, { Marker, Popup } from "react-map-gl";
import 'mapbox-gl/dist/mapbox-gl.css';
import axios from "axios";


class MapComponent extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            planes:[],
            viewport:{
                latitude: 37.41037,
                longitude: -122.05937,
                width: "52vw",
                height: "67vh",
                zoom: 6
            },
            mounted: false
        }
        this.loadData = this.loadData.bind(this);
    }

    componentDidMount(){
        this.loadData();
        setInterval(this.loadData, 100000);
        this.setState({ mounted: true })

    }

    async loadData() {
        try {
            axios.get("http://localhost:8080/map").then(response => {
                this.setState({ planes: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }

    render(){
        const { mounted } = this.state
        return(
            <div >
                <p>{this.state.planes.latitude}</p>
                <ReactMapGL {...this.state.viewport}
                            onViewportChange={(viewport) => {
                                if (mounted) { this.setState({ viewport }) }
                            }}
                            mapboxApiAccessToken="pk.eyJ1Ijoicml0YS1hbWFudGU5OTU1IiwiYSI6ImNrbmEyZGpzYzBqcjcybm55Z2NyOTVkazMifQ.oRw17OIsKSA0CeIUG2UC1Q">

                    {this.state.planes.map( arm => (
                            <Marker key={arm.latitude} latitude={Number(arm.latitude)} longitude={Number(arm.longitude)}>
                                <img  width="20" height="20" src="../soldado.jpg" alt="Army Icon" />
                            </Marker>
                        )
                    )}
                </ReactMapGL>
            </div>
        );
    }
}

export default MapComponent