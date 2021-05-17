import React, { useState, useEffect } from "react";
import ReactMapGL, { Marker, Popup } from "react-map-gl";
import 'mapbox-gl/dist/mapbox-gl.css';
import axios from "axios";


export default function MapComponent() {
    const [viewport, setViewport] = useState({
        latitude: 40.6412,
        longitude: -8.65362,
        width: "52vw",
        height: "67vh",
        zoom: 10
    });

    const [armys, setArmys] = useState("");


    useEffect(() => {
        try {
            axios.get("http://localhost:8080/map").then(response => {
                setArmys(response.data)
            });
        } catch (e) {
            console.log(e);
        }
    });

    async function loadData() {
        try {
            axios.get("http://localhost:8080/map").then(response => {
                this.setState({ planes: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }


    return (
        <div className='StoryList' >
            <div className='story-list-map' >
                <p>Army: {armys}</p>
                <ReactMapGL
                    {...viewport}
                    mapboxApiAccessToken={"pk.eyJ1Ijoicml0YS1hbWFudGU5OTU1IiwiYSI6ImNrbmEyZGpzYzBqcjcybm55Z2NyOTVkazMifQ.oRw17OIsKSA0CeIUG2UC1Q"}
                    onViewportChange={viewport => {
                        setViewport(viewport);
                    }}
                >
                    <Marker
                        key={"ola"}
                        latitude={40.6312}
                        longitude={-8.65492}
                    >

                        <img  width="20" height="20" src="../soldado.jpg" alt="Army Icon" />

                    </Marker>


                </ReactMapGL>
            </div>
        </div>
    );

}
