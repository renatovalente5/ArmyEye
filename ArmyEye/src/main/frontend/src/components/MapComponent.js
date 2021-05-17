import React, { useState } from "react";
import ReactMapGL, { Marker, Popup } from "react-map-gl";
import 'mapbox-gl/dist/mapbox-gl.css';


export default function MapComponent() {
    const [viewport, setViewport] = useState({
        latitude: 40.6412,
        longitude: -8.65362,
        width: "52vw",
        height: "67vh",
        zoom: 10
    });

    const [selectedPark, setSelectedPark] = useState(null);

    return (
        <div className='StoryList' >
            <div className='story-list-map' >
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
