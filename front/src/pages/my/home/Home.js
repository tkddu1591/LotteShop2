import {Route} from "react-router-dom";
import MyNav from "../myNav";
import React from "react";

function Home() {
    return <>
        <Route path="/home" element={
            <div id="my">
                <MyNav></MyNav>
            </div>
        }></Route>


    </>


}

export default Home;